package com.example.giaccneto.api_reservas.service;

import com.example.giaccneto.api_reservas.dtos.ReservaRequest;
import com.example.giaccneto.api_reservas.dtos.ReservaResponse;
import com.example.giaccneto.api_reservas.entities.ReservaDaQuadra;
import com.example.giaccneto.api_reservas.repository.ReservaRepository;
import lombok.*;
import org.springframework.stereotype.Service;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;

    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }


    public ReservaResponse reservar(ReservaRequest request) {
        ReservaDaQuadra entity = request.toEntity();
        ReservaDaQuadra entidadeSalva = reservaRepository.save(entity);
        return ReservaResponse.fromEntity(entidadeSalva);

    }
    public ReservaResponse buscarReservaPorId(Long id) {
        ReservaDaQuadra entity = reservaRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Reserva não encontrada! " + id));
        return ReservaResponse.fromEntity(entity);
    }


}
