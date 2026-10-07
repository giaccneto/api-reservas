package com.example.giaccneto.api_reservas.service;

import com.example.giaccneto.api_reservas.dtos.ReservaRequest;
import com.example.giaccneto.api_reservas.dtos.ReservaResponse;
import com.example.giaccneto.api_reservas.entities.ReservaDaQuadra;
import com.example.giaccneto.api_reservas.exceptions.DiaOuHoraIndisponivelException;
import com.example.giaccneto.api_reservas.exceptions.ReservaNaoEncontradaException;
import com.example.giaccneto.api_reservas.repository.ReservaRepository;
import lombok.*;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;

    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }


    public ReservaResponse reservar(ReservaRequest request) {

        boolean jaExiste = reservaRepository.existsByQuadraIdAndDataReservaAndHoraReserva(
                request.quadraId(),
                request.dataReserva(),
                request.horaReserva()
        );
        if (jaExiste) {
            throw new DiaOuHoraIndisponivelException("A quadra " + request.quadraId() +
                    " já está reservada neste dia e horário.");
        }

        ReservaDaQuadra entity = request.toEntity();
        ReservaDaQuadra entidadeSalva = reservaRepository.save(entity);
        return ReservaResponse.fromEntity(entidadeSalva);
    }

    public ReservaResponse buscarReservaPorId(Long id) {
        ReservaDaQuadra entity = reservaRepository.findById(id).orElseThrow(
                () -> new ReservaNaoEncontradaException("Reserva não encontrada: " + id));
        return ReservaResponse.fromEntity(entity);
    }


}
