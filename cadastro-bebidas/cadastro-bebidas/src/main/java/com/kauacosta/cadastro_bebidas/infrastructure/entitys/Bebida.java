package com.kauacosta.cadastro_bebidas.infrastructure.entitys;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bebidas")

public class Bebida {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "O nome da bebida não pode estar em branco")
    @Column(name = "nome_bebida", unique = true)
    private String nomeBebida;

    @NotNull(message = "O preço da bebida não pode estar em branco")
    @Column(name = "preco_bebida")
    private Double precoBebida;

    @NotNull(message = "A descrição não pode estar vazia")
    @Column(name = "descricao_bebida")
    private String descricaoBebida;

    @NotNull(message = "A quantidade não pode estar vazia")
    @Column(name = "quantidades_bebida")
    private Long quantidadeBebida;
}
