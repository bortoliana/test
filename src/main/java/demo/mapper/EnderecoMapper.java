package demo.mapper;

import demo.dto.EnderecoDTO;
import demo.entities.EnderecoEntity;

import java.util.Collections;
import java.util.List;

public class EnderecoMapper {

  public static List<EnderecoEntity> mapToListEntity(List<EnderecoDTO> listaEnderecos, String cpf) {
    if (listaEnderecos == null) return Collections.emptyList();

    return listaEnderecos.stream()
            .map(endereco -> EnderecoMapper.mapTo(endereco, cpf))
            .toList();
  }

  public static List<EnderecoDTO> mapToListDTO(List<EnderecoEntity> listaEnderecos) {
    if (listaEnderecos == null) return Collections.emptyList();

    return listaEnderecos.stream()
            .map(EnderecoMapper::mapTo)
            .toList();
  }

  public static EnderecoEntity mapTo(EnderecoDTO enderecoDTO, String cpf) {
    if (enderecoDTO == null) return null;

    return EnderecoEntity.builder()
            .logradouro(enderecoDTO.getLogradouro())
            .cep(enderecoDTO.getCep())
            .numero(enderecoDTO.getNumero())
            .cidade(enderecoDTO.getCidade())
            .principal(enderecoDTO.isPrincipal())
            .cpfPessoa(cpf)
            .build();
  }

  public static EnderecoDTO mapTo(EnderecoEntity enderecoEntity) {
    if (enderecoEntity == null) return null;

    return EnderecoDTO.builder()
            .logradouro(enderecoEntity.getLogradouro())
            .cep(enderecoEntity.getCep())
            .numero(enderecoEntity.getNumero())
            .cidade(enderecoEntity.getCidade())
            .isPrincipal(enderecoEntity.isPrincipal())
            .id(enderecoEntity.getId())
            .build();
  }
}
