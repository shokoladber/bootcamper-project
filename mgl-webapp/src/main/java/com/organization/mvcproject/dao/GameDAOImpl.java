package com.organization.mvcproject.dao;

import com.organization.mvcproject.api.dao.GameDAO;
import com.organization.mvcproject.model.GameImpl;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class GameDAOImpl implements GameDAO {
    public static Long gameId = new Long(0);
    public static Long companyId = new Long(0);
    public static List<GameImpl> games = new ArrayList<>();

    static {
        games = populateGames();
    }

    private static List<GameImpl> populateGames() {

        GameImpl game1 = new GameImpl();
        game1.setId(++gameId);
        game1.setGenre("Sport");
        game1.setName("Rocket League");

        GameImpl game2 = new GameImpl();
        game2.setId(++gameId);
        game2.setGenre("Shooter");
        game2.setName("Halo 3");

        GameImpl game3 = new GameImpl();
        game3.setId(++gameId);
        game3.setGenre("MMORPG");
        game3.setName("Runescape");

        games.add(game1);
        games.add(game2);
        games.add(game3);

        return games;
    }

    @Override
    public List<GameImpl> findAllGames() {
        return games;
    }

    @Override
    public List<GameImpl> findGamesByGenre(String genre) {
        return games
                .stream()
                .filter(game -> game.getGenre().equals(genre))
                .collect(Collectors.toList());
    }

    @Override
    public GameImpl findGameById(Long gameId){
        for(GameImpl game: games){
            if(gameId.equals(game.getId())){
                return game;
            }
        }
        return null; //if no game found
    }

    @Override
    public void deleteGame(Long gameId) {
        for(GameImpl game: games){
            if (gameId.equals(game.getId())){
                games.remove(game);
            }
        }
    }

    @Override
    public void saveGame(GameImpl game) {
        if(game.getId() != null){
            for(GameImpl existingGame : games){
                if (game.getId().equals(existingGame.getId())){
                    existingGame.setName(game.getName()); //update name of existing game
                    existingGame.setGenre(game.getGenre()); //update genre of existing game
                }
            }
        }
        //if game not found, add new game to list
        game.setId(++gameId);
        games.add(game);
    }
}
