package br.com.codenation.ciandt.errorcenter.services;

import br.com.codenation.ciandt.errorcenter.models.Users;
import br.com.codenation.ciandt.errorcenter.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository repository;

    public Users save(@Valid Users user) {
        return repository.save(user);
    }

    public Optional<Users> getById(UUID id) {
        return repository.findById(id);
    }
}
