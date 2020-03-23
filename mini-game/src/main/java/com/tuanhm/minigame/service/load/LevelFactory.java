package com.tuanhm.minigame.service.load;

import com.tuanhm.minigame.enums.GameLevel;

public class LevelFactory {

	public LoadLevelService getLoadService(GameLevel level) {
		switch (level) {
		case GAME_LEVEL_TWO:
			return new LoadLevelTwo();
		case GAME_LEVEL_THREE:
			return new LoadLevelThree();
		case GAME_LEVEL_FOUR:
			return new LoadLevelFour();
		case GAME_LEVEL_FIVE:
			return new LoadLevelFive();
		default:
			return new LoadLevelOne();
		}
	}

}
