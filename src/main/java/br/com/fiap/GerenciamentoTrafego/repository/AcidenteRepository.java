package br.com.fiap.GerenciamentoTrafego.repository;

import br.com.fiap.GerenciamentoTrafego.model.Acidente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Optional;

public interface AcidenteRepository  extends JpaRepository<Acidente, Long> {
    @Query("SELECT a FROM Acidente a WHERE a.dia = :dia")
    Optional<Acidente> buscarAcidentePorData(@Param("dia") LocalDate dia);
}
