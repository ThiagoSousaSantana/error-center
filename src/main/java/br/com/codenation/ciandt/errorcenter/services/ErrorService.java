package br.com.codenation.ciandt.errorcenter.services;

import br.com.codenation.ciandt.errorcenter.models.Error;
import br.com.codenation.ciandt.errorcenter.repositories.ErrorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.UUID;

@AllArgsConstructor
@Service
public class ErrorService {

    private final ErrorRepository repository;
    private final OriginService originService;

    public Error insert(@Valid Error error, UUID originId) {
        var origin = originService.findById(originId);
        error.setOrigin(origin);
        return repository.save(error);
    }
}
