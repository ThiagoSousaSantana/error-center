package br.com.codenation.ciandt.errorcenter.dtos;

import br.com.codenation.ciandt.errorcenter.models.Environment;
import br.com.codenation.ciandt.errorcenter.models.Level;
import lombok.Data;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class ErrorInsertDTO {
    @NotNull
    private Environment environment;

    @NotNull
    private Level level;

    @NotNull
    private LocalDateTime timestamp;

    @NotNull
    private String title;

    @NotNull
    private String details;

    @ManyToOne
    private UUID originId;
}
