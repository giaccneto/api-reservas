package com.example.giaccneto.api_reservas.dtos;

import com.example.giaccneto.api_reservas.entities.ReservaDaQuadra;

import java.time.LocalDate;
import java.time.LocalTime;

public record ReservaResponse(
        Long idReserva,
        Long quadraId,
        LocalDate dataReserva,
        LocalTime horaReserva
) {
    public static ReservaResponse fromEntity(ReservaDaQuadra entity) {
        return new ReservaResponse(
                entity.getIdReserva(),
                entity.getQuadraId(),
                entity.getDataReserva(),
                entity.getHoraReserva()
        );
    }
}
