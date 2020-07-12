package br.com.codenation.ciandt.errorcenter.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@EqualsAndHashCode(of = "id")
public class Origin {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;

    @NotNull
    @Size(min = 3, max = 150)
    private String name;

    @JsonBackReference
    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @JsonManagedReference
    @OneToMany(mappedBy = "origin")
    private List<Error> errors;
}