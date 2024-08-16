package com.project.shopapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class UserDTO {
    @JsonProperty("full_name")
    private String fullName;

    @JsonProperty("phone_number")
    @NotBlank(message = "cant be null")
    private String phoneNumber;

    private String address;

    @NotBlank(message = "cant be null")
    private String password;

    private String repeatPassword;

    @JsonProperty("date_birth")
    private Date dateBirth;
    @JsonProperty("facebook_account_id")
    private int facebookAccountId;
    @JsonProperty("google_account_id")
    private int googleAccountId;

    private long id;

}
