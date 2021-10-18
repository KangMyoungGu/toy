package com.example.toy.api.admin.service;

import com.example.toy.api.admin.data.dto.AccountDto;
import com.example.toy.api.admin.data.dto.AccountResultDto;
import com.example.toy.api.admin.data.entity.AccountEntity;
import com.example.toy.api.admin.data.param.SignUpParam;
import com.example.toy.api.admin.enums.AccountRtCode;
import com.example.toy.api.admin.repository.AccountRepository;
import com.example.toy.utils.TokenUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


@Service
public class AccountServiceImpl implements AccountService {
    @Autowired private AccountRepository accountRepository;
    @Autowired private PasswordEncoder passwordEncoder;
    @Autowired private ModelMapper modelMapper;
    @Autowired private TokenUtil tokenUtil;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = true)
    public ResponseEntity login(String userId, String password) throws JsonProcessingException {
        AccountResultDto result = new AccountResultDto();

        // 사용자 없음
        if(!accountRepository.existsById(userId)) {
            result.setRetCode(AccountRtCode.NONUSER.getCode());
            result.setRetMsg(AccountRtCode.NONUSER.getMsg());

            return ResponseEntity.ok(result);
        }

        AccountEntity entity = accountRepository.findById(userId).get();

        if(!passwordEncoder.matches(password, entity.getPassword().toString())) {
            result.setRetCode(AccountRtCode.MISMATCH.getCode());
            result.setRetMsg(AccountRtCode.MISMATCH.getMsg());

            return ResponseEntity.ok(result);
        }


        String token = tokenUtil.create(modelMapper.map(entity, AccountDto.class));
        result.setToken(token);

        return ResponseEntity.ok(result);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
    public ResponseEntity signUp(SignUpParam param) {
        AccountResultDto result = new AccountResultDto();

        // 계정 존재 여부 확인
        if(accountRepository.existsById(param.getUserId())){
            result.setRetCode(AccountRtCode.EXISTSUSER.getCode());
            result.setRetMsg(AccountRtCode.EXISTSUSER.getMsg());

            return ResponseEntity.ok(result);
        }

        AccountEntity entity = new AccountEntity();
        entity.setUser_id(param.getUserId());
        entity.setPassword(passwordEncoder.encode(param.getPassword()));
        entity.setUser_name(param.getUserName());
        entity.setIsActive("A");
        entity.setRegister_date(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA).format(Calendar.getInstance().getTime()));
        entity.setActive_date(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA).format(Calendar.getInstance().getTime()));

        accountRepository.save(entity);

        return ResponseEntity.ok(result);
    }
}
