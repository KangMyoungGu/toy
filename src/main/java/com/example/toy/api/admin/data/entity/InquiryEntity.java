package com.example.toy.api.admin.data.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TBL_INQUIRY")
@Data
public class InquiryEntity {
    @Id
    @Column(name = "SEQ")
    public int seq;

    @Column(name = "TITLE")
    public String title;

    @Column(name = "CONTENT")
    public String content;

    @Column(name = "CUSTOMER_ID")
    public String customer_id;

    @Column(name = "REGISTER_DATE")
    public String register_date;

    @Column(name = "ANSWER_STATUS")
    public String answer_status;

    @Column(name = "MANAGER_ID")
    public String manager_id;

    @OneToMany(mappedBy ="inquiryEntity")
    public List<AnswerEntity> answer;
}
