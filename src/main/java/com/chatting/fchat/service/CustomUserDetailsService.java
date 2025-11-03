package com.chatting.fchat.service;

import com.chatting.fchat.domain.UserEntity;
import com.chatting.fchat.dto.CustomUserDetails;
import com.chatting.fchat.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity user = userRepository.findByUserName(username);

        if (user != null) {
            return new CustomUserDetails(user);
        }

        return null;
    }
}
