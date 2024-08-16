package com.project.shopapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class ProductDTO {
    @NotBlank(message = "cant null")
    @Size(min = 3, max = 200, message = "min of 3 and max of 200")
    private String name;

    @Min(value = 0, message = "cant below 0")
    @Max(value = 50000000,message = "cant higher 50 millions VND")
    private float price;

    private String thumbnail;

    private String description;

    @JsonProperty("category_id") // tên thuộc tính trong json - lúc test
    private String categoryId ;  // tên thuộc tính trong java

    private List<MultipartFile> file;
}
