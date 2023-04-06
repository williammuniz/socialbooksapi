package com.muniz.socialbooks.services;

import com.muniz.socialbooks.domain.Comentario;
import com.muniz.socialbooks.domain.Livro;
import com.muniz.socialbooks.repository.ComentarioRepository;
import com.muniz.socialbooks.repository.LivroRepository;
import com.muniz.socialbooks.services.exceptions.LivroNaoEcontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private ComentarioRepository comentarioRepository;


    public List<Livro> findAll() {
        return livroRepository.findAll();
    }

    public Optional<Livro> findById(Long id) {
        Optional<Livro> livro = livroRepository.findById(id);
        if (livro.isPresent()) {
            return livro;
        }
        throw new LivroNaoEcontradoException("O livro não pode ser encontrado.");
    }

    public Livro salvar(Livro livro) {
        livro.setId(null);
        return livroRepository.save(livro);
    }

    public void delete(Long id) {
        try {
            livroRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new LivroNaoEcontradoException("O livro não pode ser encontrado.");
        }
    }

    public void atualizar(Livro livro) {
        verificarExistencia(livro);
        livroRepository.save(livro);
    }

    private void verificarExistencia(Livro livro) {
        findById(livro.getId());
    }

    public Comentario salvarComentario(Long idLivro, Comentario comentario) {
        Optional<Livro> livro = findById(idLivro);
        comentario.setLivro(livro.get());
        comentario.setData(new Date());
        return comentarioRepository.save(comentario);
    }

    public List<Comentario> listarComentarios(Long idLivro) {
        Optional<Livro> livro = findById(idLivro);
        return livro.get().getComentarios();
    }
}
