package com.mockproject.freetutsproject.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.*;

@Component
@PropertySource("classpath:fileStorage.properties")
public class FileUtil {

	@Value("${content-file-path}")
	String contentStoragePath;

	@Value("${image-path}")
	String imageStoragePath;

	public String writeContentToHTMLOnHardDisk(String content, String name) throws IOException {
		String fileName = StringUtils.cleanPath(name + ".html");
		Path storage = Paths.get(contentStoragePath);
		if (Files.notExists(storage)){
			Files.createDirectories(storage);
		}

		Path filePath = storage.resolve(fileName);
		Files.write(filePath, content.getBytes());

		return fileName;
	}
	
	public String updateContentToHTMLOnHardDisk(String content, Long id, String name, String oldFileName) throws IOException {
		String fileName = StringUtils.cleanPath(name + "." + id + ".html");
		Path storage = Paths.get(contentStoragePath);
		if (Files.notExists(storage)){
			Files.createDirectories(storage);
		}

		Path filePath = storage.resolve(fileName);
		Path oldFilePath = storage.resolve(oldFileName);
		
		Files.write(filePath, content.getBytes());
		Files.delete(oldFilePath);

		return fileName;
	}

	public String writeImageHardDisk(MultipartFile imagePart) throws IOException {
		String imageName = StringUtils.cleanPath(imagePart.getOriginalFilename());
		Path storage = Paths.get(imageStoragePath);
		if (Files.notExists(storage)){
			Files.createDirectories(storage);
		}

		try (InputStream in = imagePart.getInputStream()) {
			Path imagePath = storage.resolve(imageName);
			if (!Files.exists(imagePath)) {
				Files.copy(in, imagePath, StandardCopyOption.REPLACE_EXISTING);
			}
		}
		return imageName;
	}
}
