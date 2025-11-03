package com.chatting.fchat.service;

import com.chatting.fchat.domain.Role;
import com.chatting.fchat.domain.UserEntity;
import com.chatting.fchat.dto.JoinDTO;
import com.chatting.fchat.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void joinProcess(JoinDTO joinDTO) {
        String username = joinDTO.getUsername();
        boolean isExist = userRepository.existsByUserName(username);

        if (isExist) {
            return;
        }

        UserEntity user = UserEntity.builder().userName(username)
                .password(passwordEncoder.encode(joinDTO.getPassword()))
                .role(Role.USER).build();

        userRepository.save(user);
    }
}
