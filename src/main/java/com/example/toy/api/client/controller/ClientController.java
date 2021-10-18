package com.example.toy.api.client.controller;

import com.example.toy.api.client.data.dto.ClientResultDto;
import com.example.toy.api.client.data.param.ConsultParam;
import com.example.toy.api.client.enums.ClientRtCode;
import com.example.toy.api.client.service.ClientService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired ClientService clientService;

    @ApiOperation("나의문의목록 조회")
    @GetMapping("/{userid}/consult")
    public ResponseEntity getConsults(
            @PathVariable("userid") String userId
    ) {
        ClientResultDto result = new ClientResultDto();
        if(userId == null || userId.equals("")) {
            result.setRetCode(ClientRtCode.PARAMETER_ERROR.getCode());
            result.setRetMsg(ClientRtCode.PARAMETER_ERROR.getMsg());
        }

        return clientService.selectMyConsults(userId);
    }

    @ApiOperation("나의문의 등록")
    @PostMapping("/{userid}/consult")
    public ResponseEntity postConsult (
            @PathVariable(value = "userid", required = true) String userId,
            @RequestBody ConsultParam param
            ) {
        ClientResultDto result = new ClientResultDto();

        if(userId == null || userId.equals("")) {
            result.setRetCode(ClientRtCode.PARAMETER_ERROR.getCode());
            result.setRetMsg(ClientRtCode.PARAMETER_ERROR.getMsg());

            return ResponseEntity.ok(result);
        }

        return clientService.insertConsultContent(userId, param);
    }
}
