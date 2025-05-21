package com.rramirez.governancaHotel.domain.limpeza;

import com.rramirez.governancaHotel.domain.funcionario.Funcionario;
import com.rramirez.governancaHotel.domain.uh.UnidadeHabitacional;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "limpeza")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Limpeza {
    @Id
    @GeneratedValue
    private UUID id;
    private Timestamp data;

    @Enumerated(EnumType.STRING)
    private SituacaoLimpeza situacao;

    @Enumerated(EnumType.STRING)
    private TipoLimpeza tipo;

    @ManyToOne
    @JoinColumn(name = "uh_id")
    private UnidadeHabitacional uh;
    @ManyToOne
    @JoinColumn(name = "camareira_id")
    private Funcionario camareira;
}
