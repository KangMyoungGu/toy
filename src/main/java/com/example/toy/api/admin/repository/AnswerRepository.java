package com.example.toy.api.admin.repository;

import com.example.toy.api.admin.data.entity.AnswerEntity;
import com.example.toy.api.admin.data.entity.AnswerEntityId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<AnswerEntity, AnswerEntityId>, AnswerCustomRepository {

}
