package com.organization.mvcproject.mgltask1.controller;

import com.organization.mvcproject.MGL_Task1.model.Game;
import com.organization.mvcproject.MGL_Task1.service.GameService;
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
    private GameService gameService;

    //TODO 1.0 RequestMapping URL should follow RESTful.
    @RequestMapping(value = "/game/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<Game>> fetchAllGames() {
        return new ResponseEntity<List<Game>>(gameService.retrieveAllGames(), HttpStatus.OK);
    }

    //TODO 1.0 RequestMapping URL should follow RESTful convention
    @RequestMapping(value = "/game/createGame", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createGame(@RequestBody Game game) {
        gameService.saveGame(game);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

}
