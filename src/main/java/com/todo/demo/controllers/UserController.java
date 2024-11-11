package com.todo.demo.controllers;

import com.todo.demo.entities.User;
import com.todo.demo.http.response.ApiResponse;
import com.todo.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;


    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping(path = "/create")
    public ResponseEntity<ApiResponse<Void>> createUserController(@RequestBody User user){
        userService.createUser(user);
        ApiResponse<Void>myResponse = new ApiResponse<>("success");
        return ResponseEntity.status(HttpStatus.CREATED).body(myResponse);

    }
}
