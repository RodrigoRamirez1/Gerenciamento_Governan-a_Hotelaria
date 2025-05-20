package com.rramirez.governancaHotel.repositories;

import com.rramirez.governancaHotel.domain.funcionario.Funcionario;
import com.rramirez.governancaHotel.domain.funcionario.TipoCargo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FuncionarioRepository extends JpaRepository<Funcionario, UUID> {

    List<Funcionario> findByCargo(TipoCargo cargo);
}
