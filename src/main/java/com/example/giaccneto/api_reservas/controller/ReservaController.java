package com.example.giaccneto.api_reservas.controller;

import com.example.giaccneto.api_reservas.dtos.ReservaRequest;
import com.example.giaccneto.api_reservas.dtos.ReservaResponse;
import com.example.giaccneto.api_reservas.service.ReservaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservas")
@RequiredArgsConstructor
public class ReservaController {

    private final ReservaService reservaService;


    @PostMapping
    public ResponseEntity<ReservaResponse> reservar(@Valid @RequestBody ReservaRequest reservaRequest) {
        ReservaResponse response = reservaService.reservar(reservaRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaResponse> buscarPorId(@PathVariable Long id) {
        ReservaResponse response = reservaService.buscarReservaPorId(id);
        return ResponseEntity.ok(response);
    }


}
