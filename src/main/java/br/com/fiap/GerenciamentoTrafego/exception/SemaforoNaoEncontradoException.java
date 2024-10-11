package br.com.fiap.GerenciamentoTrafego.exception;

public class SemaforoNaoEncontradoException extends RuntimeException {
    public SemaforoNaoEncontradoException(String message) {
        super(message);
    }
}
