package com.example.toy.api.client.repository;

import com.example.toy.api.admin.data.entity.InquiryEntity;
import com.example.toy.api.admin.data.entity.QInquiryEntity;
import com.example.toy.api.client.data.entity.ClientInquiryEntity;
import com.example.toy.api.client.data.entity.QClientInquiryEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ClientRepositoryImpl implements ClientCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;
    JPAQueryFactory qf;

    @Override
    public List<ClientInquiryEntity> selectMyConsults(String userId) {
        QClientInquiryEntity inquiryEntity  = QClientInquiryEntity.clientInquiryEntity;

        qf = new JPAQueryFactory(entityManager);
        return qf.select(inquiryEntity)
                .from(inquiryEntity)
                .where(inquiryEntity.customer_id.eq(userId)).fetch();


    }
}
