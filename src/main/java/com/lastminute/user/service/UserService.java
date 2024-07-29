package com.lastminute.user.service;

import com.lastminute.user.entity.UserEntity;

import java.util.List;

public interface UserService {

    public boolean saveUserDetails(UserEntity user);

    public boolean updateUserDetails(UserEntity user);

    public List<UserEntity> getAllUsers();

    public UserEntity findById(Long id);

    public UserEntity findByPhone(Long phone);

    public UserEntity findByEmail(String email);

    public boolean inActiveUser(UserEntity user);

    public List<UserEntity> findActiveUsers(String status);

}
