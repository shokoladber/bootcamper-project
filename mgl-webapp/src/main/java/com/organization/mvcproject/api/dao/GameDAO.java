package com.organization.mvcproject.api.dao;

import com.organization.mvcproject.model.GameImpl;

import java.util.List;

public interface GameDAO {

    List<GameImpl> findAllGames();

    GameImpl findGameById(Long id);

    void deleteGame(Long id);

    GameImpl saveGame(GameImpl game);

}
