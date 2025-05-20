package br.com.itau.auto.controller;

import br.com.itau.auto.controller.dto.AutomovelRequestDTO;
import br.com.itau.auto.controller.dto.AutomovelResponseDTO;
import br.com.itau.auto.domain.entity.Automovel;
import br.com.itau.auto.repository.AutomovelRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/automoveis")
public class AutomovelController {

    @Autowired
    private AutomovelRepository automovelRepository;

    @PostMapping
    public ResponseEntity<AutomovelResponseDTO> salvar(@Valid @RequestBody AutomovelRequestDTO automovelRequestDTO) {
        var automovel = automovelRequestDTO.toAutomovel();
        var automovelSaved =  this.automovelRepository.save(automovel);
        var AutomovelResponseDTO = automovelSaved.toDTO();

        return ResponseEntity.status(HttpStatus.CREATED).body(AutomovelResponseDTO);
    }

    @GetMapping
    public List<AutomovelResponseDTO> buscaTodosAutomoveis() {
        return this.automovelRepository.findAll()
                .stream()
                .map(AutomovelResponseDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public AutomovelResponseDTO buscaAutomovelPorId(@PathVariable Long id) {
        var optional = this.automovelRepository.findById(id);

        if(optional.isEmpty())
            throw new RuntimeException("Id não existe");

        return new AutomovelResponseDTO(optional.get());
    }




}
