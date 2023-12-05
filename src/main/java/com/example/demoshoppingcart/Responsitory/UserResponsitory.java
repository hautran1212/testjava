package com.example.demoshoppingcart.Responsitory;

import com.example.demoshoppingcart.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserResponsitory extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);
}
