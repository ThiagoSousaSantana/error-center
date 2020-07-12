package br.com.codenation.ciandt.errorcenter.controllers;

import br.com.codenation.ciandt.errorcenter.dtos.ErrorInsertDTO;
import br.com.codenation.ciandt.errorcenter.models.Error;
import br.com.codenation.ciandt.errorcenter.services.ErrorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Errors")
@AllArgsConstructor
@RestController
@RequestMapping("/errors")
public class ErrorController {

    private final ErrorService service;
    private final ModelMapper mapper;

    @Operation(summary = "Register a new error")
    @PostMapping
    public Error insert(@RequestBody ErrorInsertDTO errorDTO) {
        return service.insert(
                mapper.map(errorDTO, Error.class),
                errorDTO.getOriginId()
        );
    }
}
