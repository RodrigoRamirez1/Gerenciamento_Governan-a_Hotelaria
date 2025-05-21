package com.rramirez.governancaHotel.repositories;

import com.rramirez.governancaHotel.domain.limpeza.SituacaoLimpeza;
import com.rramirez.governancaHotel.domain.uh.TipoUh;
import com.rramirez.governancaHotel.domain.uh.UnidadeHabitacional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UnidadeHabitacionalRepository extends JpaRepository<UnidadeHabitacional, UUID> {

    List<UnidadeHabitacional> findByTipo(TipoUh tipo);
}
