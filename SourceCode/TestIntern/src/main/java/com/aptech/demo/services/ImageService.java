package com.aptech.demo.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class ImageService {

	private final String uploadDir = "uploads/";

	public ImageService() {
		
		File uploadDirectory = new File(uploadDir);
		if (!uploadDirectory.exists()) {
			uploadDirectory.mkdirs();
		}
	}

	public String saveImage(MultipartFile file) throws IOException {
		if (file.isEmpty()) {
			throw new IOException("File is empty");
		}

		
		String originalFilename = file.getOriginalFilename();
		String fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));
		String uniqueFileName = UUID.randomUUID().toString() + fileExtension;

		Path filePath = Paths.get(uploadDir + uniqueFileName);
		Files.write(filePath, file.getBytes());

		return uniqueFileName; // 
	}

}
