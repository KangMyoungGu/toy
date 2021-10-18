package com.example.toy.api.client.service;

import com.example.toy.api.client.data.dto.ClientResultDto;
import com.example.toy.api.client.data.dto.ClientInquiryDto;
import com.example.toy.api.client.data.entity.ClientInquiryEntity;
import com.example.toy.api.client.data.param.ConsultParam;
import com.example.toy.api.client.enums.ClientRtCode;
import com.example.toy.api.client.repository.ClientRepository;
import com.example.toy.utils.StringUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

@Service
public class ClientServiceImpl implements ClientService{
    @Autowired private ModelMapper modelMapper;
    @Autowired private ClientRepository clientRepository;
    @Autowired private StringUtil strUtil;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = true)
    public ResponseEntity selectMyConsults(String userId) {
        ClientResultDto result = new ClientResultDto();
        List<ClientInquiryEntity> data = clientRepository.selectMyConsults(userId);

        if (data.size() == 0) {
            result.setRetCode(ClientRtCode.NONDATA.getCode());
            result.setRetMsg(ClientRtCode.NONDATA.getMsg());

            return ResponseEntity.ok(result);
        }

        List<ClientInquiryDto> list = new LinkedList<>();
        for(ClientInquiryEntity entity : data) {
            list.add(modelMapper.map(entity, ClientInquiryDto.class));
        }
        result.setData(list);
        return ResponseEntity.ok(result);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
    public ResponseEntity insertConsultContent(String userId,ConsultParam param) {
        ClientResultDto result = new ClientResultDto();

        int cnt = clientRepository.selectMyConsults(userId).size();

        ClientInquiryEntity entity = new ClientInquiryEntity();

        entity.setSeq(cnt+1);
        entity.setTitle(param.getTitle());
        entity.setContent(param.getContent());
        entity.setCustomer_id(userId);
        entity.setRegister_date(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA).format(Calendar.getInstance().getTime()));
        entity.setAnswer_status("R");
        entity.setManager_id("");

        clientRepository.save(entity);

        return ResponseEntity.ok(result);
    }
}
