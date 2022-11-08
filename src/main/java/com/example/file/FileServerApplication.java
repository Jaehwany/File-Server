package com.example.file;

import com.example.file.property.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
    FileStorageProperties.class
})
public class FileServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(FileServerApplication.class, args);
	}

}
