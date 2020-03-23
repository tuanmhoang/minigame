package com.tuanhm.minigame.service.load;

import java.io.IOException;
import java.util.List;

public interface LoadLevelService {

	/**
	 * To load level data.
	 * @throws IOException
	 */
	List<String> load() throws IOException;

}
