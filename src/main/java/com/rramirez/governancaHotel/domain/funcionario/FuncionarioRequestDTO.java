package com.rramirez.governancaHotel.domain.funcionario;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public record FuncionarioRequestDTO(
        String nome,
        Integer idade,
        Long cpf,

        TipoCargo cargo,
        Long telefone
) {
}
