package com.muniz.socialbooks.handler;

import com.muniz.socialbooks.domain.DetalhesErro;
import com.muniz.socialbooks.services.exceptions.AutorExistenteException;
import com.muniz.socialbooks.services.exceptions.AutorNaoEncontradoException;
import com.muniz.socialbooks.services.exceptions.LivroNaoEcontradoException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(LivroNaoEcontradoException.class)
    public ResponseEntity<DetalhesErro> handleLivroNaoEncontradoException(LivroNaoEcontradoException e,
                                                                          HttpServletRequest request) {
        DetalhesErro erro = new DetalhesErro();
        erro.setStatus(404l);
        erro.setTitulo("O livro não pode ser encontrado");
        erro.setMensagemDesenvolvedor("http://erros.socialbooks.com/404");
        erro.setTimestamp(System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(AutorExistenteException.class)
    public ResponseEntity<DetalhesErro> handleAutorExistenteException(AutorExistenteException e,
                                                                      HttpServletRequest request) {
        DetalhesErro erro = new DetalhesErro();
        erro.setStatus(409l);
        erro.setTitulo("Autor já existente");
        erro.setMensagemDesenvolvedor("http://erros.socialbooks.com/409");
        erro.setTimestamp(System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
    }

    @ExceptionHandler(AutorNaoEncontradoException.class)
    public ResponseEntity<DetalhesErro> handleAutorExistenteException(AutorNaoEncontradoException e,
                                                                      HttpServletRequest request) {
        DetalhesErro erro = new DetalhesErro();
        erro.setStatus(404l);
        erro.setTitulo("Autor não encontrado");
        erro.setMensagemDesenvolvedor("http://erros.socialbooks.com/409");
        erro.setTimestamp(System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<DetalhesErro> handleDataIntegrityViolationException(DataIntegrityViolationException e,
                                                                              HttpServletRequest request) {
        DetalhesErro erro = new DetalhesErro();
        erro.setStatus(400l);
        erro.setTitulo("Requisição Invalida");
        erro.setMensagemDesenvolvedor("http://erros.socialbooks.com/400");
        erro.setTimestamp(System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }

}
