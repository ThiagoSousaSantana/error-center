package br.com.codenation.ciandt.errorcenter.controllers;

import br.com.codenation.ciandt.errorcenter.dtos.AuthenticationResponseDTO;
import br.com.codenation.ciandt.errorcenter.dtos.LoginRequestDTO;
import br.com.codenation.ciandt.errorcenter.security.JwtTokenProvider;
import br.com.codenation.ciandt.errorcenter.services.AuthenticationService;
import br.com.codenation.ciandt.errorcenter.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@AllArgsConstructor
@Tag(name = "Authentication")
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationService service;
    private final JwtTokenProvider tokenProvider;
    private final UserService userService;

    @Operation(summary = "Authenticate an user")
    @PostMapping
    public AuthenticationResponseDTO authenticateUser(@Valid @RequestBody LoginRequestDTO loginRequest){
        var jwt = service.authenticate(loginRequest);
        var userId = tokenProvider.getUserId(jwt);
        var user = userService.getById(userId);
        return new AuthenticationResponseDTO(jwt, user);
    }

}
