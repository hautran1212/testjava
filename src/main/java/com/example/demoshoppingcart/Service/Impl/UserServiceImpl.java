package com.example.demoshoppingcart.Service.Impl;

import com.example.demoshoppingcart.Converter.UserConverter;
import com.example.demoshoppingcart.Domain.UserModel;
import com.example.demoshoppingcart.Entity.UserEntity;
import com.example.demoshoppingcart.Exception.FieldMissMatchException;
import com.example.demoshoppingcart.Responsitory.UserResponsitory;
import com.example.demoshoppingcart.Service.UserService;
import com.example.demoshoppingcart.Validatetor.ValidateRegisterUser;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserResponsitory userResponsitory;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ValidateRegisterUser validateRegisterUser;

    @Transactional
    @Override
    public void register(UserModel userModel) throws FieldMissMatchException {
        validateRegisterUser.validateRegister(userModel);
        UserEntity userEntity = UserConverter.toEntity(userModel);
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        userResponsitory.save(userEntity);
    }
}
