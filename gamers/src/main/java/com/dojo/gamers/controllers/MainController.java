package com.dojo.gamers.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.dojo.gamers.models.Game;
import com.dojo.gamers.models.LoginUser;
import com.dojo.gamers.models.User;
import com.dojo.gamers.services.GameService;
import com.dojo.gamers.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class MainController {

	@Autowired
	private UserService uServ;
	@Autowired
	private GameService gServ;
    
    @GetMapping("/")
    public String index(Model model) {
    
       
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index.jsp";
    }
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
        
    	User user = uServ.register(newUser, result);
    	
        
        if(result.hasErrors()) {
            
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }
        
        session.setAttribute("userId", user.getId());
    
        return "redirect:/dashboard";
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
        
        User user = uServ.login(newLogin, result);
    
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }
    
        session.setAttribute("userId", user.getId());
    
        return "redirect:/dashboard";
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.setAttribute("userId", null);
    	return "redirect:/";
    }
    
    @GetMapping("/dashboard")
    public String dashboard(Model model, HttpSession session){
    	
    	if(session.getAttribute("userId") == null) {
    		return "redirect:/";
    	}
    	model.addAttribute("user", uServ.findById((Long)session.getAttribute("userId")));
    	model.addAttribute("allgames", gServ.getAllGames());
    	return "home.jsp";
    }
    
    @GetMapping("/games/new")
    public String createGame(@ModelAttribute("game") Game game, HttpSession session) {
    	if(session.getAttribute("userId") == null) {
    		return "redirect:/";
    	}
    	return "addGame.jsp";
    }
    
    @GetMapping("/games/{id}")
    public String gameDetails(@PathVariable("id")Long id,Model model, HttpSession session) {
    	model.addAttribute("game",gServ.getOneGame(id));
    	model.addAttribute("user", uServ.findById((Long)session.getAttribute("userId")));
    	return "reviewDetails.jsp";
    		
    }
    
    @PostMapping("/games")
    public String addGame(@Valid @ModelAttribute("game")Game game, BindingResult result) {
    	if(result.hasErrors()) {
    		return "addGame.jsp";
    	}
    	gServ.create(game);
    	return ("redirect:/dashboard");
    }
    
    @GetMapping("/games/{id}/edit")
    public String editGame(Model model,@PathVariable("id")Long id, HttpSession session) {
    	if(session.getAttribute("userId") == null) {
    		return "redirect:/";
    	}
    	model.addAttribute("game", gServ.getOneGame(id));
    	
    	return "edit.jsp";
    }
    
    @PutMapping("/games/{id}")
    public String updateGame(@Valid @ModelAttribute("game")Game game, BindingResult result, @PathVariable("id")Long id) {
    	if(result.hasErrors()) {
    		return "edit.jsp";
    	}
    	gServ.create(game);
    	return ("redirect:/dashboard");
    }
    
    @GetMapping("/delete/{id}")
    public String deleteGame(@PathVariable("id") Long id) {
    	Game game = gServ.getOneGame(id);
    	gServ.deleteGame(game);
    	return "redirect:/dashboard";
    }
    
}
    