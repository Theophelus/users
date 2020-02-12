package com.code.users.controller;


import com.code.users.exception.ResourcesNotFoundException;
import com.code.users.model.User;
import com.code.users.services.UserServices;
//import org.graalvm.compiler.nodes.extended.OSRMonitorEnterNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

class CodewarsData {

    String username;
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Value("${api.key}")
    private String apiKey;

    @Autowired
    private final UserServices userServices;
    @Autowired
    private RestTemplate restTemplate;

//    public UserController(){}
    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @RequestMapping(path = "/users", produces = "application/json", method = RequestMethod.GET)
    public List<User> getAll(){

        return userServices.getAllUsers();
    }

    @RequestMapping(path = "/users/username/{codewarsusername}", produces = "application/json", method = RequestMethod.GET)
    public Object getByUsername(@PathVariable String codewarsusername ){

        List<Object> list = Collections.singletonList(userServices.getUser(codewarsusername));

        List<Object> userOutput = new ArrayList<>();

        for (Object user : list){

            String url = "https://www.codewars.com/api/v1/users/" + codewarsusername;
            Object user1 = restTemplate.getForObject(url, Object.class);
            System.out.println(user1);

            userOutput.add(user1);
        }

        return userOutput;
    }

    //find user by Id
    @RequestMapping(path = "/users/{userId}", produces = "application/json", method = RequestMethod.GET)
    public User getById(
            @PathVariable Long userId){
        return userServices.findById(userId);
    }

    @RequestMapping(path = "/users/add", produces = "application/json", method = RequestMethod.POST)
    public void addUser(@RequestBody User user){
        userServices.addUser(user);
    }

    @RequestMapping(path = "/users/{id}", produces = "application/json", method = RequestMethod.DELETE)

    public void deleteById(
            @PathVariable Long id
    )  {
        try {
            userServices.delteById(id);
        } catch (ResourcesNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}
