package com.rramirez.governancaHotel.domain.limpeza;

import java.sql.Timestamp;
import java.util.UUID;

public record LimpezaRequestDTO(
        TipoLimpeza tipo, UUID uh, UUID camareira
) {
}
