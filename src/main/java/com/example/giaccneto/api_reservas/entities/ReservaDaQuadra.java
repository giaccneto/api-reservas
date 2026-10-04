package com.example.giaccneto.api_reservas.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservaDaQuadra {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "id_reserva")
    private Long idReserva;
    @Column(name = "quadra_id")
    private Long quadraId;
    @Column(name = "data_reserva", nullable = false)
    private LocalDate dataReserva;
    @Column(name = "hora_reserva", nullable = false)
    private LocalTime horaReserva;
}
