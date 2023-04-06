package com.muniz.socialbooks.services;

import com.muniz.socialbooks.domain.Autor;
import com.muniz.socialbooks.repository.AutorRepository;
import com.muniz.socialbooks.services.exceptions.AutorExistenteException;
import com.muniz.socialbooks.services.exceptions.AutorNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public List<Autor> findAll() {
        return autorRepository.findAll();
    }

    public Autor salvar(Autor autor) {
        if (autor.getId() != null) {
            Optional<Autor> a = autorRepository.findById(autor.getId());
            if (a.isPresent()) {
                throw new AutorExistenteException("Autor já existe.");
            }
        }
        return autorRepository.save(autor);
    }

    public Autor findById(Long id) {
        Optional<Autor> autor = autorRepository.findById(id);
        if (autor.isPresent()) {
            return autor.get();
        }
        throw new AutorNaoEncontradoException("Autor não encontrado.");
    }
}
