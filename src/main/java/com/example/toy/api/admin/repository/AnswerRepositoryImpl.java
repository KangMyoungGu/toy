package com.example.toy.api.admin.repository;

import com.example.toy.api.admin.data.entity.AnswerEntity;
import com.example.toy.api.admin.data.entity.QAnswerEntity;
import com.example.toy.api.client.data.entity.QClientInquiryEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class AnswerRepositoryImpl implements AnswerCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;
    JPAQueryFactory qf;

    @Override
    public List<AnswerEntity> findBySeqIsInquirySeq(Integer seq) {
        QAnswerEntity answerEntity  = QAnswerEntity.answerEntity;

        qf = new JPAQueryFactory(entityManager);
        return qf.select(answerEntity)
                .from(answerEntity)
                .where(answerEntity.seq.eq(seq)).fetch();

    }
}
