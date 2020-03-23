package com.tuanhm.minigame.service.load;

import java.io.IOException;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import com.tuanhm.minigame.enums.GameLevel;
import com.tuanhm.minigame.service.common.FileService;

public class LoadLevelThree implements LoadLevelService {
	private FileService fileService = new FileService();

	@Cacheable("dataLevelThree")
	@Override
	public List<String> load() throws IOException {
		return fileService.loadDataFromFile(GameLevel.GAME_LEVEL_THREE.getFileName());

	}

}
