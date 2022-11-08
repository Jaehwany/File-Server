package com.example.file.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class FileDto {
	    private String fileName;
	    private String fileDownloadUri;
	    private String fileType;
	    private long size;
	    
	    public FileDto(String fileName, String fileDownloadUri, String fileType, long size) {
	    	this.fileName = fileName;
	        this.fileDownloadUri = fileDownloadUri;
	        this.fileType = fileType;
	        this.size = size;
	    }
	    
}
