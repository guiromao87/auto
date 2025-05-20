package br.com.itau.auto.domain.entity;

import br.com.itau.auto.controller.dto.AutomovelResponseDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "automoveis")
@Data
@NoArgsConstructor
public class Automovel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String modelo;
    private BigDecimal valor;
    private LocalDateTime dataDeCadastro = LocalDateTime.now();

    public Automovel(String marca, String modelo, BigDecimal valor) {
        this.marca = marca;
        this.modelo = modelo;
        this.valor = valor;
    }

    public AutomovelResponseDTO toDTO() {
        return new AutomovelResponseDTO(this.id, this.marca, this.modelo);
    }
}
