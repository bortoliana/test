package demo.service;

import demo.dto.PessoaDTO;
import demo.entities.PessoaEntity;
import demo.mapper.PessoaMapper;
import demo.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public PessoaDTO salvar(PessoaDTO pessoaDTO){
        PessoaEntity pessoaEntity = PessoaMapper.mapTo(pessoaDTO);
        pessoaRepository.save(pessoaEntity);
        return pessoaDTO;
    }

    public PessoaDTO findByCpf(String cpf) {
        return pessoaRepository.findById(cpf)
                .map(PessoaMapper::mapTo)
                .orElse(null);
    }

    public List<PessoaDTO> findAll() {
        return pessoaRepository.findAll()
                .stream()
                .map(PessoaMapper::mapTo)
                .toList();

    }

}


