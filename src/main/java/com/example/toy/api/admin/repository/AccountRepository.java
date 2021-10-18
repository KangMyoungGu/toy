package com.example.toy.api.admin.repository;

import com.example.toy.api.admin.data.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountEntity, String>, AccountCustomRepository {
}
