package com.example.photozclone.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.Column;
import javax.persistence.Lob;

@Table(name = "PHOTOZ")
public class Photo {

    @Id
    private Integer id;

    @NotEmpty
    private String fileName;

    private String contentType;

    @JsonIgnore
    @Lob
    @Column(name = "FILE_CONTENT", columnDefinition="BLOB")
    private byte[] fileContent;

    public Photo() {
    }

    public Photo(Integer id, String fileName) {
        this.id = id;
        this.fileName = fileName;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getFileContent() {
        return fileContent;
    }

    public void setFileContent(byte[] fileContent) {
        this.fileContent = fileContent;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}
