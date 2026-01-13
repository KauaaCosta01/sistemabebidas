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

    @NotBlank(message = "O nome da bebida é obrigatório")
    private String nomeBebida;

    @NotNull(message = "O preço da bebida é obrigatório")
    @Positive(message = "O valor deve ser maior que zero")
    private Double precoBebida;

    @NotBlank(message = "A descrição da bebida é obrigatória")
    private String descricaoBebida;

    @NotNull(message = "A quantidade da bebida é obrigatória")
    @Positive(message = "A quantidade deve ser maior que zero")
    private Long quantidadeBebida;


}
