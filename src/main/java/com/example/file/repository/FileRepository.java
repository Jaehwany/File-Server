package com.example.file.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.file.entity.FileEntity;

@Repository
public interface FileRepository extends JpaRepository<FileEntity, Integer> {



}
