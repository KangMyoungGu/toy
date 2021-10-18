package com.example.toy.api.client.data.entity;

import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;

@Data
public class ClientAnswerEntityId implements Serializable {
    @Column(name = "SEQ")
    public int seq;

    @Column(name = "ANSWER_SEQ")
    public int answer_seq;
}
