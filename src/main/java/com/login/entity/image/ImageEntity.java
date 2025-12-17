package com.login.entity.image;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "images")
public class ImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String publicId;      // id interno de Cloudinary
    private String url;           // secure_url de Cloudinary
    private String originalName;  // nombre del archivo original

    private LocalDateTime createdAt;

    // Constructors
    public ImageEntity() {
    }

    public ImageEntity(String publicId, String url, String originalName) {
        this.publicId = publicId;
        this.url = url;
        this.originalName = originalName;
        this.createdAt = LocalDateTime.now();
    }

    public ImageEntity(ImageEntity imageEntity){
        this.id = imageEntity.getId();
        this.publicId = imageEntity.getPublicId();
        this.url = imageEntity.getUrl();
        this.originalName = imageEntity.getOriginalName();
        this.createdAt = imageEntity.getCreatedAt();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPublicId() {
        return publicId;
    }

    public void setPublicId(String publicId) {
        this.publicId = publicId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
