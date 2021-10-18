package com.example.toy.api.client.enums;

public enum ClientRtCode {
    SUCCESS("0","정상적으로 처리되었습니다."),
    NONDATA("1","데이터가 존재하지 않습니다."),
    PARAMETER_ERROR("2","요청된 값이 잘못되었습니다.\n 다시 확인해주세요."),
    CONTENTSIZE_OVERFLOW("3", "입력한 내용이 너무 깁니다.\n 글자수를 확인해주세요.");

    private final String retCode;
    private final String retMsg;

    private ClientRtCode(String retCode, String retMsg) {
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
