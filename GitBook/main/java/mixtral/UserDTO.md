package org.acme.reactive.crud.service.dto;

import java.time.Instant;
import java.util.Set;
import java.util.stream.Collectors;

import io.quarkus.runtime.annotations.RegisterForReflection;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import org.acme.reactive.crud.config.Constants;

import org.acme.reactive.crud.domain.User;

@RegisterForReflection
public class UserDTO {


    public Long id;
    @Email
    public String email;

    public Instant createdDate;

    @Pattern(regexp = Constants.LOGIN_REGEX)
    public String login;


    public Set<String> authorities;

    public UserDTO() {
        // Empty constructor needed for Jackson.
    }


    public UserDTO(User user) {

        this.id = user.id;
        this.login = user.login;
        this.email = user.email;
        this.createdDate = user.createdDate;
        this.email = user.email;
        this.authorities = user.authorities.stream().map(authority -> authority.name).collect(Collectors.toSet());


    }

}
