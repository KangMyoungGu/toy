package com.example.toy.api.admin.controller;

import com.example.toy.api.admin.data.dto.AccountResultDto;
import com.example.toy.api.admin.data.param.SignUpParam;
import com.example.toy.api.admin.enums.AccountRtCode;
import com.example.toy.api.admin.service.AccountService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired private AccountService accountService;

    @GetMapping("/login")
    @ApiOperation("로그인")
    public ResponseEntity login(
            @RequestParam(value = "userId", required = true) String userId,
            @RequestParam(value = "password", required = true) String password
    ) throws JsonProcessingException {
        if(userId.equals("") || userId == null || password.equals("") || password == null) {
            AccountResultDto result = new AccountResultDto();
            result.setRetCode(AccountRtCode.PARAMETER_ERROR.getCode());
            result.setRetMsg(AccountRtCode.PARAMETER_ERROR.getMsg());

            return ResponseEntity.ok(result);
        }

        return accountService.login(userId, password);
    }

    @PostMapping("/signup")
    @ApiOperation("사용자계정등록")
    public ResponseEntity signUp(@RequestBody SignUpParam param) {

        if(param.getUserId().equals("") || param.getUserId() == null ||
                param.getPassword().equals("") || param.getPassword() == null ||
                param.getUserName().equals("") || param.getUserName() == null
        ) {
            AccountResultDto result = new AccountResultDto();
            result.setRetCode(AccountRtCode.PARAMETER_ERROR.getCode());
            result.setRetMsg(AccountRtCode.PARAMETER_ERROR.getMsg());

            return ResponseEntity.ok(result);
        }

        return accountService.signUp(param);
    }
}
