package com.example.toy.api.admin.data.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

@Entity
@Table(name = "TBL_ACCOUNT")
@Data
public class AccountEntity {
    @Id
    @Column(name = "USER_ID")
    private String user_id;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "USER_NAME")
    private String user_name;

    @Column(name = "ISACTIVE")
    private String isActive;

    @Column(name = "REGISTER_DATE")
    private String register_date;

    @Column(name = "ACTIVE_DATE")
    private String active_date;
}