package br.com.codenation.ciandt.errorcenter.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    @Email
    @NotNull
    @Size(min = 3, max = 150)
    private String email;

    @NotNull
    @Size(min = 3, max = 100)
    private String password;
}
