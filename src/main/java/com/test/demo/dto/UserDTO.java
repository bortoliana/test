package com.test.demo.dto;

import com.test.demo.entities.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;


@Entity
@Data
@NoArgsConstructor
public class UserDTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String nome;
    private String nascimento;

    public UserDTO(User obj){
        id = obj.getId();
        nome = obj.getNome();
        nascimento = obj.getNascimento();
    }
}
