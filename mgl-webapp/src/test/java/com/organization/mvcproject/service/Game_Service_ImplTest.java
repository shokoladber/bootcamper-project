package com.organization.mvcproject.service;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


import com.organization.mvcproject.api.service.GameService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import com.organization.mvcproject.model.GameImpl;
import com.organization.mvcproject.config.MvcConfiguration;

@RunWith(JUnitPlatform.class)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = MvcConfiguration.class)
@WebAppConfiguration
@TestInstance(Lifecycle.PER_CLASS)
class Game_Service_ImplTest {
	
	
	@Autowired
	private GameService gameServiceImplUnderTest;
	
	private static GameImpl testGame = createGame(1);
	
	private  static final String TEST_GENRE = "Test Genre";
	private static GameImpl createGame(Integer number) {
		GameImpl game = new GameImpl();
		 game.setName("Testing Game Name " + String.valueOf(number));
		 game.setGenre(TEST_GENRE);
		 return game;
	}
	
	private static List<GameImpl> gamesToRemoveAfterTest = new ArrayList<>();
	
	@BeforeAll
	@Test
	void saveGameServiceSavesAndUpdatesGame() {
		if(gamesToRemoveAfterTest.isEmpty()) {
			GameImpl game = gameServiceImplUnderTest.saveGame(testGame);
			Assertions.assertNotNull(game.getId());
			
			//updates 
			game.setName("Testing Game Name Updated" );
			testGame = gameServiceImplUnderTest.saveGame(game);
			assertEquals(game, testGame);	
			gamesToRemoveAfterTest.add(testGame);
			//the saveGame works, save another game to setup list operation tests
			gamesToRemoveAfterTest.add(gameServiceImplUnderTest.saveGame(createGame(2)));
		}
	}
	
	@AfterAll
	@Test
	void deleteGameWorksAndCleanupServiceTest() {
		fail("Not yet implemented.");
	}
	
	
	@Test
	void findGameByIdReturnsTheGame() {
		fail("Not yet implemented.");
	}

	
	@Test
  	void retrieveAllGamesServiceReturnsGames() {
		List<GameImpl> games = gameServiceImplUnderTest.retrieveAllGames();
		assertNotNull(games);
		assertTrue(games.size() >= 2 );
	}
	
	
	@Test
	void retrieveGamesByGenre() {
		fail("Not yet implemented.");
	}
	
	
	


}
