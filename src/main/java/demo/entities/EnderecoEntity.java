package demo.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ENDERECO")
public class EnderecoEntity {

    @Id
    @SequenceGenerator(allocationSize = 1, name = "ENDERECO_SEQ", sequenceName = "ENDERECO_SEQ")
    @GeneratedValue(generator = "ENDERECO_SEQ", strategy = GenerationType.SEQUENCE)
    private Long id;

    private String logradouro;
    private String cep;
    private String numero;
    private String cidade;
    @Column(name = "endereco_principal")
    private boolean principal;
    @Column(name = "cpf_pessoa")
    private String cpfPessoa;

    @ManyToOne(cascade = CascadeType.ALL, fetch= FetchType.LAZY)
    @JoinColumn(name = "id_pessoa")
    private PessoaEntity pessoa;

}