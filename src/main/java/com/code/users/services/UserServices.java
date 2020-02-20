package com.code.users.services;

import com.code.users.exception.ResourcesNotFoundException;
import com.code.users.model.User;
import com.code.users.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServices{

    // define userRepository interface reference
    @Autowired
    private final UserRepository userRepository;

    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //define a method to check if exists
    public boolean ifExists(Long id){

        return userRepository.existsById(id);
    }

    //define an method to get all users in the database
    public List<User> getAllUsers(){

        return userRepository.findAll();

    }

    //find user by Id
    public Optional<User> findById(Long id){
        //        return userRepository.findById(id).orElse(null);


        return userRepository.findById(id);
    }

    //Delete user by id
    public void delteById(Long id) throws ResourcesNotFoundException {
        //check if user exists
        if (!ifExists(id)){
            throw new ResourcesNotFoundException("Can not find user with id " + id);
        }

        userRepository.deleteById(id);
    }

    public List<User> getUser(String codewarsusername){

        List<User> users = userRepository.findByCodewarsusername(codewarsusername);
        return userRepository.findByCodewarsusername(codewarsusername);
    }

    //add users
    public void add(User user){
       userRepository.save(user);
    }
}
