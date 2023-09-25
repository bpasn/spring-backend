package com.firstApp.firstApp.mapper;

import org.mapstruct.Mapper;

import com.firstApp.firstApp.entity.UserEntity;
import com.firstApp.firstApp.models.UserModel;

import java.util.List;

 @Mapper(componentModel = "spring")
public interface UserMapper {
    UserModel userEntityToModel(UserEntity entity);
    List<UserModel> userEntityToModel(List<UserEntity> entity);
}
