package com.userinfo.service.impl;

import com.userinfo.dto.request.SectorRequest;
import com.userinfo.dto.response.ApiResponse;
import com.userinfo.exception.CustomBadRequestException;
import com.userinfo.model.Sector;
import com.userinfo.repository.SectorRepository;
import com.userinfo.service.SectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SectorServiceImpl implements SectorService {
    private final SectorRepository sectorRepository;

    @Override
    public ApiResponse<Sector> create(SectorRequest sectorRequest) {
        sectorRepository.findByName(sectorRequest.getName()).ifPresent(sector -> {
            throw new CustomBadRequestException(sector.getName() + " already exist!");
        });

        Sector sector = new Sector();
        sector.setName(sectorRequest.getName());

        return ApiResponse.success(sectorRepository.save(sector));
    }

    @Override
    public ApiResponse<List<Sector>> getAll() {
        return ApiResponse.success(sectorRepository.findAll());
    }
}
