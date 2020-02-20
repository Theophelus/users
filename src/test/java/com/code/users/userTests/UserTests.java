package com.code.users.userTests;


import com.code.users.model.User;
import com.code.users.repositories.UserRepository;
import com.code.users.services.UserServices;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTests {

    @Autowired
    private UserServices userServices;

    @Autowired
    private UserRepository userRepository;




    @Test
    public void findAllUsers(){


        User user = new User(4,"Phumlani","Duncan");

        userServices.add(user);

//        System.out.println(userServices.findById(user.getId()));
        System.out.println(userServices.getAllUsers());
//        System.out.println("", userServices.findById(user.getId()));

//        assertEquals("", userServices.getAllUsers());
    }
}
