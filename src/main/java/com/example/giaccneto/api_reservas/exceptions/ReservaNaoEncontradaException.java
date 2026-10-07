package com.example.giaccneto.api_reservas.exceptions;

import org.springframework.http.HttpStatus;

public class ReservaNaoEncontradaException extends RuntimeException {


    public ReservaNaoEncontradaException(String message) {
        super(message);
    }
}
