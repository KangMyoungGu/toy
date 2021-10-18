package com.example.toy.api.admin.enums;

public enum AnswerRtCode {
    SUCCESS("0","정상적으로 처리되었습니다."),
    PARAMETER_ERROR("1","파라미터가 잘못되었습니다."),
    ALREADY_ASSIGN("2" , "이미 답변자가 지정된 문의이거나, 답변이 완료된 문의입니다."),
    WRONG_TOKEN("3", "사용자 정보를 가져오지 못했습니다.\n관리자에게 문의하여 주십시오."),
    USER_NOT_MATCHED("4", "로그인한 사용자에게 할당된 문의건이 아닙니다.");

    private final String retCode;
    private final String retMsg;

    private AnswerRtCode(String retCode, String retMsg) {
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
