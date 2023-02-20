package demo.api;

import demo.dto.PessoaDTO;
import demo.service.PessoaService;
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

@RequestMapping ("/v1/pessoa")
@RestController
public class PessoaApi {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping("/salvar")
    public ResponseEntity<PessoaDTO> salvarPessoa(@RequestBody PessoaDTO body){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(pessoaService.salvar(body));
    }

    @PutMapping("/editar")
    public ResponseEntity<PessoaDTO> editarPessoa(@RequestBody PessoaDTO body){
        return ResponseEntity.ok(pessoaService.salvar(body));
    }

    @GetMapping("/buscar/{cpf}")
    public ResponseEntity<?> buscaPessoa(@PathVariable String cpf){
        PessoaDTO pessoaDTO = pessoaService.findByCpf(cpf);
        if (pessoaDTO == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não há dados para o CPF informado!");
        return ResponseEntity.ok(pessoaDTO);
    }

    @GetMapping("/listar")
    public ResponseEntity<?> buscarTodasPessoas(){
        List<PessoaDTO> pessoas = pessoaService.findAll();
        if (pessoas.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não há dados salvos!");
        return ResponseEntity.ok(pessoas);
    }
}
