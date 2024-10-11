package br.com.fiap.GerenciamentoTrafego.service;


import br.com.fiap.GerenciamentoTrafego.dto.FluxoCadastroDTO;
import br.com.fiap.GerenciamentoTrafego.dto.FluxoExibicaoDTO;
import br.com.fiap.GerenciamentoTrafego.exception.FluxoNaoEncontradoException;
import br.com.fiap.GerenciamentoTrafego.exception.UsuarioNaoEncontradoException;
import br.com.fiap.GerenciamentoTrafego.model.Fluxo;
import br.com.fiap.GerenciamentoTrafego.repository.FluxoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FluxoService {

    @Autowired
    private FluxoRepository fluxoRepository;

    public FluxoExibicaoDTO salvar(FluxoCadastroDTO fluxoDTO){
        Fluxo fluxo = new Fluxo();
        BeanUtils.copyProperties(fluxoDTO, fluxo);
        Fluxo fluxoSalvo = fluxoRepository.save(fluxo);
        return new FluxoExibicaoDTO(fluxoSalvo);
    }

    public FluxoExibicaoDTO buscarPorId(Long id){
        Optional<Fluxo> fluxo = fluxoRepository.findById(id);
        if(fluxo.isPresent()){
            return new FluxoExibicaoDTO(fluxo.get());
        }
        else{
            throw new FluxoNaoEncontradoException("Fluxo não encontrado.");
        }
    }

    public List<FluxoExibicaoDTO> exibirTodos(){
        return fluxoRepository.findAll().
                stream().
                map(FluxoExibicaoDTO::new).
                toList();
    }

    public void excluir(Long id){
        if(fluxoRepository.existsById(id)){
            fluxoRepository.deleteById(id);
        }
        else{
            throw new FluxoNaoEncontradoException("Fluxo não encontrado");
        }
    }

    public Fluxo atualizar(Fluxo fluxo){
        Optional<Fluxo> fluxoOptional = fluxoRepository.findById(fluxo.getFluxoId());
        if(fluxoOptional.isPresent()){
            return fluxoRepository.save(fluxo);
        }
        else{
            throw new FluxoNaoEncontradoException("Fluxo não encontrado");
        }
    }
}
