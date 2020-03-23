package com.tuanhm.minigame.service.games;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.tuanhm.minigame.enums.GameLevel;
import com.tuanhm.minigame.service.load.LevelFactory;
import com.tuanhm.minigame.service.load.LoadLevelService;

@Component("gameService")
public class GameService {

	public String getChosenWord(GameLevel level) {
		LevelFactory levelFactory = new LevelFactory();
		LoadLevelService loadLevelService = levelFactory.getLoadService(level);
		List<String> data;
		try {
			data = loadLevelService.load();
			return data.get(getRandomIndex(data.size()));
		} catch (IOException e) {
			e.printStackTrace();
			return "Hi! Something is wrong!";
		}
	}
	
	public List<String> loadDataLevel(GameLevel level){
		LevelFactory levelFactory = new LevelFactory();
		LoadLevelService loadLevelService = levelFactory.getLoadService(level);
		try {
			return loadLevelService.load();
		} catch (IOException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	public String[] displayChosenWordAsCharacters(String chosenWord) {
		String[] strArray = convertStringToCharArray(chosenWord);
		shuffleArray(strArray);
		return strArray;
	}

	private String[] convertStringToCharArray(String chosenWord) {
		return chosenWord.split(StringUtils.EMPTY);
	}

	private int getRandomIndex(int size) {
		Random rand = new Random();
		return rand.nextInt(size);
	}

	private void shuffleArray(String[] array) {
		Random rnd = ThreadLocalRandom.current();
		for (int i = array.length - 1; i > 0; i--) {
			int index = rnd.nextInt(i + 1);
			String ch = array[index];
			array[index] = array[i];
			array[i] = ch;
		}
	}

}
