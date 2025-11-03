package com.chatting.fchat.repository;

import com.chatting.fchat.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    boolean existsByUserName(String userName);

    UserEntity findByUserName(String userName);
}
