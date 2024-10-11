package br.com.fiap.GerenciamentoTrafego.dto;

import java.time.LocalDate;

public record AcidenteCadastroDTO(Long acidenteId,
                                  String descricao,
                                  String severidade,
                                  LocalDate dia,
                                  String lugar) {
}
