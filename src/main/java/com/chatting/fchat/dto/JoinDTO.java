package com.chatting.fchat.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class JoinDTO {
    private String username;
    private String password;
}
