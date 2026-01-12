package com.kauacosta.cadastro_bebidas.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BebidaResponseDTO {

    private Long id;
    private String nomeBebida;
    private Double precoBebida;
    private String descricaoBebida;
    private Long quantidadeBebida;
}
