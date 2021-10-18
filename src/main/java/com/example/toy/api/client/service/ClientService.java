package com.example.toy.api.client.service;

import com.example.toy.api.client.data.param.ConsultParam;
import org.springframework.http.ResponseEntity;

public interface ClientService {
    ResponseEntity selectMyConsults(String userId);

    ResponseEntity insertConsultContent(String userId, ConsultParam param);

}
