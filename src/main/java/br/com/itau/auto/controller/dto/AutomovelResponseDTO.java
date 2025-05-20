package br.com.itau.auto.controller.dto;

import br.com.itau.auto.domain.entity.Automovel;

import java.math.BigDecimal;

public record AutomovelResponseDTO(
        Long id,
        String marca,
        String modelo
) {
    public AutomovelResponseDTO(Automovel automovel) {
        this(automovel.getId(), automovel.getMarca(), automovel.getModelo());
    }
}
