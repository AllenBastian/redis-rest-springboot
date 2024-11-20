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

        //create an unauthenticated object of user-pass auth
        Authentication authenticationRequest = UsernamePasswordAuthenticationToken.unauthenticated(
                loginRequest.getUsername(),loginRequest.getPassword()
        );


        /*use the authenticationManager bean in security config to authenticate request
        This bean have been provided with DAO auth provider and other services
         */

        Authentication authenticationResponse = authenticationManager.authenticate(authenticationRequest);

    }
}
