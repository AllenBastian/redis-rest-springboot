package com.todo.demo.controllers;

import com.todo.demo.http.request.LoginRequest;
import com.todo.demo.http.response.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class LoginController {

    private final AuthenticationManager authenticationManager;

    @Autowired
    public LoginController(AuthenticationManager authenticationManager){
        this.authenticationManager = authenticationManager;
    }

    @PostMapping(path = "/login")
    public void loginController(@Valid @RequestBody LoginRequest loginRequest){

        System.out.println(loginRequest.getUsername());
        System.out.println(loginRequest.getPassword());

//        Authentication authenticationRequest = UsernamePasswordAuthenticationToken.unauthenticated(
//                loginRequest.getUsername(),loginRequest.getPassword()
//        );

//        System.out.println(authenticationRequest.isAuthenticated());
//        System.out.println(authenticationRequest.getCredentials());

//        Authentication authenticationResponse = authenticationManager.authenticate(authenticationRequest);

    }
}
