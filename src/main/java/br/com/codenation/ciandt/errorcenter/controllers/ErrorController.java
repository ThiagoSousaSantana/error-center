package br.com.codenation.ciandt.errorcenter.controllers;

import br.com.codenation.ciandt.errorcenter.dtos.ErrorInsertDTO;
import br.com.codenation.ciandt.errorcenter.dtos.FindErrorBy;
import br.com.codenation.ciandt.errorcenter.models.Environment;
import br.com.codenation.ciandt.errorcenter.models.Error;
import br.com.codenation.ciandt.errorcenter.services.ErrorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Errors")
@AllArgsConstructor
@RestController
@RequestMapping("/errors")
public class ErrorController {

    private final ErrorService service;
    private final ModelMapper mapper;

    @Operation(summary = "Register a new error")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Error insert(@RequestBody ErrorInsertDTO errorDTO) {
        return service.insert(
                mapper.map(errorDTO, Error.class),
                errorDTO.getOriginId()
        );
    }

    @Operation(summary = "List errors")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<Error> list(
            @RequestParam Environment environment,
            @RequestParam(required = false) FindErrorBy findErrorBy,
            @RequestParam(required = false) String searchTerm,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "20") int size,
            @RequestParam(required = false, defaultValue = "timestamp") String sortBy,
            @RequestParam(required = false, defaultValue = "DESC") String sortDirection) {

        return service.listAll(environment, findErrorBy, searchTerm, page, size, sortBy, sortDirection);
    }
}
