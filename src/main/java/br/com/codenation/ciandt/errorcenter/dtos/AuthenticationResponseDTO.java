package br.com.codenation.ciandt.errorcenter.dtos;

import br.com.codenation.ciandt.errorcenter.models.Users;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AuthenticationResponseDTO {
    private String token;
    private Users user;
}
