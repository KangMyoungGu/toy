package com.example.toy.utils;

import com.example.toy.api.admin.data.dto.AccountDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class TokenUtil {
    private static final String key = "toyproject";

    public String create(AccountDto data) throws JsonProcessingException {
        HashMap<String, Object> header = new HashMap<>();
        header.put("type", "JWT");
        header.put("alg", "HS256");

        HashMap<String, Object> payLoad = new HashMap<>();

        payLoad.put("account", new ObjectMapper().writeValueAsString(data).toString());

        return Jwts.builder()
                .setHeader(header)
                .setClaims(payLoad)
                .signWith(SignatureAlgorithm.HS256, key)
                .compact();
    }

    public boolean tokenValition(String token) {
        try {
            Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
            return true;
        } catch (ExpiredJwtException eje) {
            return false;
        } catch(Exception e) {
            return false;
        }
    }

    public JSONObject tokenInfo(String token) throws ParseException {
        return (JSONObject) new JSONParser().parse(Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().get("account").toString());
    }
}
