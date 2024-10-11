package br.com.fiap.GerenciamentoTrafego.controller;

import br.com.fiap.GerenciamentoTrafego.dto.UsuarioCadastroDTO;
import br.com.fiap.GerenciamentoTrafego.dto.UsuarioExibicaoDTO;
import br.com.fiap.GerenciamentoTrafego.model.Usuario;
import br.com.fiap.GerenciamentoTrafego.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/usuarios")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioExibicaoDTO salvar(@RequestBody @Valid UsuarioCadastroDTO usuario){
        return usuarioService.salvarUsuario(usuario);
    }

    @GetMapping("/usuarios")
    @ResponseStatus(HttpStatus.OK)
    public List<UsuarioExibicaoDTO> litarTodos(){
        return usuarioService.listarTodos();
    }

    @GetMapping("/usuarios/{usuarioId}")
    public ResponseEntity<UsuarioExibicaoDTO> buscarPorId(@PathVariable Long usuarioId){
        return ResponseEntity.ok(usuarioService.buscarPorId(usuarioId));
    }

    @DeleteMapping("/usuarios/{usuarioId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long usuarioId){
        usuarioService.excluir(usuarioId);
    }

    @PutMapping("/usuarios")
    @ResponseStatus(HttpStatus.OK)
    public Usuario atualizar(@RequestBody Usuario usuario){
        return usuarioService.atualizar(usuario);
    }

    @GetMapping("/usuarios/email/{email}")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioExibicaoDTO buscarPorEmail(@PathVariable String email){
        return usuarioService.buscarPorEmail(email);
    }
}
