package com.example.toy.api.admin.service;

import com.example.toy.api.admin.data.param.SignUpParam;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;

public interface AccountService {
    ResponseEntity login(String userId, String password) throws JsonProcessingException;

    ResponseEntity signUp(SignUpParam param);
}
