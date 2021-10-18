package com.example.toy.api.client.data.dto;

import lombok.Data;

@Data
public class ClientAnswerDto {
    public int seq;
    public int answer_seq;
    public String answer_title;
    public String answer_content;
    public String user_id;
    public String register_date;
}
