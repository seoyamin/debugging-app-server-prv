package com.debugging.debugging.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {

    @NotNull
    @Size(min = 10, max = 45)
    private String email;

    @NotNull
    @Size(min = 8, max = 150)
    private String password;

}
