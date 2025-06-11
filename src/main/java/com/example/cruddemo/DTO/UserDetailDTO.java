package com.example.cruddemo.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserDetailDTO {
    @NotBlank(message = "First name is required")
    private String firstname;

    @NotBlank(message = "Last name is required")
    private String lastname;

    private String designation;
    private boolean isActive = true;
}
