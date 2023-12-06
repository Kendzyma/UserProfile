package com.userinfo.controller;

import com.userinfo.dto.request.UserRequest;
import com.userinfo.dto.response.ApiResponse;
import com.userinfo.model.User;
import com.userinfo.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/user")
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<ApiResponse<User>> create(@Valid @RequestBody UserRequest userRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(userRequest));
    }

    @GetMapping("{userId}")
    public ResponseEntity<ApiResponse<User>> getById(@PathVariable Long userId) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getById(userId));
    }

    @PutMapping("{userId}")
    public ResponseEntity<ApiResponse<User>> update(@PathVariable Long userId, @Valid @RequestBody UserRequest userRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.update(userId, userRequest));
    }
}
