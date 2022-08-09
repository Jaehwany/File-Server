package com.example.file.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.file.dto.FileDto;
import com.example.file.entity.FileEntity;
import com.example.file.exception.FileStorageException;
import com.example.file.exception.MyFileNotFoundException;
import com.example.file.property.FileStorageProperties;
import com.example.file.repository.FileRepository;

@Service
public class FileStorageService {
    private FileStorageService fileStorageService;
    @Autowired
    private FileRepository fileRepository;
    private final Path fileStorageLocation;

    public FileStorageService(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new FileStorageException("디렉토리 생성 불가", ex);
        }
    }

    public int addFile(String fileName,String fileDownloadUri,String fileType, long size) {
    	FileDto fileDto = new FileDto();

    	fileDto.setFileDownloadUri(fileDownloadUri);
    	fileDto.setFileName(fileName);
    	fileDto.setFileType(fileType);
    	fileDto.setSize(size);
    	fileDto.setCreatedTime(new Date());
    	FileEntity saved = fileRepository.save(fileDto.toEntity());
    	
    	return saved.getFileSeq();
    }
    
    public String storeFile(MultipartFile file) {
        // 파일 이름 일반화
        String fileName = StringUtils.cleanPath(file.getOriginalFilename()); 
        try {
            if(fileName.contains("..")) {
                throw new FileStorageException("파일 이름에 유효하지 않은 문자가 있음" + fileName);
            }
            //스토리지에 파일 저장하기
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return fileName;
        } catch (IOException ex) {
            throw new FileStorageException("저장할 수 없음" + fileName , ex);
        }
    }

    public Resource loadFileAsResource(int fileSeq) {
        try {
        	FileEntity file = fileRepository.findById(fileSeq).orElse(null);
            Path filePath = this.fileStorageLocation.resolve(file.getFileName()).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                return resource;
            } else {
                throw new MyFileNotFoundException("파일 찾을 수 없음" );
            }
        } catch (MalformedURLException ex) {
            throw new MyFileNotFoundException("파일 찾을 수 없음" , ex);
        }
    }
}