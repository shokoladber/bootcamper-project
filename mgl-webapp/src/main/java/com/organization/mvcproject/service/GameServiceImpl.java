package com.organization.mvcproject.service;

import com.organization.mvcproject.api.dao.GameDAO;
import com.organization.mvcproject.api.service.GameService;
import com.organization.mvcproject.model.GameImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GameServiceImpl implements GameService {

	@Autowired
	private GameDAO gameDAOImpl;

	@Override
	public List<GameImpl> retrieveAllGames() {
		return gameDAOImpl.findAllGames();
	}

	@Override
	public List<GameImpl> retrieveGamesByGenre(String genre) {
		return gameDAOImpl.findGamesByGenre(genre);
	}

	@Override
	public GameImpl saveGame(GameImpl game) {
		gameDAOImpl.saveGame(game);
		return game;
	}

	@Override
	public GameImpl retrieveGameByName(String gameName) {
		GameImpl game = gameDAOImpl.findGameByName(gameName);

		System.out.println("GameSeriveImpl.retrieveGameByName() = " + game);

		return game;
	}

	@Override
	public void deleteGame(long id) {
		gameDAOImpl.deleteGame(id);
	}

}