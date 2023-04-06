package com.muniz.socialbooks.repository;

import com.muniz.socialbooks.domain.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
}
