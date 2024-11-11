package com.todo.demo.services;

import com.github.f4b6a3.ulid.Ulid;
import com.github.f4b6a3.ulid.UlidCreator;
import com.todo.demo.entities.User;
import com.todo.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public  UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    public User createUser(User user){

        Ulid ulid = UlidCreator.getUlid();
        user.setPassword("daiveekam");
        user.setId(ulid.toString());
        return userRepository.save(user);
    }
}
