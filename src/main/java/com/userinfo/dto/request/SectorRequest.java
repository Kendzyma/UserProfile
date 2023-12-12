package com.userinfo.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SectorRequest {
    private Long id;
    @NotNull(message = "Sector name cannot be null")
    @NotEmpty(message = "Sector name cannot be empty")
    private String name;
}
