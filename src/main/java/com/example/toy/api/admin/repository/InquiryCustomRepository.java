package com.example.toy.api.admin.repository;

import com.example.toy.api.admin.data.entity.InquiryEntity;

import java.util.List;

public interface InquiryCustomRepository {
    List<InquiryEntity> findByInquiryStatusIsReady(String userId);
}
