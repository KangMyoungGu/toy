package com.example.toy.api.admin.service;

import com.example.toy.api.admin.data.dto.AnswerResultDto;
import com.example.toy.api.admin.data.dto.InquiryDto;
import com.example.toy.api.admin.data.entity.AnswerEntity;
import com.example.toy.api.admin.data.entity.AnswerEntityId;
import com.example.toy.api.admin.data.entity.InquiryEntity;
import com.example.toy.api.admin.data.param.AnswerParam;
import com.example.toy.api.admin.enums.AnswerRtCode;
import com.example.toy.api.admin.repository.AnswerRepository;
import com.example.toy.api.admin.repository.InquiryRepository;
import com.example.toy.utils.TokenUtil;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class AnswerServiceImpl implements AnswerService {
    @Autowired private InquiryRepository inquiryRepository;
    @Autowired private AnswerRepository answerRepository;
    @Autowired private ModelMapper modelMapper;
    @Autowired private TokenUtil tokenUtil;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = true)
    public ResponseEntity selectInquiry(String token) {
        AnswerResultDto result = new AnswerResultDto();
        try {
            JSONObject obj = tokenUtil.tokenInfo(token);
            List<InquiryEntity> data = inquiryRepository.findByInquiryStatusIsReady(obj.get("user_id").toString());

            List<InquiryDto> list = new LinkedList<>();

            for(InquiryEntity entity : data) {
                list.add(modelMapper.map(entity, InquiryDto.class));
            }

            result.setData(list);
        } catch (ParseException e) {
            result.setRetCode(AnswerRtCode.WRONG_TOKEN.getCode());
            result.setRetMsg(AnswerRtCode.WRONG_TOKEN.getMsg());
        }

        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity selectInquiryInfo(String token, Integer seq) {
        AnswerResultDto result = new AnswerResultDto();
        try {
            JSONObject obj = tokenUtil.tokenInfo(token);

            InquiryEntity data = inquiryRepository.findById(seq).get();

            if(!data.manager_id.equals(obj.get("user_id"))) {
                result.setRetCode(AnswerRtCode.USER_NOT_MATCHED.getCode());
                result.setRetMsg(AnswerRtCode.USER_NOT_MATCHED.getMsg());

                return ResponseEntity.ok(result);
            }
            InquiryDto dto = modelMapper.map(data, InquiryDto.class);
            List<InquiryDto> list = new ArrayList<>();
            list.add(dto);

            result.setData(list);

        } catch (ParseException e) {
            result.setRetCode(AnswerRtCode.WRONG_TOKEN.getCode());
            result.setRetMsg(AnswerRtCode.WRONG_TOKEN.getMsg());
        }

        return ResponseEntity.ok(result);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
    public ResponseEntity updateInquiryAssign(String token, Integer seq) {
        AnswerResultDto result = new AnswerResultDto();

        try {
            JSONObject obj = tokenUtil.tokenInfo(token);

            InquiryEntity data = inquiryRepository.findById(seq).get();

            if(data.answer_status.equals("R")) {
                data.setAnswer_status("L");
                data.setManager_id(obj.get("user_id").toString());
                inquiryRepository.save(data);
            } else {
                result.setRetCode(AnswerRtCode.ALREADY_ASSIGN.getCode());
                result.setRetMsg(AnswerRtCode.ALREADY_ASSIGN.getMsg());
            }
        } catch (ParseException e) {
            result.setRetCode(AnswerRtCode.WRONG_TOKEN.getCode());
            result.setRetMsg(AnswerRtCode.WRONG_TOKEN.getMsg());
        }

        return ResponseEntity.ok(result);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
    public ResponseEntity insertAnswer(Integer seq, String token, AnswerParam param) {
        AnswerResultDto result = new AnswerResultDto();


        try {
            JSONObject obj = tokenUtil.tokenInfo(token);

            // 신규
            Optional<AnswerEntity> entity = Optional.of(new AnswerEntity());
            if(param.getAnswer_seq() == null) {
                entity.get().setSeq(seq);
                entity.get().setAnswer_seq(answerRepository.findBySeqIsInquirySeq(seq).size()+1);
                entity.get().setAnswer_title(param.getAnswer_title());
                entity.get().setAnswer_content(param.getAnswer_content());
                entity.get().setUser_id(obj.get("user_id").toString());
                entity.get().setRegister_date(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA).format(Calendar.getInstance().getTime()));
            }
            // 기존꺼 업데이트
            else {
                AnswerEntityId id = new AnswerEntityId();
                id.setSeq(seq);
                id.setAnswer_seq(param.getAnswer_seq());
                entity = answerRepository.findById(id);

                entity.get().setSeq(seq);
                entity.get().setAnswer_seq(param.getAnswer_seq());
                entity.get().setAnswer_title(param.getAnswer_title());
                entity.get().setAnswer_content(param.getAnswer_content());
                entity.get().setUser_id(obj.get("user_id").toString());
                entity.get().setRegister_date(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA).format(Calendar.getInstance().getTime()));
            }

            answerRepository.save(entity.get());

            InquiryEntity inquiryEntity = inquiryRepository.findById(seq).get();
            inquiryEntity.setAnswer_status("S");
            inquiryRepository.save(inquiryEntity);

            return ResponseEntity.ok(result);
        } catch (ParseException e) {
            result.setRetCode(AnswerRtCode.WRONG_TOKEN.getCode());
            result.setRetMsg(AnswerRtCode.WRONG_TOKEN.getMsg());

            return ResponseEntity.ok(result);
        }
    }
}
