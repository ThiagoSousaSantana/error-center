package br.com.codenation.ciandt.errorcenter.controllers;

import br.com.codenation.ciandt.errorcenter.dtos.OriginInsertDTO;
import br.com.codenation.ciandt.errorcenter.models.Origin;
import br.com.codenation.ciandt.errorcenter.services.OriginService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/origins")
public class OriginController {

    private final OriginService service;
    private final ModelMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Origin insert(@RequestBody OriginInsertDTO originDTO, @RequestParam UUID userId) {
        return service.insert(mapper.map(originDTO, Origin.class), userId);
    }
}
