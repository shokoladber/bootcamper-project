package com.organization.mvcproject.controller;

import com.organization.mvcproject.model.GameImpl;
import com.organization.mvcproject.api.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private GameService gameServiceImpl;

    @RequestMapping(value = "/gamesLibrary", method = RequestMethod.GET)
    public ResponseEntity<List<GameImpl>> fetchAllGames() {
        return new ResponseEntity<>(gameServiceImpl.retrieveAllGames(), HttpStatus.OK);
    }

    @RequestMapping(value = "/games", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createGame(@RequestBody GameImpl game) {
        gameServiceImpl.saveGame(game);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
