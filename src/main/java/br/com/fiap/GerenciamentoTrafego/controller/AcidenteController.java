package br.com.fiap.GerenciamentoTrafego.controller;


import br.com.fiap.GerenciamentoTrafego.dto.AcidenteCadastroDTO;
import br.com.fiap.GerenciamentoTrafego.dto.AcidenteExibicaoDTO;
import br.com.fiap.GerenciamentoTrafego.model.Acidente;
import br.com.fiap.GerenciamentoTrafego.service.AcidenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AcidenteController {

    @Autowired
    private AcidenteService acidenteService;

    @PostMapping("/acidentes")
    @ResponseStatus(HttpStatus.CREATED)
    public AcidenteExibicaoDTO salvar(@RequestBody AcidenteCadastroDTO acidente){
        return acidenteService.salvar(acidente);
    }

    @GetMapping("/acidentes")
    @ResponseStatus(HttpStatus.OK)
    public List<AcidenteExibicaoDTO> listarTodos(){
        return acidenteService.exibirTodos() ;
    }

    @GetMapping("/acidentes/{acidenteId}")
    public ResponseEntity<AcidenteExibicaoDTO> buscarPorId(@PathVariable Long acidenteId){
        return ResponseEntity.ok(acidenteService.buscarPorId(acidenteId));
    }

    @DeleteMapping("/acidentes/{acidenteId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long acidenteId){
        acidenteService.excluir(acidenteId);
    }

    @PutMapping("/acidentes")
    @ResponseStatus(HttpStatus.OK)
    public Acidente atualizar(@RequestBody Acidente acidente){
        return acidenteService.atualizar(acidente);
    }

    @GetMapping("/semaforos/data/{dia}")
    @ResponseStatus(HttpStatus.OK)
    public AcidenteExibicaoDTO buscarPorDia(@PathVariable LocalDate dia){
        return acidenteService.buscarAcidentePorData(dia);
    }
}
