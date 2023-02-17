package com.test.demo.config;

import com.test.demo.entities.Endereco;
import com.test.demo.entities.User;
import com.test.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantion implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User maria = new User(null, "Maria Silva", "14/02/1966");
        User joao = new User(null, "João Gomes", "23/03/1998");
        User felipe = new User(null, "Felipe Rosa", "21/01/1997");




        userRepository.saveAll(Arrays.asList(maria, joao, felipe));

    }
}
