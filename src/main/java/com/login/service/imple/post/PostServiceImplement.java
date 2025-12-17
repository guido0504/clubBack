package com.login.service.imple.post;

import com.login.dto.ResponseDefaultDto;
import com.login.dto.post.PostRequestDto;
import com.login.dto.post.PostResponseDto;
import com.login.entity.image.ImageEntity;
import com.login.entity.post.Post;
import com.login.entity.tipoEvento.TipoEventoEntity;
import com.login.repository.ImageRepository.ImageRepository;
import com.login.repository.PostRepository.PostRepository;
import com.login.repository.tipoEventoRepository.TipoEventoRepository;
import com.login.service.PostService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImplement implements PostService {

    private final PostRepository postRepository;
    // Nota: Necesitarás un Mapper para convertir Entity <-> DTO (p. ej., MapStruct o manual)

    private final TipoEventoRepository tipoEventoRepository;
    private final ImageRepository imageRepository;

    public PostServiceImplement(PostRepository postRepository, TipoEventoRepository tipoEventoRepository,ImageRepository imageRepository) {
        this.postRepository = postRepository;
        this.tipoEventoRepository = tipoEventoRepository;
        this.imageRepository = imageRepository;
    }

    // --- Métodos de CRUD (Lógica de Negocio) ---

    @Override
    @Transactional(readOnly = true)

    public ResponseDefaultDto findAll() {
        // En este punto, convertirías las Entidades (Post) a DTOs (PostResponseDto)
        List<PostResponseDto> postResponse = this.postRepository.findAll().stream()
                .map(this::convertToDto) // Usarías tu método de conversión
                .collect(Collectors.toList());
        return new ResponseDefaultDto(200,"Existoso",postResponse,"Listado completo");
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseDefaultDto findById(Long id) {
        // Manejo de excepción si no se encuentra
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post no encontrado con ID: " + id));
        return new ResponseDefaultDto(200,"Exitoso",convertToDto(post),"Valor retornado");
    }

    @Override
    @Transactional
    public ResponseDefaultDto create(PostRequestDto postDto){
        try {
            Post post = convertToEntity(postDto);
            Post savedPost = postRepository.save(post);
            return new ResponseDefaultDto(200,"Existoso",convertToDto(savedPost),"Se guardo exitosamente");
        } catch(Exception e){
            return new ResponseDefaultDto(500,"Error","","Error general: " + e);
        }
    }

    @Override
    public ResponseDefaultDto update(Long id, PostRequestDto postDto) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post no encontrado con ID: " + id));

        if(post != null) {
            post = convertToEntity(postDto);
            post.setId(id);
            postRepository.save(post);
        }else {
            throw new RuntimeException("No existe el post");
        }

        return new ResponseDefaultDto(200,"Exitoso",post,"Se actualizo correctamente");
    }

    @Override
    public ResponseDefaultDto delete(Long id) {
        postRepository.deleteById(id);
        return new ResponseDefaultDto(200,"Exitoso",null,"Dato eliminado exitosamente");
    }

    // --- Métodos de Conversión (Debes implementarlos) ---
    private Post convertToEntity( PostRequestDto dto ) {
        Post post = new Post();
        post.setTitle(dto.title());
        post.setBody(dto.body());
        post.setFechaHora(dto.fechaHora().toLocalDateTime());
        post.setCreatedAt(LocalDateTime.now());

        // Tipo de evento (obligatorio)
        TipoEventoEntity tipo = tipoEventoRepository.findById(dto.tipoEvento())
                .orElseThrow(() ->
                        new RuntimeException("Tipo de evento no encontrado: " + dto.tipoEvento())
                );
        post.setTipoEvento(tipo);

        // Imagen (opcional)
        if (dto.image() != null) {  // o dto.imageId()
            ImageEntity image = new ImageEntity(imageRepository.findById(dto.image()).get());
            post.setImage(image);
        }

        return post;
    }

    private PostResponseDto convertToDto(Post entity) {
        return new PostResponseDto(entity.getId(),entity.getTitle(),entity.getBody(),entity.getTipoEvento(), entity.getFechaHora(),
                entity.getImageUrl(),entity.getImage().getId(),entity.getCreatedAt()); // Implementar la lógica real
    }
}