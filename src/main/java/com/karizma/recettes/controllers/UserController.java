package com.karizma.recettes.controllers;

import com.karizma.recettes.models.request.UserRequest;
import com.karizma.recettes.models.response.LoginResponse;
import com.karizma.recettes.models.response.UserResponse;
import com.karizma.recettes.services.UserService;
import com.karizma.recettes.services.implementation.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("api/auth/")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserServiceImpl userServiceImpl;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody UserRequest loginRequest) {
        return new ResponseEntity<>(userService.login(loginRequest), HttpStatus.OK);
    }



    @PostMapping("/register")
    @PreAuthorize("hasRole('SUPER_ADMIN') and hasAuthority('SUPER_ADMIN_CREATE')")
    public ResponseEntity<UserResponse> register(@RequestBody UserRequest request) {
        return new ResponseEntity<>(userService.register(request), HttpStatus.CREATED);
    }


}
