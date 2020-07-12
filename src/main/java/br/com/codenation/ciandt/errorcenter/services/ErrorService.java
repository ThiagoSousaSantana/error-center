package br.com.codenation.ciandt.errorcenter.services;

import br.com.codenation.ciandt.errorcenter.dtos.FindErrorBy;
import br.com.codenation.ciandt.errorcenter.models.Environment;
import br.com.codenation.ciandt.errorcenter.models.Error;
import br.com.codenation.ciandt.errorcenter.models.Level;
import br.com.codenation.ciandt.errorcenter.repositories.ErrorRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    public Page<Error> listAll(Environment environment,
                               FindErrorBy findErrorBy,
                               String searchTerm,
                               int page,
                               int size,
                               String sortBy,
                               String sortDirection) {
        var pageRequest = PageRequest.of(
                page,
                size,
                Sort.Direction.fromString(sortDirection),
                sortBy);

        if (findErrorBy != null) {
            switch (findErrorBy) {
                case LEVEL:
                    return repository.findAllByLevel(Level.valueOf(searchTerm), pageRequest);
                case ORIGIN:
                    return repository.findAllByOriginId(UUID.fromString(searchTerm), pageRequest);
                case DESCRIPTION:
                    return repository.findAllByDetailsLike(searchTerm, pageRequest);
            }
        }

        return repository.findAllByEnvironment(environment, pageRequest);
    }

    public void delete(UUID errorId) {
        repository.deleteById(errorId);
    }
}
