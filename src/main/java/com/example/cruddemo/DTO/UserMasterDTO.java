package com.example.cruddemo.DTO;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class UserMasterDTO {
    private Long usermasterid;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

    private boolean isActive = true;
    private LocalDateTime createdAt;

    @NotNull(message = "User details are required")
    private UserDetailDTO userdetail;

    @NotEmpty(message = "At least one experience is required")
    private List<UserexperinceDTO> experiences;
}
