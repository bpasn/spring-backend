package com.firstApp.firstApp.mapper;

import com.firstApp.firstApp.entity.ProductEntity;
import com.firstApp.firstApp.entity.UserEntity;
import com.firstApp.firstApp.models.UserModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserModel userEntityToModel(UserEntity entity);
}
