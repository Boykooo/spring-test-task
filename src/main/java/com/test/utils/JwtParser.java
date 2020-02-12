package com.test.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public final class JwtParser {

    private final static ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    public static final String PAYLOAD_HEADER = "PAYLOAD";

    public static <T> T parse(String token, String key, Class<T> requiredType) {
        Claims body = Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(token)
                .getBody();
        return OBJECT_MAPPER.convertValue(body.get(PAYLOAD_HEADER), requiredType);
    }

}
