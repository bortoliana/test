package com.test.demo.service;

import com.test.demo.dto.UserDTO;
import com.test.demo.entities.User;
import com.test.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;
    public List<User> findAll() {
        return repo.findAll();

    }
    public User insert (User obj){
        return repo.save(obj);
    }

    public User update(User obj) {
        User newObj = repo.findById(obj.getId()).get();
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    private void updateData(User newObj, User obj) {
        newObj.setNome(obj.getNome());
        newObj.setNascimento(obj.getNascimento());
    }

    public User fromDTO(UserDTO objDto){
        return new User(objDto.getId(), objDto.getNome(), objDto.getNascimento());
    }

}
