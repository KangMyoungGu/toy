package com.example.toy.api.admin.repository;

import com.example.toy.api.admin.data.entity.InquiryEntity;
import com.example.toy.api.admin.data.entity.QAnswerEntity;
import com.example.toy.api.admin.data.entity.QInquiryEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class InquiryRepositoryImpl implements InquiryCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;
    JPAQueryFactory qf;

    @Override
    public List<InquiryEntity> findByInquiryStatusIsReady(String userId) {
        QInquiryEntity inquiryEntity  = QInquiryEntity.inquiryEntity;

        qf = new JPAQueryFactory(entityManager);

        // 답변대기중이거나, 현재 사용자의 ID로 미리 잡아둔 건.
        return qf.select(inquiryEntity)
                .from(inquiryEntity)
                .where(
                        inquiryEntity.answer_status.eq("R")
                                .or(inquiryEntity.answer_status.eq("L").and(inquiryEntity.manager_id.eq(userId)))
                ).orderBy(inquiryEntity.register_date.desc()).fetch()
                ;


    }
}
