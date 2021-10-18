package com.example.toy.api.admin.service;

import com.example.toy.api.admin.data.param.AnswerParam;
import org.json.simple.parser.ParseException;
import org.springframework.http.ResponseEntity;

public interface AnswerService {
    ResponseEntity selectInquiry(String token);

    ResponseEntity selectInquiryInfo(String token, Integer seq);

    ResponseEntity updateInquiryAssign(String token, Integer seq) throws ParseException;

    ResponseEntity insertAnswer(Integer seq, String token, AnswerParam param);

}
