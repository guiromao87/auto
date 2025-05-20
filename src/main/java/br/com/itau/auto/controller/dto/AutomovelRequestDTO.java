package br.com.itau.auto.controller.dto;

import br.com.itau.auto.domain.entity.Automovel;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record AutomovelRequestDTO(
        @NotBlank
        String marca,
        @NotBlank
        String modelo,
        @NotNull @Min(value = 0)
        BigDecimal valor
) {

    public Automovel toAutomovel() {
        return new Automovel(marca, modelo, valor);
    }
}
