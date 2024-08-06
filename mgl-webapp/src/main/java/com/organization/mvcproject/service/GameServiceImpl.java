package com.organization.mvcproject.service;

import com.organization.mvcproject.api.dao.GameDAO;
import com.organization.mvcproject.api.service.GameService;
import com.organization.mvcproject.dao.GameDAOImpl;
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
	public GameImpl saveGame(GameImpl game) {
		return gameDAOImpl.saveGame(game);
	}

	@Override
	public Void deleteGame() {
		return null;
	}


}