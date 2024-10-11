package br.com.fiap.GerenciamentoTrafego.dto;

import br.com.fiap.GerenciamentoTrafego.model.Semaforo;

public record SemaforoExibicaoDTO(Long semaforoId,
                                  String estado,
                                  int duracao,
                                  String lugar,
                                  boolean funcionando) {

    public SemaforoExibicaoDTO(Semaforo semaforo){
        this(
                semaforo.getSemaforoId(),
                semaforo.getEstado(),
                semaforo.getDuracao(),
                semaforo.getLugar(),
                semaforo.isFuncionando());
    }
}
