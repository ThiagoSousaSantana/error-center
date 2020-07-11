package br.com.codenation.ciandt.errorcenter.controllers;

import br.com.codenation.ciandt.errorcenter.dtos.UserDTO;
import br.com.codenation.ciandt.errorcenter.models.Users;
import br.com.codenation.ciandt.errorcenter.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "Users")
@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper mapper;

    @PostMapping
    @Operation(summary = "Register a new user")
    @ResponseStatus(HttpStatus.CREATED)
    public Users post(@RequestBody @Valid UserDTO userDTO) {
        return userService.save(mapper.map(userDTO, Users.class));
    }

}
