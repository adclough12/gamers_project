package com.dojo.gamers.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dojo.gamers.models.Game;
import com.dojo.gamers.repositories.GameRepository;

@Service
public class GameService {

	@Autowired
	private GameRepository gRepo;
	
	public Game findById(Long id) {
		
		Optional<Game> result = gRepo.findById(id);
		if(result.isPresent()) {
			return result.get();
		}
		
		return null;
	}
	public Game getOneGame(Long id) {
		Optional<Game> game = gRepo.findById(id);
		if(game.isPresent()) {
			return game.get();
		} else {
			return null;
		}
	}

	public List<Game> getAllGames() {
		return gRepo.findAll();
	}
	
	
	public Game create(Game game) {
		return gRepo.save(game);
	}
	public void deleteGame(Game game) {
		gRepo.delete(game);
	}
	
}