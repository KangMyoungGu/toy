package com.example.toy.api.admin.data.dto;


import com.example.toy.api.admin.data.entity.InquiryEntity;
import com.example.toy.api.admin.enums.AccountRtCode;
import com.example.toy.api.admin.enums.AnswerRtCode;
import lombok.Data;

import java.util.List;

@Data
public class AnswerResultDto {
    public String retCode = AnswerRtCode.SUCCESS.getCode();
    public String retMsg = AnswerRtCode.SUCCESS.getMsg();

    public List<InquiryDto> data;
}
