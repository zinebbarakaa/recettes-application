package com.karizma.recettes.services;

import com.karizma.recettes.entities.User;
import com.karizma.recettes.models.request.UserRequest;
import com.karizma.recettes.models.response.LoginResponse;
import com.karizma.recettes.models.response.UserResponse;

import java.util.List;

public interface UserService extends CrudService<UserRequest, UserResponse, User,Long>{
    UserResponse register(UserRequest request);
    LoginResponse login(UserRequest request);
}
