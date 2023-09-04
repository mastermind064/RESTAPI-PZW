package com.yoyo.restfullapi.restfullapi.service;

import com.yoyo.restfullapi.restfullapi.entity.User;
import com.yoyo.restfullapi.restfullapi.model.RegisterUserRequest;
import com.yoyo.restfullapi.restfullapi.model.UpdateUserRequest;
import com.yoyo.restfullapi.restfullapi.model.UserResponse;
import com.yoyo.restfullapi.restfullapi.repository.UserRepository;
import com.yoyo.restfullapi.restfullapi.security.BCrypt;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;
import java.util.Set;

@SuppressWarnings("ALL")
@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ValidationService validationService;

    @Transactional
    public void register(RegisterUserRequest request){

        validationService.validate(request);

        //check if user already exists
        if(userRepository.existsById(request.getUsername())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already registered");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        //password disimpan dg enkripsi, pakai Bcript
        /*
        buat encrypt:
            String pw_hash = BCrypt.hashpw(plain_password, BCrypt.gensalt());

        buat cek pass:
            if (BCrypt.checkpw(candidate_password, stored_hash))
                System.out.println("It matches");
            else
                System.out.println("It does not match");
        */
        user.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()));
        user.setName(request.getName());

        userRepository.save(user);
    }

    public UserResponse get(User user){
        return UserResponse.builder()
                .username(user.getUsername())
                .name(user.getName())
                .build();
    }

    @Transactional
    public UserResponse update(User user, UpdateUserRequest request){
        validationService.validate(request);

        if(Objects.nonNull(request.getName())){
            user.setName(request.getName());
        }

        if(Objects.nonNull(request.getPassword())){
            user.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()));
        }

        userRepository.save(user);
        return UserResponse.builder()
                .name(user.getName())
                .username(user.getUsername())
                .build();
    }

    
}
