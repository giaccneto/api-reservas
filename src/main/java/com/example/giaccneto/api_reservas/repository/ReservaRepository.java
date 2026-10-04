package com.example.giaccneto.api_reservas.repository;

import com.example.giaccneto.api_reservas.entities.ReservaDaQuadra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<ReservaDaQuadra, Long> {
}
