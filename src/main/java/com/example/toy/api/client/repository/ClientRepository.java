package com.example.toy.api.client.repository;

import com.example.toy.api.client.data.entity.ClientInquiryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientInquiryEntity, String>, ClientCustomRepository {
}
