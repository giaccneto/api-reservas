package com.example.giaccneto.api_reservas.exceptions;

import org.springframework.http.HttpStatus;

public class DiaOuHoraIndisponivelException extends RuntimeException {

    public DiaOuHoraIndisponivelException(String message){
        super(message);
    }
}
