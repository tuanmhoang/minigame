package com.tuanhm.minigame.beans;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.tuanhm.minigame.enums.GameLevel;
import com.tuanhm.minigame.service.games.GameService;

@ManagedBean
public class GameBean {
	@Autowired
	private GameService gameService;
	
	private GameLevel currentLevel;
	private int currentPoint;
	private String charactersToDisplay;

	private String playerWord;
	private String chosenWord;
	private List<String> dataLevel;
	private int pointsToLevelUp;

	@PostConstruct
	public void init() {
		initPage();
	}

	private void initPage() {
		currentLevel = GameLevel.GAME_LEVEL_ONE;
		currentPoint = 0;
		pointsToLevelUp = GameLevel.GAME_LEVEL_TWO.getScoreToUnlock();
		loadDataLevel();
		resetTheQuestionedWord();
	}

	public void checkResult() {
		if (dataLevel.contains(playerWord.toLowerCase())) {
			currentPoint++;
			checkForLevel();
			if (currentPoint != 0 && currentPoint - currentLevel.getScoreToUnlock() == 0) {
				loadDataLevel();
			}
			showCorrectMessage();
		} else {
			showIncorrectMessage();
		}
		resetTheQuestionedWord();
	}

	private void loadDataLevel() {
		dataLevel = gameService.loadDataLevel(currentLevel);
	}

	private void showCorrectMessage() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Correct", "Well done!"));
	}

	private void showIncorrectMessage() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Incorrect", "Please try again!"));
	}

	private void resetTheQuestionedWord() {
		playerWord = StringUtils.EMPTY;
		chosenWord = gameService.getChosenWord(currentLevel);
		charactersToDisplay = String.join(" , ", gameService.displayChosenWordAsCharacters(chosenWord));
	}

	private void checkForLevel() {
		if (currentPoint >= GameLevel.GAME_LEVEL_FIVE.getScoreToUnlock()) {
			currentLevel = GameLevel.GAME_LEVEL_FIVE;
		} else {
			if (currentPoint >= GameLevel.GAME_LEVEL_FOUR.getScoreToUnlock()) {
				currentLevel = GameLevel.GAME_LEVEL_FOUR;
				pointsToLevelUp = GameLevel.GAME_LEVEL_FIVE.getScoreToUnlock() - currentPoint;
			} else {
				if (currentPoint >= GameLevel.GAME_LEVEL_THREE.getScoreToUnlock()) {
					currentLevel = GameLevel.GAME_LEVEL_THREE;
					pointsToLevelUp = GameLevel.GAME_LEVEL_FOUR.getScoreToUnlock() - currentPoint;
				} else {
					if (currentPoint >= GameLevel.GAME_LEVEL_TWO.getScoreToUnlock()) {
						currentLevel = GameLevel.GAME_LEVEL_TWO;
						pointsToLevelUp = GameLevel.GAME_LEVEL_THREE.getScoreToUnlock() - currentPoint;
					} else {
						currentLevel = GameLevel.GAME_LEVEL_ONE;
						pointsToLevelUp = GameLevel.GAME_LEVEL_TWO.getScoreToUnlock() - currentPoint;
					}
				}
			}
		}
	}

	public void resetGame() {
		initPage();
	}

	public GameLevel getCurrentLevel() {
		return currentLevel;
	}

	public void setCurrentLevel(GameLevel currentLevel) {
		this.currentLevel = currentLevel;
	}

	public int getCurrentPoint() {
		return currentPoint;
	}

	public void setCurrentPoint(int currentPoint) {
		this.currentPoint = currentPoint;
	}

	public String getCharactersToDisplay() {
		return charactersToDisplay;
	}

	public void setCharactersToDisplay(String charactersToDisplay) {
		this.charactersToDisplay = charactersToDisplay;
	}

	public GameService getGameService() {
		return gameService;
	}

	public String getPlayerWord() {
		return playerWord;
	}

	public void setPlayerWord(String playerWord) {
		this.playerWord = playerWord;
	}

	public void setGameService(GameService gameService) {
		this.gameService = gameService;
	}

	public String getChosenWord() {
		return chosenWord;
	}

	public void setChosenWord(String chosenWord) {
		this.chosenWord = chosenWord;
	}

	public List<String> getDataLevel() {
		return dataLevel;
	}

	public void setDataLevel(List<String> dataLevel) {
		this.dataLevel = dataLevel;
	}

	public int getPointsToLevelUp() {
		return pointsToLevelUp;
	}

	public void setPointsToLevelUp(int pointsToLevelUp) {
		this.pointsToLevelUp = pointsToLevelUp;
	}
}
