package demo.service;

import demo.dto.EnderecoDTO;
import demo.entities.EnderecoEntity;
import demo.mapper.EnderecoMapper;
import demo.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public EnderecoDTO salvar(EnderecoDTO enderecoDTO, String cpf){
        EnderecoEntity enderecoEntity = EnderecoMapper.mapTo(enderecoDTO, cpf);
        enderecoRepository.save(enderecoEntity);
        return enderecoDTO;
    }

    public List<EnderecoDTO> findByCpf(String cpf){
        return enderecoRepository.findByCpfPessoa(cpf)
                .stream()
                .map(EnderecoMapper::mapTo)
                .toList();
    }

    public EnderecoDTO principalEndereco(String cpf, Long id){
        enderecoRepository.findByCpfPessoa(cpf)
                .stream()
                .filter(endereco -> !endereco.getId().equals(id))
                .forEach(endereco -> atualizaPrincipal(endereco, false));

        return enderecoRepository.findById(id)
                .map(endereco -> atualizaPrincipal(endereco, true))
                .map(EnderecoMapper::mapTo)
                .orElse(null);

    }

    private EnderecoEntity atualizaPrincipal(EnderecoEntity endereco, boolean isPrincipal){
        endereco.setPrincipal(isPrincipal);
        return enderecoRepository.save(endereco);
    }
}
