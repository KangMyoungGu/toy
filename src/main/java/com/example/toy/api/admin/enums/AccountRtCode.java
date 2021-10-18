package com.example.toy.api.admin.enums;

public enum AccountRtCode {
    SUCCESS("0","정상적으로 처리되었습니다."),
    MISMATCH("1","로그인 정보가 일치하지 않습니다."),
    PARAMETER_ERROR("2","요청된 값이 잘못되었습니다.\n 다시 확인해주세요."),
    NONUSER("3", "등록된 사용자가 존재하지 않습니다."),
    EXISTSUSER("4","이미 등록된 계정입니다.");

    private final String retCode;
    private final String retMsg;

    private AccountRtCode(String retCode, String retMsg) {
        this.retCode = retCode;
        this.retMsg = retMsg;
    }
    public String getCode() {
        return retCode;
    }
    
    public String getMsg() {
        return retMsg;
    }
}
