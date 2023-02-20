package demo.api;

import demo.dto.EnderecoDTO;
import demo.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/v1/endereco")
@RestController
public class EnderecoApi {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping("/salvar/{cpf}")
    public ResponseEntity<EnderecoDTO> salvarEndereco(@RequestBody EnderecoDTO body, @PathVariable String cpf){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(enderecoService.salvar(body, cpf));
    }

    @GetMapping("/listar/{cpf}")
    public ResponseEntity<?> buscaEndereco(@PathVariable String cpf){
        List<EnderecoDTO> enderecos = enderecoService.findByCpf(cpf);
        if (enderecos.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não há dados para o CPF informado!");
        return ResponseEntity.ok(enderecos);
    }

    @PutMapping("/principal/{cpf}/{id}")
    public ResponseEntity<?> enderecoPrincipal(@PathVariable String cpf, @PathVariable Long id){
        EnderecoDTO endereco = enderecoService.principalEndereco(cpf, id);
        if (endereco == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi possível atualizar o endereço. Verifique o CPF e ID passados!");
        return ResponseEntity.ok(endereco);
    }
}

