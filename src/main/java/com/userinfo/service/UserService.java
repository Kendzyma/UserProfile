package com.userinfo.service;

import com.userinfo.dto.request.UserRequest;
import com.userinfo.dto.response.ApiResponse;
import com.userinfo.model.User;

import java.util.List;

public interface UserService {
    ApiResponse<User> create(UserRequest userRequest);

    ApiResponse<User> getById(Long userId);

    ApiResponse<User> update(Long userId, UserRequest userRequest);

    ApiResponse<List<User>> getAllUsers();
}
