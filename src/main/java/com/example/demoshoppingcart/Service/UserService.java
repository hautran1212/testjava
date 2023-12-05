package com.example.demoshoppingcart.Service;

import com.example.demoshoppingcart.Domain.UserModel;
import com.example.demoshoppingcart.Exception.FieldMissMatchException;

public interface UserService {
    void register(UserModel userModel) throws Exception, FieldMissMatchException;

}
