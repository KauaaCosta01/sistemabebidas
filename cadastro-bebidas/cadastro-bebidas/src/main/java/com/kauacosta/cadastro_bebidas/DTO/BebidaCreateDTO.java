package com.kauacosta.cadastro_bebidas.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BebidaCreateDTO {

    @NotBlank
    private String nomeBebida;

    @NotNull
    @Positive
    private Double precoBebida;

    @NotBlank
    private String descricaoBebida;

    @NotNull
    @Positive
    private Long quantidadeBebida;


}
