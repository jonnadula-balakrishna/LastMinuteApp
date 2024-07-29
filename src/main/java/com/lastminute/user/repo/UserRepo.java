package com.lastminute.user.repo;

import com.lastminute.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Long> {
    @Override
    Optional<UserEntity> findById(Long id);

    Optional<UserEntity> findByPhone(Long phone);

    Optional<UserEntity> findByEmail(String email);

    List<UserEntity> findByStatus(String status);
}
