package com.yoyo.restfullapi.restfullapi.service;

import com.yoyo.restfullapi.restfullapi.entity.User;
import com.yoyo.restfullapi.restfullapi.model.LoginUserRequest;
import com.yoyo.restfullapi.restfullapi.model.TokenResponse;
import com.yoyo.restfullapi.restfullapi.repository.UserRepository;
import com.yoyo.restfullapi.restfullapi.security.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ValidationService validationService;

    @Transactional
    public TokenResponse login(LoginUserRequest request){
        validationService.validate(request);

        User user = userRepository.findById(request.getUsername())
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Username or Password wrong"));

        if(BCrypt.checkpw(request.getPassword(), user.getPassword())){
            //sukses
            user.setToken(UUID.randomUUID().toString());
            user.setTokenExpiredAt(next30Days());
            userRepository.save(user);

            //token response builder
            return TokenResponse.builder()
                    .token(user.getToken())
                    .expiredAt(user.getTokenExpiredAt())
                    .build();
        }else{
            //gagal login
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Username or Password wrong");
        }
    }

    @Transactional
    public void logout(User user){
        user.setToken(null);
        user.setTokenExpiredAt(null);

        userRepository.save(user);
    }

    private Long next30Days(){
        return System.currentTimeMillis() + (1000 * 60 * 60 * 24 * 30);
    }
}
