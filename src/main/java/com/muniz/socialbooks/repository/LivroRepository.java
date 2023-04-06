package com.muniz.socialbooks.repository;

import com.muniz.socialbooks.domain.Livro;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LivroRepository extends JpaRepository<Livro, Long> {

}
