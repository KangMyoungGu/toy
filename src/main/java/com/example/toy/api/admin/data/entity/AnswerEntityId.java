package com.example.toy.api.admin.data.entity;

import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;

@Data
public class AnswerEntityId implements Serializable {
    @Column(name = "SEQ")
    public int seq;

    @Column(name = "ANSWER_SEQ")
    public int answer_seq;
}
