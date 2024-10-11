package br.com.fiap.GerenciamentoTrafego.dto;

public record SemaforoCadastroDTO(Long semaforoId,
                                  String estado,
                                  int duracao,
                                  String lugar,
                                  boolean funcionando) {
}
