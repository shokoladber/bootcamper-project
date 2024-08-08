package com.organization.mvcproject.api.service;

import java.util.List;

import com.organization.mvcproject.api.model.Game;
import com.organization.mvcproject.model.GameImpl;

public interface GameService {

	List<GameImpl> retrieveAllGames();
	
	List<GameImpl> retrieveGamesByGenre(String genre);

	GameImpl saveGame(GameImpl game);

	void deleteGame(long id);


}
