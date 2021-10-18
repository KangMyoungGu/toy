package com.example.toy.api.client.data.entity;

import com.example.toy.api.admin.data.entity.AnswerEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TBL_INQUIRY")
@Data
public class ClientInquiryEntity {
    @Id
    @Column(name = "SEQ")
    private int seq;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "CUSTOMER_ID")
    private String customer_id;

    @Column(name = "REGISTER_DATE")
    private String register_date;

    @Column(name = "ANSWER_STATUS")
    private String answer_status;

    @Column(name = "MANAGER_ID")
    private String manager_id;

    @OneToMany(mappedBy ="clientInquiryEntity")
    public List<ClientAnswerEntity> answer;
}
