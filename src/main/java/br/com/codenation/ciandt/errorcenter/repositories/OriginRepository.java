package br.com.codenation.ciandt.errorcenter.repositories;

import br.com.codenation.ciandt.errorcenter.models.Origin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OriginRepository extends JpaRepository<Origin, UUID> {
}
