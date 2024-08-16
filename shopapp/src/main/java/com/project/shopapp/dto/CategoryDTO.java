package com.project.shopapp.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CategoryDTO {
    @NotEmpty (message = "cant empty")
    private String name;
}
