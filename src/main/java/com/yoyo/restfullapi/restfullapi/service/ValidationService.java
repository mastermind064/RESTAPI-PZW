package com.yoyo.restfullapi.restfullapi.service;

import com.yoyo.restfullapi.restfullapi.model.RegisterUserRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@SuppressWarnings("ALL")
@Service
public class ValidationService {

    @Autowired
    private Validator validator;

    public void validate(Object request){
        //validator.validate(request).var --> tab
        //berfungsi melakukan validasi pada object, yang sudah di define validasinya (misal @NotBlank, @Size dll)
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(request);
        if(constraintViolations.size() != 0){
            //error
            throw new ConstraintViolationException(constraintViolations);
        }
    }

}
