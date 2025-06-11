package br.com.gabrielcaio.gestedu.controllers.error;

public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
}

