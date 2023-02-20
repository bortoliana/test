package demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoDTO {

    private String logradouro;
    private String cep;
    private String numero;
    private String cidade;
    private Long id;

    @JsonProperty("endereco_principal")
    private boolean isPrincipal = false;

}
