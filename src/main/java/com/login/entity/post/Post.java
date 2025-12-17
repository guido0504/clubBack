package com.login.entity.post;

import com.login.entity.image.ImageEntity;
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

    @ManyToOne()
    @JoinColumn(name = "tipo_evento_id")
    private TipoEventoEntity tipoEvento; // Noticias, Eventos, etc.

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="image_id")
    private ImageEntity image;

    private LocalDateTime fechaHora;

    @Column(nullable = false)
    private LocalDateTime createdAt; // Usamos LocalDateTime para manejar la fecha/hora de creación

    public Post(Long id, String title, String body, TipoEventoEntity section, ImageEntity image,LocalDateTime fechaHora, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.tipoEvento = section;
        this.image = image;
        this.fechaHora = fechaHora;
        this.createdAt = createdAt;
    }

    public Post(ImageEntity image, TipoEventoEntity section, String body, String title,LocalDateTime fechaHora) {
        this.image = image;
        this.tipoEvento = section;
        this.body = body;
        this.title = title;
        this.createdAt = LocalDateTime.now();
        this.fechaHora = fechaHora;
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

    @Transient
    public String getImageUrl() {
        return image != null ? image.getUrl() : null;
    }

    public ImageEntity getImage() {
        return image;
    }

    public void setImage(ImageEntity image) {
        this.image = image;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    // Constructor vacío
    public Post() {
        this.createdAt = LocalDateTime.now(); // Inicializar la fecha al crear
    }

    // Constructor con campos (opcional)

    // Getters y Setters para todos los campos...
    // (Debes generarlos con tu IDE, p. ej., Alt+Insert en IntelliJ)
}