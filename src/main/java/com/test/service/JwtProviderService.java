package com.test.service;

import com.test.dto.token.TokenHolder;
import com.test.utils.JwtParser;
import com.test.utils.DateUtils;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

@Service
public class JwtProviderService {

    @Value("${token.access-expiration-days}")
    private int accessExpirationDays;

    @Value("${token.key}")
    private String secretKey;

    public TokenHolder generateAccess(Object payload) {
        return generate(payload, accessExpirationDays);
    }

    @SneakyThrows
    private TokenHolder generate(Object payload, int expirationDays) {
        Date expired = DateUtils.addDays(new Date(), expirationDays);
        String jwt = Jwts.builder()
                .setExpiration(saltDate(expired))
                .claim(JwtParser.PAYLOAD_HEADER, payload)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
        return new TokenHolder(jwt, DateUtils.toReadableDate(expired));
    }

    private Date saltDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.SECOND, 1 + new Random().nextInt(120));
        return calendar.getTime();
    }

}
