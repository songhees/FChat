package com.chatting.fchat.controller;

import com.chatting.fchat.dto.JoinDTO;
import com.chatting.fchat.repository.UserRepository;
import com.chatting.fchat.service.JoinService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class JoinController {
    private final JoinService joinService;

    @PostMapping("/join")
    public String joinProcess(@RequestBody JoinDTO joinDTO) {
        log.info("Attempting authentication for {}", joinDTO.getUsername());
        joinService.joinProcess(joinDTO);
        return null;
    }
}
