package com.example.file.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.example.file.entity.FileEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class FileDto {
		private int fileSeq;
	    private String fileName;
	    private String fileDownloadUri;
	    private String fileType;
	    private long size;
	    private Date createdTime;
	    
	    public FileDto(int fileSeq,String fileName, String fileDownloadUri, String fileType, long size) {
	        this.fileSeq=fileSeq;
	    	this.fileName = fileName;
	        this.fileDownloadUri = fileDownloadUri;
	        this.fileType = fileType;
	        this.size = size;
	    }
	    
	    @Builder
		public FileDto(int fileSeq, String fileName, String fileDownloadUri, String fileType, long size,
				Date createdTime) {
			super();
			this.fileSeq = fileSeq;
			this.fileName = fileName;
			this.fileDownloadUri = fileDownloadUri;
			this.fileType = fileType;
			this.size = size;
			this.createdTime = createdTime;
		}
	    
	    public FileEntity toEntity(){
	        return FileEntity.builder()
	                .fileSeq(fileSeq)
	                .fileName(fileName)
	                .fileDownloadUri(fileDownloadUri)
	                .fileType(fileType)
	                .size(size)
	                .createdTime(createdTime)
	                .build();
	    }

	    
}
