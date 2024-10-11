package br.com.fiap.GerenciamentoTrafego.dto;

import br.com.fiap.GerenciamentoTrafego.model.Usuario;

public record UsuarioExibicaoDTO(
        Long usuarioId,
        String nome,
        String email) {

    public UsuarioExibicaoDTO(Usuario usuario) {
        this(
            usuario.getUsuarioId(),
            usuario.getNome(),
            usuario.getEmail());
    }
}
