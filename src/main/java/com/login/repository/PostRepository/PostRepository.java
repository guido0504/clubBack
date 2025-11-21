package com.login.repository.PostRepository;

import com.login.entity.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    // Spring Data JPA ya proporciona findById, findAll, save, deleteById.
    // No necesitas agregar métodos si solo usas el CRUD básico.
}