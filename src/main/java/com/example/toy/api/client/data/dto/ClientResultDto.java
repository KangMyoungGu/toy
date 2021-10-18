package com.example.toy.api.client.data.dto;

import com.example.toy.api.client.enums.ClientRtCode;
import lombok.Data;

import java.util.List;

@Data
public class ClientResultDto {
    private String retCode = ClientRtCode.SUCCESS.getCode();
    private String retMsg = ClientRtCode.SUCCESS.getMsg();

    private List<ClientInquiryDto> data;
}
