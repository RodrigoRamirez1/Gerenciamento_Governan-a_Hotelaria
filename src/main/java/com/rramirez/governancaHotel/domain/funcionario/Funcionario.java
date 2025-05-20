package com.rramirez.governancaHotel.domain.funcionario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "funcionario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Funcionario {
    @Id
    @GeneratedValue
    private UUID id;
    private String nome;
    private Integer idade;
    private Long cpf;

    @Enumerated(EnumType.STRING)
    private TipoCargo cargo;
    private Long telefone;
    private Boolean ativo;
}
