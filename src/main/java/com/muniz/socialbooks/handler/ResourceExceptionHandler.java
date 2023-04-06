package com.muniz.socialbooks.handler;

import com.muniz.socialbooks.domain.DetalhesErro;
import com.muniz.socialbooks.services.exceptions.LivroNaoEcontradoException;
import jakarta.servlet.http.HttpServletRequest;
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

}
