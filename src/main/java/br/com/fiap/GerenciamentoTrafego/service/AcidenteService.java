package br.com.fiap.GerenciamentoTrafego.service;


import br.com.fiap.GerenciamentoTrafego.dto.AcidenteCadastroDTO;
import br.com.fiap.GerenciamentoTrafego.dto.AcidenteExibicaoDTO;
import br.com.fiap.GerenciamentoTrafego.exception.AcidenteNaoEncontradoException;
import br.com.fiap.GerenciamentoTrafego.model.Acidente;
import br.com.fiap.GerenciamentoTrafego.repository.AcidenteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AcidenteService {
    @Autowired
    private AcidenteRepository acidenteRepository;

    public AcidenteExibicaoDTO salvar(AcidenteCadastroDTO acidenteDTO){
        Acidente acidente = new Acidente();
        BeanUtils.copyProperties(acidenteDTO, acidente);
        Acidente acidenteSalvo = acidenteRepository.save(acidente);
        return new AcidenteExibicaoDTO(acidenteSalvo);
    }

    public AcidenteExibicaoDTO buscarPorId(Long id){
        Optional<Acidente> acidente = acidenteRepository.findById(id);
        if(acidente.isPresent()){
            return new AcidenteExibicaoDTO(acidente.get());
        }
        else{
            throw new AcidenteNaoEncontradoException("Acidente não encontrado");
        }
    }

    public List<AcidenteExibicaoDTO> exibirTodos(){
        return acidenteRepository.findAll().
                stream().
                map(AcidenteExibicaoDTO::new).
                toList();
    }

    public void excluir(Long id){
        if(acidenteRepository.existsById(id)){
            acidenteRepository.deleteById(id);
        }
        else{
            throw new AcidenteNaoEncontradoException("Acidente não encontrado");
        }
    }

    public Acidente atualizar(Acidente acidente){
        Optional<Acidente> acidenteOptional = acidenteRepository.findById(acidente.getAcidenteId());
        if(acidenteOptional.isPresent()){
            return acidenteRepository.save(acidente);
        }
        else{
            throw new AcidenteNaoEncontradoException("Acidente não encontrado");
        }
    }

    public AcidenteExibicaoDTO buscarAcidentePorData(LocalDate data){
        Optional<Acidente> acidenteOptional = acidenteRepository.buscarAcidentePorData(data);
        if(acidenteOptional.isPresent()){
            return new AcidenteExibicaoDTO(acidenteOptional.get());
        }
        else{
            throw new AcidenteNaoEncontradoException("Acidente não encontrado");
        }
    }
}
