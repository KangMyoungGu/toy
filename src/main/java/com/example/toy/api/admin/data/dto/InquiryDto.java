package com.example.toy.api.admin.data.dto;

import com.example.toy.api.admin.data.entity.AnswerEntity;
import com.sun.xml.internal.ws.developer.Serialization;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Serialization
public class InquiryDto {
    public int seq;
    public String title;
    public String content;
    public String customer_id;
    public String register_date;
    public String answer_status;
    public String manager_id;
    public List<AnswerDto> answer;
}
