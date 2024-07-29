package com.lastminute.user.service.impl;

import com.lastminute.user.entity.UserEntity;
import com.lastminute.user.repo.UserRepo;
import com.lastminute.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public boolean saveUserDetails(UserEntity user) {
        UserEntity activeUser = UserEntity.builder()
                .createdDate(new Date())
                .updatedDate(new Date())
                .status("ACTIVE")
                .build();
        UserEntity createUser = userRepo.save(activeUser);
        boolean flag = false;
        if (createUser != null) {
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean updateUserDetails(UserEntity user) {
        UserEntity updateUserBuild = UserEntity.builder().updatedDate(new Date()).build();
        UserEntity updateUser = userRepo.save(updateUserBuild);
        boolean flag = false;
        if (updateUser != null) {
            flag = true;
        }
        return flag;
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public UserEntity findById(Long id) {
        return userRepo.findById(id).orElseThrow(() -> new RuntimeException());
    }

    @Override
    public UserEntity findByPhone(Long phone) {
        return userRepo.findByPhone(phone).orElseThrow(() -> new RuntimeException());
    }

    @Override
    public UserEntity findByEmail(String email) {
        return userRepo.findByEmail(email).orElseThrow(() -> new RuntimeException());
    }

    @Override
    public boolean inActiveUser(UserEntity user) {
        user.setStatus("INACTIVE");
        UserEntity inActiveUser = userRepo.save(user);
        if (inActiveUser != null) {
            return true;
        }
        return false;
    }

    @Override
    public List<UserEntity> findActiveUsers(String status) {
        return userRepo.findByStatus(status);
    }

}
