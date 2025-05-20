package br.com.itau.auto.repository;

import br.com.itau.auto.domain.entity.Automovel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutomovelRepository extends JpaRepository<Automovel, Long> {
}
