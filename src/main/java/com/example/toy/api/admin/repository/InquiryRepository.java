package com.example.toy.api.admin.repository;

import com.example.toy.api.admin.data.entity.InquiryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InquiryRepository extends JpaRepository<InquiryEntity, Integer>, InquiryCustomRepository {
}
