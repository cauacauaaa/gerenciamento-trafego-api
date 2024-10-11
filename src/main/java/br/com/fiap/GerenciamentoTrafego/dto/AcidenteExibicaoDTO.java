package br.com.fiap.GerenciamentoTrafego.dto;

import br.com.fiap.GerenciamentoTrafego.model.Acidente;

import java.time.LocalDate;

public record AcidenteExibicaoDTO(Long acidenteId,
                                  String descricao,
                                  String severidade,
                                  LocalDate dia,
                                  String lugar) {

    public AcidenteExibicaoDTO(Acidente acidente) {
        this(
                acidente.getAcidenteId(),
                acidente.getDescricao(),
                acidente.getSeveridade(),
                acidente.getDia(),
                acidente.getLugar()
        );
    }
}
