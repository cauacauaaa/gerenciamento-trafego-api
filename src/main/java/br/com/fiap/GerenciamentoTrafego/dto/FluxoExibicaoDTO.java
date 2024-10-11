package br.com.fiap.GerenciamentoTrafego.dto;

import br.com.fiap.GerenciamentoTrafego.model.Fluxo;

public record FluxoExibicaoDTO(Long fluxoId,
                               int quantidadeVeiculos,
                               double velocidadeMedia) {

    public FluxoExibicaoDTO(Fluxo fluxo){
        this(
                fluxo.getFluxoId(),
                fluxo.getQuantidadeVeiculos(),
                fluxo.getVelocidadeMedia());
    }
}
