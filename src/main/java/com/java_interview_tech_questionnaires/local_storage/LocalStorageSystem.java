package com.java_interview_tech_questionnaires.local_storage;

import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 * @author RavikantS on Sept 01, 2025
 */
public interface LocalStorageSystem {
	void deleteFileFromS3Bucket(String fileName);
	byte[] retrieveFileBytes(String fileName);
	String getPreSignedUrl(String fileName, boolean isEmail);
	InputStream retrieveFileAsBytes(String fileName);
	void fileCheck(String extension, MultipartFile document, boolean b);
	String getContentType(String extension);
	String copyObject(String key);
	String getDecryptKey(String fileName);
	String uploadFileToS3Bucket(String fileName, String type);
	String uploadFileToS3Bucket(MultipartFile image, String type, Long userId);
	String uploadFileToS3Bucket(MultipartFile identityFile, byte[] bytes, String identity, Long userId, String identityTypeName);
	String uploadImportFileToS3Bucket(MultipartFile document, String type);
}
