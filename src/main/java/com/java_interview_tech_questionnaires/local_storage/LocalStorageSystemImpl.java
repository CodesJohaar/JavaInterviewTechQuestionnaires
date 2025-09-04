package com.java_interview_tech_questionnaires.local_storage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

/**
 * @author RavikantS on Sept 01, 2025
 */
@Service
@Component
//@ConditionalOnProperty(prefix = "aws", name = "enabled", havingValue = "false", matchIfMissing = false)
public class LocalStorageSystemImpl implements LocalStorageSystem {
	
	public static final String TMP_PROFILE_IMAGE = "temp/profiles-images/";
	public static final String PROFILE_IMAGE = "profiles-images/";
	
	@Value("${upload.local.file.path}")
	private String localDirectory = "~/Desktop/Application/Storage/";
	
	@Value("${aws.bucket.filesize.image:5000000}")
	private long uploadFileImage = 5000000L;
	
	@Value("${aws.bucket.filesize.document:10000000}")
	private long uploadDocumentSize = 10000000L;
	
	@Override
	public void deleteFileFromS3Bucket(String fileName) {
		try {
			File localFile = new File(localDirectory + this.getDecryptKey(fileName));
			boolean isDeleted = localFile.delete();
			if (isDeleted) {
				System.out.println("Document deleted from local storage.");
			} else {
				System.out.println("Failed to delete file from local storage.");
			}
		} catch (Exception e) {
			System.out.println("Error while deleting the file from local storage.");
			throw new RuntimeException("Internal Server Error");
		}
	}
	
	@Override
	public byte[] retrieveFileBytes(String fileName) {
		String filePath = localDirectory + this.getDecryptKey(fileName);
		File file = new File(filePath);
		return this.convertFileIntoByteArray(file);
	}
	
	
	@Override
	public String getPreSignedUrl(String fileName, boolean isEmail) {
		try {
			URL fileURL = Paths.get(localDirectory + fileName).toUri().toURL();
			System.out.println("Local file Download URL : " + fileURL);
			return fileURL.toString();
		} catch (MalformedURLException e) {
			System.out.println("Exception while generating local resource URL : " + e.getMessage());
			throw new RuntimeException("Internal Server Error");
		}
	}
	
	private byte[] convertFileIntoByteArray(File file) {
		try {
			return Files.readAllBytes(file.toPath());
		} catch (Exception e) {
			System.out.println("Error while converting file into bytes.");
			throw new RuntimeException("Internal Server Error");
		}
	}
	
	@Override
	public InputStream retrieveFileAsBytes(String fileName) {
		String filePath = localDirectory + this.getDecryptKey(fileName);
		File file = new File(filePath);
		return new ByteArrayInputStream(this.convertFileIntoByteArray(file));
	}
	
	@Override
	public void fileCheck(String extension, MultipartFile document, boolean b) {
		if (!(extension.equalsIgnoreCase("jpg") || extension.equalsIgnoreCase("jpeg")
				|| extension.equalsIgnoreCase("png") || extension.equalsIgnoreCase("pdf"))) {
			System.out.println("Invalid file format" + extension);
			throw new RuntimeException("Invalid file format");
		}
		Long length = document.getSize();
		if ((length > uploadFileImage && b) || (length > uploadDocumentSize && !b)) {
			System.out.println("Invalid file Size" + length);
			throw new RuntimeException("Invalid file size");
		}
	}
	
	@Override
	public String getContentType(String extension) {
		if ((extension.equalsIgnoreCase("jpg") || extension.equalsIgnoreCase("jpeg")
				|| extension.equalsIgnoreCase("png"))) {
			return "image/" + extension;
		} else if (extension.equalsIgnoreCase("pdf")) {
			return "application/" + extension;
		} else if ("csv".equalsIgnoreCase(extension)) {
			return "application/" + extension;
		}
		return "";
	}
	
	@Override
	public String copyObject(String key) {
		try {
			String decryptedUrl = getDecryptKey(key);
			String[] split = decryptedUrl.split("\\\\");
			String destinationLoc = decryptedUrl.replace(TMP_PROFILE_IMAGE, PROFILE_IMAGE);
			// Check the required path is exists or not.
			this.createDirectoryInLocal(split[0]);
			this.createDirectoryInLocal(PROFILE_IMAGE);
			File sourceFile = new File(localDirectory + decryptedUrl);
			File destinationFile = new File(localDirectory + destinationLoc);
			// Copy the existing file in local.
			Files.copy(sourceFile.toPath(), destinationFile.toPath());
			return getEncryptedKey(destinationLoc);
		} catch (IOException e) {
			System.out.println("Error while cloning the file in local.");
			e.printStackTrace();
			throw new RuntimeException("Internal Server Error");
		}
	}
	
