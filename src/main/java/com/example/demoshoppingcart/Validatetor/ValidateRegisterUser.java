package com.example.demoshoppingcart.Validatetor;

import com.example.demoshoppingcart.Domain.UserModel;
import com.example.demoshoppingcart.Exception.FieldMissMatchException;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ValidateRegisterUser {
    public void validateRegister(UserModel userModel) throws FieldMissMatchException {
            if (!Objects.equals(userModel.getPassword(), userModel.getRePassword())){
                throw new FieldMissMatchException("Password miss match");
        }
    }
}
