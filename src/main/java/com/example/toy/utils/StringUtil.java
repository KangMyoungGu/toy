package com.example.toy.utils;

import org.springframework.stereotype.Component;

@Component
public class StringUtil {
    private final int koreanBytes = 2;

    public boolean getStringBytes(String inputString, int maxSize) {
        int bytes = 0;
        for(int i = 0; i < inputString.length() - 1; i++) {
            if(isKorean(inputString.substring(i, i+1))) {
                bytes += koreanBytes;
            } else {
                bytes +=1;
            }
        }

        if(maxSize < bytes) {
            return false;
        } else {
            return true;
        }
    }

    private boolean isKorean(String s) {
        if(Character.getType(s.charAt(0)) == Character.OTHER_LETTER){
            return true;
        } else {
            return false;
        }
    }
}
