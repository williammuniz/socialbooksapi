package com.muniz.socialbooks.services.exceptions;

public class LivroNaoEcontradoException extends RuntimeException {

    public LivroNaoEcontradoException(String mensagem) {
        super(mensagem);
    }

    public LivroNaoEcontradoException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
    

}
