package br.com.codenation.ciandt.errorcenter.models;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@EqualsAndHashCode(of = "id")
public class Users {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;

    @Email
    @NotNull
    @Size(min = 3, max = 150)
    private String email;

    @NotNull
    @Size(min = 3, max = 100)
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Origin> origins;

}
