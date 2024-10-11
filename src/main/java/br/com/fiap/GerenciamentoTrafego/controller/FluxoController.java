package br.com.fiap.GerenciamentoTrafego.controller;

import br.com.fiap.GerenciamentoTrafego.dto.FluxoCadastroDTO;
import br.com.fiap.GerenciamentoTrafego.dto.FluxoExibicaoDTO;
import br.com.fiap.GerenciamentoTrafego.model.Fluxo;
import br.com.fiap.GerenciamentoTrafego.service.FluxoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
@RestController
@RequestMapping("/api")
public class FluxoController {

    @Autowired
    private FluxoService fluxoService;

    @PostMapping("/fluxos")
    @ResponseStatus(HttpStatus.CREATED)
    public FluxoExibicaoDTO salvar(@RequestBody FluxoCadastroDTO fluxo){
        return fluxoService.salvar(fluxo);
    }

    @GetMapping("/fluxos")
    @ResponseStatus(HttpStatus.OK)
    public List<FluxoExibicaoDTO> listarTodos(){
        return fluxoService.exibirTodos() ;
    }

    @GetMapping("/fluxos/{fluxoId}")
    public ResponseEntity<FluxoExibicaoDTO> buscarPorId(@PathVariable Long fluxoId){
        return ResponseEntity.ok(fluxoService.buscarPorId(fluxoId));
    }

    @DeleteMapping("/fluxos/{fluxoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long fluxoId){
        fluxoService.excluir(fluxoId);
    }

    @PutMapping("/fluxos")
    @ResponseStatus(HttpStatus.OK)
    public Fluxo atualizar(@RequestBody Fluxo fluxo){
        return fluxoService.atualizar(fluxo);
    }

}
