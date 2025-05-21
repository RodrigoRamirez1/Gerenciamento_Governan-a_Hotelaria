package com.rramirez.governancaHotel.repositories;

import com.rramirez.governancaHotel.domain.limpeza.Limpeza;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

public interface LimpezaRepository extends JpaRepository<Limpeza, UUID> {

    List<Limpeza> findAllByDataBetween(Timestamp inicio, Timestamp fim);
}
