package com.organization.mvcproject.service;

import com.organization.mvcproject.api.service.GameService;
import com.organization.mvcproject.model.GameImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {
	@Override
	public List<GameImpl> retrieveAllGames() {
		return List.of();
	}

	@Override
	public GameImpl saveGame(GameImpl game) {
		return null;
	}

	@Override
	public Void deleteGame() {
		return null;
	}


}