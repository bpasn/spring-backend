package com.firstApp.firstApp.mapper;

import org.mapstruct.Mapper;

import com.firstApp.firstApp.entity.UserEntity;
import com.firstApp.firstApp.models.UserModel;

// @Mapper(componentModel = "spring")
public interface UserMapper {
    UserModel userEntityToModel(UserEntity entity);
}
