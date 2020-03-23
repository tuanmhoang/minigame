package com.tuanhm.minigame.service.common;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.ResourceUtils;

public class FileService {

	public List<String> loadDataFromFile(String fileName) throws IOException {
		List<String> data = new ArrayList<>();
		File file = ResourceUtils.getFile("classpath:gameLevel/" + fileName);
		data = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
		return data;
	}
}
