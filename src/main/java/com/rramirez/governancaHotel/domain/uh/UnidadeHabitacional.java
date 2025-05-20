package com.rramirez.governancaHotel.domain.uh;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "uh")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UnidadeHabitacional {
    @Id
    @GeneratedValue
    private UUID id;
    private Integer numero;

    @Enumerated(EnumType.STRING)
    private TipoUh tipo;

//    @Enumerated(EnumType.STRING)
//    private SituacaoUh situacao;

    private Boolean ativo;
}
