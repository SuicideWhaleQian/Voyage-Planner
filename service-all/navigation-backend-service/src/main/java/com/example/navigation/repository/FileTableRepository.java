package com.example.navigation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.navigation.entity.FileTable;

public interface FileTableRepository extends JpaRepository<FileTable,Integer> {

}
