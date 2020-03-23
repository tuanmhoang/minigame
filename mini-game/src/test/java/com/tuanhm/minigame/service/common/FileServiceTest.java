package com.tuanhm.minigame.service.common;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import com.tuanhm.minigame.enums.GameLevel;
import com.tuanhm.minigame.service.common.FileService;

public class FileServiceTest {
	
	private FileService fileService = new FileService();
	
	@Test
	public void loadFileLevelOne_withFileName_shouldSuccessful() throws Exception {
		int expectedSize = 103;
		assertEquals(expectedSize, fileService.loadDataFromFile(GameLevel.GAME_LEVEL_ONE.getFileName()).size()); 
	}
	
	@Test
	public void loadFileLevelTwo_withFileName_shouldSuccessful() throws Exception {
		int expectedSize = 978;
		assertEquals(expectedSize, fileService.loadDataFromFile(GameLevel.GAME_LEVEL_TWO.getFileName()).size()); 
	}
	
	@Test
	public void loadFileLevelThree_withFileName_shouldSuccessful() throws Exception {
		int expectedSize = 478;
		assertEquals(expectedSize, fileService.loadDataFromFile(GameLevel.GAME_LEVEL_THREE.getFileName()).size()); 
	}
	
	@Test
	public void loadFileLevelFour_withFileName_shouldSuccessful() throws Exception {
		int expectedSize = 346;
		assertEquals(expectedSize, fileService.loadDataFromFile(GameLevel.GAME_LEVEL_FOUR.getFileName()).size()); 
	}
	
	@Test
	public void loadFileLevelFive_withFileName_shouldSuccessful() throws Exception {
		int expectedSize = 1186;
		assertEquals(expectedSize, fileService.loadDataFromFile(GameLevel.GAME_LEVEL_FIVE.getFileName()).size()); 
	}

}
