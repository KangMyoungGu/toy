package com.example.toy.api.admin.controller;

import com.example.toy.api.admin.data.dto.AnswerResultDto;
import com.example.toy.api.admin.data.param.AnswerParam;
import com.example.toy.api.admin.enums.AnswerRtCode;
import com.example.toy.api.admin.service.AnswerService;
import io.swagger.annotations.ApiOperation;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inquiry")
public class AnswerController {
    @Autowired private AnswerService answerService;

    @ApiOperation("사용자 문의 조회")
    @GetMapping("/")
    public ResponseEntity getInquiry(
            @RequestHeader("token") String token
    ) {
        return answerService.selectInquiry(token);
    }

    @ApiOperation("사용자 문의 상세정보 조회")
    @GetMapping("/{seqno}")
    public ResponseEntity getInquiry(
            @RequestHeader("token") String token,
            @PathVariable("seqno") Integer seq
    ) {
        return answerService.selectInquiryInfo(token, seq);
    }


    @ApiOperation("사용자 지정")
    @PutMapping("/{seqno}/assign")
    public ResponseEntity putInquiryAssign(
            @RequestHeader("token") String token,
            @PathVariable("seqno") Integer seq
    ) throws ParseException {
        AnswerResultDto result = new AnswerResultDto();

        if(seq == null) {
            result.setRetCode(AnswerRtCode.PARAMETER_ERROR.getCode());
            result.setRetMsg(AnswerRtCode.PARAMETER_ERROR.getMsg());

            return ResponseEntity.ok(result);
        }

        return answerService.updateInquiryAssign(token, seq);

    }

    @ApiOperation("답변 등록")
    @PostMapping("/{seqno}/answer")
    public ResponseEntity postAnswer(
            @RequestHeader("token") String token,
            @PathVariable("seqno") Integer seq,
            @RequestBody AnswerParam param
            ) {
        AnswerResultDto result = new AnswerResultDto();

        if(seq == null) {
            result.setRetCode(AnswerRtCode.PARAMETER_ERROR.getCode());
            result.setRetMsg(AnswerRtCode.PARAMETER_ERROR.getMsg());

            return ResponseEntity.ok(result);
        }

        return answerService.insertAnswer(seq, token, param);
    }
}
