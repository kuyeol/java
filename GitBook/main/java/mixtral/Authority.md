package org.acme.reactive.crud.domain;


import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * An authority (a security role).
 */
@Entity
@Table(name = "authority")
@Cacheable

@RegisterForReflection
public class Authority extends PanacheEntityBase {


    @Id
    @NotNull
    @Size(max = 50)
    @Column(length = 50)
    public String name;

    public Authority() {
        //empty
    }

    public Authority(String name) {
        //for jsonb
        this.name = name;
    }


}
