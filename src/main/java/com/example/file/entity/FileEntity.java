package com.example.file.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder @AllArgsConstructor @NoArgsConstructor
@Entity
@Getter @Setter
@ToString
@Table(name="tb_file")
public class FileEntity {
		@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="file_seq")
		private int fileSeq;
	  
	  	@Column(name="file_name")
	    private String fileName;
	    
	    @Column(name="file_download_uri")
	  	private String fileDownloadUri;
	    
	    @Column(name="file_type")
	    private String fileType;
	    
	    @Column(name="size")
	    private long size;
	    
		@Temporal(TemporalType.TIMESTAMP)
	    @Column(name="file_created_at")
	    private Date createdTime;


	    public FileEntity(String fileName, String fileDownloadUri, String fileType, long size) {
	        this.fileName = fileName;
	        this.fileDownloadUri = fileDownloadUri;
	        this.fileType = fileType;
	        this.size = size;
	    }
}
