package br.com.gabrielcaio.gestedu.controllers;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello-world")
public class HelloWorldController {

    @GetMapping
    @Operation(summary = "Buscar mensagem", description = "Retorna uma mensagem Hello, World!.")
    public ResponseEntity<String> listarInstrutores() {
        return ResponseEntity.status(HttpStatus.OK).body("Hello, World!");
    }
}