	@Override
	public String getDecryptKey(String fileName) {
		byte[] decryptedData = Base64.getDecoder().decode(fileName.getBytes());
		String decryptedText = new String(decryptedData, StandardCharsets.UTF_8);
		return decryptedText;
	}
	
	private String getEncryptedKey(String fileName) {
		String encodeToString = Base64.getEncoder().encodeToString(fileName.getBytes());
		System.out.println("Encrypted File Name :" + encodeToString);
		return encodeToString;
	}
	
	@Override
	public String uploadFileToS3Bucket(String fileName, String path) {
		try {
			File file = new File(fileName);
			String fileKey = path + File.separator + file.getName();
			return fileName;
		} catch (Exception e) {
			System.out.println("Error saving blacklisted file in local.");
			throw new RuntimeException("Internal Server Error");
		}
	}
	
	@Override
	public String uploadFileToS3Bucket(MultipartFile image, String path, Long userId) {
		try {
			boolean isProfileImageS3Type = (PROFILE_IMAGE.equals(path));
			String extension = isProfileImageS3Type ? "png" : StringUtils.getFilenameExtension(image.getOriginalFilename());
			String fileName = isProfileImageS3Type ? path + "/" + userId + "_profileimage." + extension
					: path + File.separator + userId + "_" + image.getOriginalFilename();
			fileCheck(extension, image, isProfileImageS3Type);
			String fileFormat = getContentType(extension);
			this.saveDocumentInLocalStorage(image, path, fileName);
			System.out.println("To Encrypt Data : " + fileName);
			return getEncryptedKey(fileName);
		} catch (IOException e) {
			System.out.println("Error while saving image in local.");
			throw new RuntimeException("Internal Server Error");
		}
	}
	
	@Override
	public String uploadFileToS3Bucket(MultipartFile identityFile, byte[] bytes, String path, Long userId, String identityTypeName) {
		try {
			String extension = StringUtils.getFilenameExtension(identityFile.getOriginalFilename());
			String fileName = path + File.separator + userId + "_" + identityTypeName + "." + extension;
			fileCheck(extension, identityFile, PROFILE_IMAGE.equals(path));
			String fileFormat = getContentType(extension);
			this.saveDocumentInLocalStorage(identityFile, path, fileName);
			return getEncryptedKey(fileName);
		} catch (IOException e) {
			System.out.println("Error while saving image in local.");
			throw new RuntimeException("Internal Server Error");
		}
	}
	
	@Override
	public String uploadImportFileToS3Bucket(MultipartFile document, String path) {
		try {
			String extension = StringUtils.getFilenameExtension(document.getOriginalFilename());
			String fileName = path + File.separator + "_" + document.getOriginalFilename();
			String fileFormat = getContentType(extension);
			this.saveDocumentInLocalStorage(document, path, fileName);
			return getEncryptedKey(fileName);
		} catch (IOException e) {
			System.out.println("Error while saving image in local.");
			throw new RuntimeException("Internal Server Error");
		}
	}
	
	private void saveDocumentInLocalStorage(MultipartFile document, String path, String fileName) throws IOException {
		//Check if directory exists or not.
		this.createDirectoryInLocal(path);
		System.out.println("Uploading document in local storage.");
		File newFile = new File(localDirectory + fileName);
		FileOutputStream writer = new FileOutputStream(newFile);
		writer.write(document.getBytes());
		writer.close();
		System.out.println("File successfully saved in local path : " + localDirectory + path);
	}
	
	private boolean createDirectoryInLocal(String newPath) {
		try {
			File newDirectory = new File(localDirectory + newPath);
			if (Boolean.FALSE.equals(newDirectory.exists())) {
				return newDirectory.mkdirs();
			}
			return false;
		} catch (Exception e) {
			System.out.println("Error while creating new directory : " + localDirectory + newPath);
			throw new RuntimeException("Internal Server Error");
		}
	}
}
