package com.example.navigation.entity;

import org.hibernate.annotations.Comment;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_files")
@Comment("文件表")
public class FileTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("文件Id")
    private Integer fileId;
    @Comment("网络路径")
    private String path;
    @Comment("本地路径")
    private String localPath;
    @Comment("文件类型")
    private String type;

    protected FileTable() {

    }

    public FileTable(String path, String localPath, String type) {
        this.path = path;
        this.localPath = localPath;
        this.type = type;
    }

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getLocalPath() {
        return localPath;
    }

    public void setLocalPath(String localPath) {
        this.localPath = localPath;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
