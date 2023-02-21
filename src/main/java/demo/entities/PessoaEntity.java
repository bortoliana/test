package demo.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
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
    @SequenceGenerator(allocationSize = 1, name = "PESSOA_SEQ", sequenceName = "PESSOA_SEQ")
    @GeneratedValue(generator = "PESSOA_SEQ", strategy = GenerationType.SEQUENCE)
    private Long id;
    private String cpf;
    private String nome;
    private LocalDate dataNascimento;

    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinColumn(name = "id_pessoa")
    private List<EnderecoEntity> enderecos;
}