package com.example.toy.api.client.data.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TBL_ANSWER")
@Data
@IdClass(ClientAnswerEntityId.class)
public class ClientAnswerEntity {
    @Id
    public int seq;

    @Id
    public int answer_seq;

    @Column(name = "ANSWER_TITLE")
    public String answer_title;

    @Column(name = "ANSWER_CONTENT")
    public String answer_content;

    @Column(name = "USER_ID")
    public String user_id;

    @Column(name = "REGISTER_DATE")
    public String register_date;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "SEQ", insertable = false, updatable = false)
    public ClientInquiryEntity clientInquiryEntity;
}
