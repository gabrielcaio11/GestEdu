package br.com.gabrielcaio.gestedu.controllers.error;

public class EntityExistsException extends RuntimeException {
    public EntityExistsException(String message) {
        super(message);
    }
}
