package br.com.fiap.GerenciamentoTrafego.service;

import br.com.fiap.GerenciamentoTrafego.dto.UsuarioCadastroDTO;
import br.com.fiap.GerenciamentoTrafego.dto.UsuarioExibicaoDTO;
import br.com.fiap.GerenciamentoTrafego.exception.UsuarioNaoEncontradoException;
import br.com.fiap.GerenciamentoTrafego.model.Usuario;
import br.com.fiap.GerenciamentoTrafego.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioExibicaoDTO salvarUsuario(UsuarioCadastroDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioDTO, usuario);
        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        return new UsuarioExibicaoDTO(usuarioSalvo);
    }

    public UsuarioExibicaoDTO buscarPorId(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if(usuario.isPresent()) {
            return new UsuarioExibicaoDTO(usuario.get());
        }
        else{
            throw new UsuarioNaoEncontradoException("Usuario não encontrado");
        }
    }

    public List<UsuarioExibicaoDTO> listarTodos(){
        return usuarioRepository.findAll()
                .stream()
                .map(UsuarioExibicaoDTO::new)
                .toList();
    }

    public void excluir(Long id) {
        if(usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
        }
        else {
            throw new UsuarioNaoEncontradoException("Usuario não encontrado");
        }

    }

    public Usuario atualizar(Usuario usuario){
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(usuario.getUsuarioId());
        if(usuarioOptional.isPresent()) {
            return usuarioRepository.save(usuario);
        }
        else{
            throw new UsuarioNaoEncontradoException("Usuario não encontrado");
        }
    }

    public UsuarioExibicaoDTO buscarPorEmail(String email){
        Optional<Usuario> usuarioOptional = usuarioRepository.buscarPorEmail(email);
        if (usuarioOptional.isPresent()){
            return new UsuarioExibicaoDTO(usuarioOptional.get());
        } else {
            throw new UsuarioNaoEncontradoException("Usuario não encontrado");
        }
    }


}
