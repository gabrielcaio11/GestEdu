package br.com.gabrielcaio.gestedu.controllers.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DataBaseException extends RuntimeException {
    public DataBaseException(String message) {
        super(message);
    }
}
