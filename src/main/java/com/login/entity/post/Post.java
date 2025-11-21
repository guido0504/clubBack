package com.login.entity.post;

import com.login.entity.tipoEvento.TipoEventoEntity;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String title;

    // Usamos @Lob para contenido potencialmente grande (el HTML del body)
    @Lob
    @Column(nullable = false)
    private String body;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tipo_evento_id")
    private TipoEventoEntity tipoEvento; // Noticias, Eventos, etc.

    @Column(length = 500)
    private String imageUrl;

    @Column(length = 500)
    private String videoUrl;

    @Column(nullable = false)
    private LocalDateTime createdAt; // Usamos LocalDateTime para manejar la fecha/hora de creación

    public Post(Long id, String title, String body, TipoEventoEntity section, String imageUrl, String videoUrl, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.tipoEvento = section;
        this.imageUrl = imageUrl;
        this.videoUrl = videoUrl;
        this.createdAt = createdAt;
    }

    public Post(String videoUrl, String imageUrl, TipoEventoEntity section, String body, String title) {
        this.videoUrl = videoUrl;
        this.imageUrl = imageUrl;
        this.tipoEvento = section;
        this.body = body;
        this.title = title;
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public TipoEventoEntity getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEventoEntity tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    // Constructor vacío
    public Post() {
        this.createdAt = LocalDateTime.now(); // Inicializar la fecha al crear
    }

    // Constructor con campos (opcional)

    // Getters y Setters para todos los campos...
    // (Debes generarlos con tu IDE, p. ej., Alt+Insert en IntelliJ)
}