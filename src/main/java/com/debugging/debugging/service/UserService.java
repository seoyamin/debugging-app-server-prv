package com.debugging.debugging.service;

import com.debugging.debugging.domain.user.User;
import com.debugging.debugging.domain.user.UserRepository;
import com.debugging.debugging.dto.UserDto;
import com.debugging.debugging.util.SecurityUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public User signup(UserDto userDto) {
        if(userRepository.findByEmail(userDto.getEmail()).orElse(null) != null) {
            throw new RuntimeException("이미 가입된 이메일입니다.");
        }

        User user = User.builder()
                .email(userDto.getEmail())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .nickname(userDto.getNickname())
                .period(userDto.getPeriod())
                .build();

        return userRepository.save(user);
    }


    @Transactional(readOnly = true)
    public Optional<User> getUserWithEmail(String email) {
        return SecurityUtil.getCurrentUsername().flatMap(userRepository::findByEmail);
    }

    @Transactional(readOnly = true)
    public Optional<User> getMyUser() {
        return SecurityUtil.getCurrentUsername().flatMap(userRepository::findByEmail);
    }


}
