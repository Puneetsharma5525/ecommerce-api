package com.ecommerce.shopping.ecommerceuserpannelapi.services;

import com.ecommerce.shopping.ecommerceuserpannelapi.entities.UserEntities;
import com.ecommerce.shopping.ecommerceuserpannelapi.payloads.ApiResponseObject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserServices {
    ApiResponseObject<UserEntities> getUser(Long id);
    ApiResponseObject<List<UserEntities>> getAllUser();
    ApiResponseObject<UserEntities> addUser(UserEntities profile);
    ApiResponseObject<UserEntities> deleteUser(Long id);

}
