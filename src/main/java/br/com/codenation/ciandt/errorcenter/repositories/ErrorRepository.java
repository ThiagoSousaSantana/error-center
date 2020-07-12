package br.com.codenation.ciandt.errorcenter.repositories;

import br.com.codenation.ciandt.errorcenter.models.Environment;
import br.com.codenation.ciandt.errorcenter.models.Error;
import br.com.codenation.ciandt.errorcenter.models.Level;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ErrorRepository extends JpaRepository<Error, UUID> {
    Page<Error> findAllByEnvironment(Environment environment, Pageable pageable);

    Page<Error> findAllByLevel(Level valueOf, Pageable pageable);

    Page<Error> findAllByOriginId(UUID origin_id, Pageable pageable);

    Page<Error> findAllByDetailsLike(String description, Pageable pageable);
}
