package com.userinfo.service;

import com.userinfo.dto.request.SectorRequest;
import com.userinfo.dto.response.ApiResponse;
import com.userinfo.model.Sector;
import com.userinfo.model.User;

import java.util.List;

public interface SectorService {
    ApiResponse<Sector> create(SectorRequest sectorRequest);

    ApiResponse<List<Sector>> getAll();
}
