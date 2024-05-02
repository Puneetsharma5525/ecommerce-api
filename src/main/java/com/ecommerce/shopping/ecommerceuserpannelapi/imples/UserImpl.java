package com.ecommerce.shopping.ecommerceuserpannelapi.imples;

import com.ecommerce.shopping.ecommerceuserpannelapi.entities.UserEntities;
import com.ecommerce.shopping.ecommerceuserpannelapi.payloads.ApiResponseObject;
import com.ecommerce.shopping.ecommerceuserpannelapi.repositories.UserDao;
import com.ecommerce.shopping.ecommerceuserpannelapi.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserImpl implements UserServices {
    @Autowired
    UserDao userDao;

    @Override
    public ApiResponseObject<UserEntities> getUser(Long id) {
        try {
            Optional<UserEntities> userOptional = userDao.findById(id);
            if (userOptional.isPresent()) {
                UserEntities user = userOptional.get();
                return new ApiResponseObject<>(HttpStatus.OK, "User retrieved successfully", "valid", user);
            } else {
                return new ApiResponseObject<>(HttpStatus.NOT_FOUND, "User not found", "invalid", null);
            }
        } catch (Exception ex) {
            return new ApiResponseObject<>(HttpStatus.INTERNAL_SERVER_ERROR, "Error", ex.getMessage(), null);
        }
    }


    @Override
    public ApiResponseObject<List<UserEntities>> getAllUser() {
        try {
            List<UserEntities> users = userDao.findAll();
            return new ApiResponseObject<>(HttpStatus.OK, "Users retrieved successfully", "valid", users);
        } catch (Exception ex) {
            return new ApiResponseObject<>(HttpStatus.INTERNAL_SERVER_ERROR,  ex.getMessage(),"Error", null);
        }
    }


    @Override
    public ApiResponseObject<UserEntities> addUser(UserEntities userEntities) {
        try {
            Optional<UserEntities> userOptional = userDao.findById(userEntities.getId());
            if (userOptional.isPresent()) {
                return new ApiResponseObject<>(HttpStatus.CONFLICT, "User is Already Added.", "Invalid", null);
            } else {
                userDao.save(userEntities);
                return new ApiResponseObject<>(HttpStatus.CREATED, "User Added Successfully", "valid", userEntities);
            }
        } catch (Exception ex) {
            return new ApiResponseObject<>(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(),"Error",  null);
        }
    }


    @Override
    public ApiResponseObject<UserEntities> deleteUser(Long id) {
        try {
            Optional<UserEntities> userOptional = userDao.findById(id);
            if (userOptional.isPresent()) {
                UserEntities user = userOptional.get();
                userDao.delete(user);
                return new ApiResponseObject<>(HttpStatus.OK, "User Deleted Successful", "valid", user);
            } else {
                return new ApiResponseObject<>(HttpStatus.NOT_FOUND, "Invalid User Id.", "Invalid", null);
            }
        } catch (Exception ex) {
            return new ApiResponseObject<>(HttpStatus.INTERNAL_SERVER_ERROR,  ex.getMessage(),"Error", null);

        }
    }

}
