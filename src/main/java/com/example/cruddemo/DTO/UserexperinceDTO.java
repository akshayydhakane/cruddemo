package com.example.cruddemo.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserexperinceDTO {
    private Long usrexperinceId;
    @NotBlank(message = "Experience name is required")
    private String experincename;
}
