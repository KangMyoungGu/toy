package com.example.toy.api.client.data.dto;

import lombok.Data;
import java.util.List;

@Data
public class ClientInquiryDto {
    public String seq;
    public String title;
    public String content;
    public String customer_id;
    public String register_date;
    public String answer_status;
    public String manager_id;

    public List<ClientAnswerDto> answer;
}
