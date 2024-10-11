package br.com.fiap.GerenciamentoTrafego.service;

import br.com.fiap.GerenciamentoTrafego.dto.SemaforoCadastroDTO;
import br.com.fiap.GerenciamentoTrafego.dto.SemaforoExibicaoDTO;
import br.com.fiap.GerenciamentoTrafego.exception.SemaforoNaoEncontradoException;
import br.com.fiap.GerenciamentoTrafego.model.Semaforo;
import br.com.fiap.GerenciamentoTrafego.repository.SemaforoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SemaforoService {

    @Autowired
    private SemaforoRepository semaforoRepository;

    public SemaforoExibicaoDTO salvar(SemaforoCadastroDTO semaforoDTO){
        Semaforo semaforo = new Semaforo();
        BeanUtils.copyProperties(semaforoDTO, semaforo);
        Semaforo semaforoSalvo = semaforoRepository.save(semaforo);
        return new SemaforoExibicaoDTO(semaforoSalvo);
    }

    public SemaforoExibicaoDTO buscarPorId(Long id){
        Optional<Semaforo> semaforo = semaforoRepository.findById(id);
        if(semaforo.isPresent()){
            return new SemaforoExibicaoDTO(semaforo.get());
        }
        else{
            throw new SemaforoNaoEncontradoException("Semaforo não encontraado");
        }
    }

    public List<SemaforoExibicaoDTO> exibirTodos(){
        return semaforoRepository.findAll().
                stream().
                map(SemaforoExibicaoDTO::new).
                toList();
    }

    public void excluir(Long id){
        if(semaforoRepository.existsById(id)){
            semaforoRepository.deleteById(id);
        }
        else{
            throw new SemaforoNaoEncontradoException("Semaforo não encontraado");
        }
    }

    public Semaforo atualizar(Semaforo semaforo){
        Optional<Semaforo> semaforoOptional = semaforoRepository.findById(semaforo.getSemaforoId());
        if(semaforoOptional.isPresent()){
            return semaforoRepository.save(semaforo);
        }
        else{
            throw new SemaforoNaoEncontradoException("Semaforo não encontraado");
        }
    }

    public SemaforoExibicaoDTO buscarPorLocal(String lugar){
        Optional<Semaforo> semaforoOptional = semaforoRepository.buscarPorLocal(lugar);
        if(semaforoOptional.isPresent()){
            return new SemaforoExibicaoDTO(semaforoOptional.get());
        }
        else{
            throw new SemaforoNaoEncontradoException("Semaforo não encontraado");
        }
    }

}
