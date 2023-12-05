package com.example.demoshoppingcart.Converter;

import com.example.demoshoppingcart.Domain.UserModel;
import com.example.demoshoppingcart.Entity.UserEntity;

public class UserConverter {
    public static UserEntity toEntity(UserModel userModel){
        UserEntity entity = new UserEntity();
        entity.setUsername(userModel.getUsername());
        entity.setPassword(userModel.getPassword());
        entity.setRole("ROLE_USER");
        return entity;
    }
}
