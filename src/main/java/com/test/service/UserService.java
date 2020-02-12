package com.test.service;

import com.test.dto.Crendentials;
import com.test.dto.RegisterData;
import com.test.dto.converter.UserConverter;
import com.test.dto.token.TokenHolder;
import com.test.entity.User;
import com.test.exception.UserAlreadyExistsException;
import com.test.exception.LoginOrPasswordIncorrectException;
import com.test.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final JwtProviderService jwtProviderService;
    private final BCryptPasswordEncoder bCryptPasswordEncoderl;

    public TokenHolder register(RegisterData rd) {
        var user = userRepository.findByLogin(rd.getLogin());
        if (user != null) {
            throw new UserAlreadyExistsException();
        }
        user = new User(rd.getFullname(), rd.getLogin(), bCryptPasswordEncoderl.encode(rd.getPassword()));
        user = userRepository.save(user);
        return jwtProviderService.generateAccess(UserConverter.toInfo(user));
    }

    public TokenHolder login(Crendentials crendentials) {
        var user = userRepository.findByLogin(crendentials.getLogin());
        if (user == null || !bCryptPasswordEncoderl.matches(crendentials.getPassword(), user.getPassword())) {
            throw new LoginOrPasswordIncorrectException();
        }
        return jwtProviderService.generateAccess(UserConverter.toInfo(user));
    }

}
