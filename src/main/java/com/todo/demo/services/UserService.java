package com.todo.demo.services;

import com.github.f4b6a3.ulid.Ulid;
import com.github.f4b6a3.ulid.UlidCreator;
import com.todo.demo.entities.User;
import com.todo.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public  UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    public User createUser(User user){

        Ulid ulid = UlidCreator.getUlid();
        Map encoders = new HashMap<>();
        encoders.put("bcrypt",new BCryptPasswordEncoder());
        PasswordEncoder passwordEncoder = new DelegatingPasswordEncoder("bcrypt",encoders);
        System.out.println(passwordEncoder.encode("allen"));
        user.setPassword("daiveekam");
        user.setId(ulid.toString());
        return userRepository.save(user);
    }
}
