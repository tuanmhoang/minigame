package com.tuanhm.minigame.enums;

import java.util.Optional;

public enum GameLevel {

	GAME_LEVEL_ONE(1, 0, "levelOne.txt"), 
	GAME_LEVEL_TWO(2, 2, "levelTwo.txt"),
	GAME_LEVEL_THREE(3,5, "levelThree.txt"), 
	GAME_LEVEL_FOUR(4, 30, "levelFour.txt"),
	GAME_LEVEL_FIVE(5, 40, "levelFive.txt");

	private int level;
	private int scoreToUnlock;
	private String fileName;

	private GameLevel(int level, int scoreToUnlock, String fileName) {
		this.level = level;
		this.scoreToUnlock = scoreToUnlock;
		this.fileName = fileName;
	}

	public static Optional<GameLevel> fromLevelToEnum(int level) {
		GameLevel[] values = GameLevel.values();
		for (GameLevel gameLevel : values) {
			if (gameLevel.level == level) {
				return Optional.of(gameLevel);
			}
		}
		return Optional.empty();
	}

	public String getFileName() {
		return fileName;
	}

	public int getLevel() {
		return level;
	}

	public int getScoreToUnlock() {
		return scoreToUnlock;
	}

}
