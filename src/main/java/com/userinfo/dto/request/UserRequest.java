package com.userinfo.dto.request;

import com.userinfo.annotation.AgreedToTerms;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Set;
@Data
public class UserRequest {
    @NotNull(message = "Name must not be null")
    @NotEmpty(message = "Name must not be empty")
    private String name;
    @AgreedToTerms(message = "Terms must be agreed to")
    private boolean agreedToTerms;
    @NotEmpty(message = "Sectors must not be empty")
    private Set<SectorRequest> sectors;
}
