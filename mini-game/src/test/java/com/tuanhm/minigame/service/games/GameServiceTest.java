package com.tuanhm.minigame.service.games;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.tuanhm.minigame.enums.GameLevel;
public class GameServiceTest {

	private GameService gameService = new GameService();
	

	@Test
	public void displayChosenWordAsCharacters_should_correct() throws Exception {
		String expectedWord = "hello";
		String[] chosenWordAsCharArray = gameService.displayChosenWordAsCharacters(expectedWord);
		// check for length
		assertEquals(5, chosenWordAsCharArray.length);
		// check for all characters if they exist in word
		for (String str : chosenWordAsCharArray) {
			assertTrue(expectedWord.indexOf(str) >= 0);
		}
	}

	@Test
	public void loadDataLevel_should_correct() throws Exception {
		assertEquals(103, gameService.loadDataLevel(GameLevel.GAME_LEVEL_ONE).size());
		assertEquals(978, gameService.loadDataLevel(GameLevel.GAME_LEVEL_TWO).size());
		assertEquals(478, gameService.loadDataLevel(GameLevel.GAME_LEVEL_THREE).size());
		assertEquals(346, gameService.loadDataLevel(GameLevel.GAME_LEVEL_FOUR).size());
		assertEquals(1186, gameService.loadDataLevel(GameLevel.GAME_LEVEL_FIVE).size());
	}

}
