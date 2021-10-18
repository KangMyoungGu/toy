package com.example.toy.api.admin.repository;

import com.example.toy.api.admin.data.entity.AnswerEntity;

import java.util.List;

public interface AnswerCustomRepository {
    List<AnswerEntity> findBySeqIsInquirySeq(Integer seq);
}
