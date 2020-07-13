package br.com.codenation.ciandt.errorcenter.services;

import br.com.codenation.ciandt.errorcenter.exceptions.ObjectNotFoundException;
import br.com.codenation.ciandt.errorcenter.models.Users;
import br.com.codenation.ciandt.errorcenter.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public Users save(@Valid Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }

    public Users getById(UUID id) {
        return repository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("User not found")
        );
    }
}
