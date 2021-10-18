package com.example.toy.api.client.repository;

import com.example.toy.api.client.data.entity.ClientInquiryEntity;

import java.util.List;

public interface ClientCustomRepository {
    List<ClientInquiryEntity> selectMyConsults(String userId);
}
