package br.com.fiap.GerenciamentoTrafego.controller;

import br.com.fiap.GerenciamentoTrafego.dto.SemaforoCadastroDTO;
import br.com.fiap.GerenciamentoTrafego.dto.SemaforoExibicaoDTO;
import br.com.fiap.GerenciamentoTrafego.model.Semaforo;
import br.com.fiap.GerenciamentoTrafego.service.SemaforoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SemaforoController {

    @Autowired
    private SemaforoService semaforoService;

    @PostMapping("/semaforos")
    @ResponseStatus(HttpStatus.CREATED)
    public SemaforoExibicaoDTO salvar(@RequestBody SemaforoCadastroDTO semaforo){
        return semaforoService.salvar(semaforo);
    }

    @GetMapping("/semaforos")
    @ResponseStatus(HttpStatus.OK)
    public List<SemaforoExibicaoDTO> litarTodos(){
        return semaforoService.exibirTodos() ;
    }

    @GetMapping("/semaforos/{semaforoId}")
    public ResponseEntity<SemaforoExibicaoDTO> buscarPorId(@PathVariable Long semaforoId){
        return ResponseEntity.ok(semaforoService.buscarPorId(semaforoId));
    }

    @DeleteMapping("/semaforos/{semaforoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long semaforoId){
        semaforoService.excluir(semaforoId);
    }

    @PutMapping("/semaforos")
    @ResponseStatus(HttpStatus.OK)
    public Semaforo atualizar(@RequestBody Semaforo semaforo){
        return semaforoService.atualizar(semaforo);
    }

    @GetMapping("/semaforos/local/{lugar}")
    @ResponseStatus(HttpStatus.OK)
    public SemaforoExibicaoDTO buscarPorLocal(@PathVariable String lugar){
        return semaforoService.buscarPorLocal(lugar);
    }
}
