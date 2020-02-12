package com.test.security;

import com.test.exception.AccessDeniedException;
import com.test.utils.JwtParser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;

@Slf4j
@Service
@RequiredArgsConstructor
public class SecurityService {

    private final CurrentUser currentUser;

    @Value("${token.key}")
    public String key;

    public void process(String token) {
        if (StringUtils.isEmpty(token)) {
            return;
        }
        try {
            UserInfo userInfo = JwtParser.parse(token, key, UserInfo.class);
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(userInfo, token, Collections.EMPTY_LIST));
            currentUser.build(userInfo);
        } catch (Exception ex) {
            log.error("Authentication has been failed. Couldn't parse token");
            throw new AccessDeniedException();
        }
    }

}
