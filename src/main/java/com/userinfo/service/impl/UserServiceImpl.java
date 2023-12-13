package com.userinfo.service.impl;

import com.userinfo.dto.request.UserRequest;
import com.userinfo.dto.response.ApiResponse;
import com.userinfo.exception.ResourceNotFoundException;
import com.userinfo.model.Sector;
import com.userinfo.model.User;
import com.userinfo.repository.SectorRepository;
import com.userinfo.repository.UserRepository;
import com.userinfo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final SectorRepository sectorRepository;
    private final UserRepository userRepository;

    @Override
    public ApiResponse<User> create(UserRequest userRequest) {
        Set<Sector> sectors = userRequest.getSectors()
                .stream()
                .map(sectorRequest -> sectorRepository.findById(sectorRequest.getId())
                        .orElseThrow(() -> new ResourceNotFoundException("Sector not found"))).collect(Collectors.toSet());

        User user = new User();
        user.setName(userRequest.getName());
        user.setAgreedToTerms(userRequest.isAgreedToTerms());
        user.setSectors(sectors);

        return ApiResponse.success(userRepository.save(user));
    }

    @Override
    public ApiResponse<User> getById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        return ApiResponse.success(user);
    }

    @Override
    public ApiResponse<User> update(Long userId, UserRequest userRequest) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Set<Sector> sectors = userRequest.getSectors()
                .stream()
                .map(sectorRequest -> sectorRepository.findById(sectorRequest.getId())
                        .orElseThrow(() -> new ResourceNotFoundException("Sector with name "+ sectorRequest.getName()+ " not found"))).collect(Collectors.toSet());

        user.setName(userRequest.getName());
        user.setAgreedToTerms(userRequest.isAgreedToTerms());
        user.setSectors(sectors);

        return ApiResponse.success(userRepository.save(user));
    }

    @Override
    public ApiResponse<List<User>> getAllUsers() {
        List<User> users = userRepository.findAll();
        return ApiResponse.success(users);
    }
}
