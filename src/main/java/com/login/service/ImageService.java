package com.login.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.login.entity.image.ImageEntity;
import com.login.repository.ImageRepository.ImageRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class ImageService {

    private final Cloudinary cloudinary;
    private final ImageRepository imageRepository;

    public ImageService(Cloudinary cloudinary, ImageRepository imageRepository) {
        this.cloudinary = cloudinary;
        this.imageRepository = imageRepository;
    }

    // 📤 CARGAR imagen
    public ImageEntity uploadImage(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("El archivo está vacío");
        }

        // Opcional: podés agregar opciones como carpeta
        Map uploadResult = cloudinary.uploader().upload(
                file.getBytes(),
                ObjectUtils.asMap(
                        "folder", "mis-imagenes" // cambia el nombre de la carpeta si querés
                )
        );

        String publicId = (String) uploadResult.get("public_id");
        String url = (String) uploadResult.get("secure_url");

        ImageEntity image = new ImageEntity(publicId, url, file.getOriginalFilename());
        return imageRepository.save(image);
    }

    // 📥 OBTENER una imagen por id
    public ImageEntity getImage(Long id) {
        return imageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Imagen no encontrada con id " + id));
    }

    // 📥 LISTAR todas las imágenes
    public List<ImageEntity> getAllImages() {
        return imageRepository.findAll();
    }

    // 🗑️ BORRAR imagen
    public void deleteImage(Long id) throws IOException {
        ImageEntity image = getImage(id);

        // Primero borrar en Cloudinary
        cloudinary.uploader().destroy(
                image.getPublicId(),
                ObjectUtils.emptyMap()
        );

        // Luego borrar el registro en la base
        imageRepository.delete(image);
    }
}

