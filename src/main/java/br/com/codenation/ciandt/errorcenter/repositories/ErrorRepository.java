package br.com.codenation.ciandt.errorcenter.repositories;

import br.com.codenation.ciandt.errorcenter.models.Error;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ErrorRepository extends JpaRepository<Error, UUID> {
}
