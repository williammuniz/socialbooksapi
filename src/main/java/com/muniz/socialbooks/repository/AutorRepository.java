package com.muniz.socialbooks.repository;

import com.muniz.socialbooks.domain.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
