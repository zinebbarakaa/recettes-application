package com.karizma.recettes.services.implementation;

import com.karizma.recettes.entities.Recette;
import com.karizma.recettes.entities.User;
import com.karizma.recettes.mappers.RecetteMapper;
import com.karizma.recettes.mappers.UserMapper;
import com.karizma.recettes.models.request.UserRequest;
import com.karizma.recettes.models.response.LoginResponse;
import com.karizma.recettes.models.response.UserResponse;
import com.karizma.recettes.repositories.UserRepository;
import com.karizma.recettes.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    @Override
    public UserResponse register(UserRequest request) {
        User user = UserMapper.INSTANCE.requestToEntity(request);

        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        userRepository.save(user);
        return UserMapper.INSTANCE.entityToResponse(user);
    }
        @Override
    public LoginResponse login(UserRequest request) {

        // Authenticate the user with the provided credentials.
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword()
        ));

        // Find the user based on the username.
        var user = userRepository.findByEmail(request.getEmail()).get();

            var AccessToken = jwtService.generateToken( user);
            var RefreshToken = jwtService.generateRefreshToken( user);
            // Build the login response for each role and add it to the list.
         return   LoginResponse.builder().refreshToken(RefreshToken).accessToken(AccessToken).build();


    }





    @Override
    public UserResponse add(UserRequest request) {
        User user = UserMapper.INSTANCE.requestToEntity(request);

        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        userRepository.save(user);
        return UserMapper.INSTANCE.entityToResponse(user);
    }

    @Override
    public List<UserResponse> get() {
        return null;
    }

    @Override
    public UserResponse update(UserRequest request, Long aLong) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public UserResponse get(Long aLong) {
        return null;
    }
}
