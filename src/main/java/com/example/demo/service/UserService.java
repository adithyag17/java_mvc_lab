package com.example.demo.service;

import com.example.demo.model.Accounts;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<Accounts> getAllUsers(){
        return userRepository.findAll();
    }

    public Accounts getUserById(Long id){ 
        return userRepository.findById(id).orElse(null);
    }

    public Accounts addUser(Accounts user){
        return userRepository.save(user);
    }

    public Accounts updateUser(Long id, Accounts updatedUser) {
        Accounts user=userRepository.findById(id).orElse(null);
        if(user!=null){
            user.setUsername(updatedUser.getUsername());
            user.setPassword(updatedUser.getPassword());
            return userRepository.save(user);
        }
        return null;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
