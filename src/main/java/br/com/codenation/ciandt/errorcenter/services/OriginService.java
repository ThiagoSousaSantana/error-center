package br.com.codenation.ciandt.errorcenter.services;

import br.com.codenation.ciandt.errorcenter.models.Origin;
import br.com.codenation.ciandt.errorcenter.repositories.OriginRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@AllArgsConstructor
@Service
public class OriginService {

    private final OriginRepository repository;
    private final UserService userService;

    public Origin insert(Origin origin, UUID userId) {
        var user = userService.getById(userId);
        origin.setUser(user);
        return repository.save(origin);
    }
}
