package demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PESSOA")
public class PessoaEntity {

    @Id
    @Column(name = "id")
    private String cpf;
    private String nome;
    private LocalDate dataNascimento;

    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="pessoa")
    private List<EnderecoEntity> enderecos;
}