package br.com.fiap.GerenciamentoTrafego.repository;

import br.com.fiap.GerenciamentoTrafego.model.Semaforo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface SemaforoRepository extends JpaRepository<Semaforo, Long> {
    @Query("SELECT u FROM Semaforo u WHERE u.lugar = :lugar")
    Optional<Semaforo> buscarPorLocal(@Param("lugar") String lugar);
}
