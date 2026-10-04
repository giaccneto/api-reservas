package com.example.giaccneto.api_reservas.dtos;

import com.example.giaccneto.api_reservas.entities.ReservaDaQuadra;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

public record ReservaRequest(
        @NotNull
        Long quadraId,
        @NotNull
        @FutureOrPresent
        LocalDate dataReserva,
        @NotNull
        LocalTime horaReserva
) {
        public ReservaDaQuadra toEntity(){
                ReservaDaQuadra reserva = new ReservaDaQuadra();
                reserva.setQuadraId(this.quadraId);
                reserva.setDataReserva(this.dataReserva);
                reserva.setHoraReserva(this.horaReserva);
                return reserva;
        }
}
