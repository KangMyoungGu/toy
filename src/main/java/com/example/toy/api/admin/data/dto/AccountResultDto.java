package com.example.toy.api.admin.data.dto;

import com.example.toy.api.admin.enums.AccountRtCode;
import lombok.Data;

@Data
public class AccountResultDto {
    public String retCode = AccountRtCode.SUCCESS.getCode();
    public String retMsg = AccountRtCode.SUCCESS.getMsg();

    public String token;
}
