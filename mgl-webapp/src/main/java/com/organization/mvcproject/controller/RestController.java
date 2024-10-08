package com.organization.mvcproject.controller;

import com.organization.mvcproject.model.GameImpl;
import com.organization.mvcproject.api.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private GameService gameServiceImpl;

    @RequestMapping(value = "/gamesLibrary", method = RequestMethod.GET)
    public ResponseEntity<List<GameImpl>> fetchAllGames() {

        System.out.println("Get request to /gamesLibrary");

        return new ResponseEntity<>(gameServiceImpl.retrieveAllGames(), HttpStatus.OK);
    }

    @RequestMapping(value = "/games", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveGame(@RequestBody GameImpl game) {
        gameServiceImpl.saveGame(game);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/games/{id}/delete", method = RequestMethod.POST)
    public ResponseEntity<List<GameImpl>> deleteGame(@PathVariable Long id) {
        gameServiceImpl.deleteGame(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
