package demo.mapper;

import demo.dto.PessoaDTO;
import demo.entities.PessoaEntity;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PessoaMapper {

    public static PessoaEntity mapTo(PessoaDTO pessoaDTO) {
        if (pessoaDTO == null) return null;

        return PessoaEntity.builder()
                .cpf(pessoaDTO.getCpf())
                .nome(pessoaDTO.getNome())
                .dataNascimento(pessoaDTO.getDataNascimento())
                .enderecos(EnderecoMapper.mapToListEntity(pessoaDTO.getEnderecos(), pessoaDTO.getCpf()))
                .build();
    }

    public static PessoaDTO mapTo(PessoaEntity pessoaEntity) {
        if (pessoaEntity == null) return null;

        return PessoaDTO.builder()
                .cpf(pessoaEntity.getCpf())
                .nome(pessoaEntity.getNome())
                .dataNascimento(pessoaEntity.getDataNascimento())
                .enderecos(EnderecoMapper.mapToListDTO(pessoaEntity.getEnderecos()))
                .build();
    }
}