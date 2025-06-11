package br.com.gabrielcaio.gestedu.controllers.error;

public class DataBaseException extends RuntimeException {
    public DataBaseException(String message) {
        super(message);
    }
}
