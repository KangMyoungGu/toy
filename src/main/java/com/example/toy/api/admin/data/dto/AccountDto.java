package com.example.toy.api.admin.data.dto;

import lombok.Data;

@Data
public class AccountDto {
    public String user_id;
    public String password;
    public String user_name;
    public String isActive;
    public String register_date;
    public String active_date;
}

