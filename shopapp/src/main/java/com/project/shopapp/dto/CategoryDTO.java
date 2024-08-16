package com.project.shopapp.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data // to String
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
    @NotEmpty (message = "cant empty")
    private String name;
}
