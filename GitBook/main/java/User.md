/*
 * Copyright 2019 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package org.acme.reactive.crud.domain;

import io.quarkus.cache.CacheResult;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.panache.common.Page;
import io.smallrye.mutiny.Uni;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.acme.reactive.crud.config.Constants;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.time.Instant;

//Panache 사용으로 GETTER,SETTER,DAO,REPOSITORY 생략
//활성레코드 패턴사용 엔터티 클래스에 로직을 STATIC 메소드로 추가 <-DAO 생략
//테이블,뷰 래핑; 데이퍼베이스엑세스 캡슐화; 데이터에 도메인로직 추가

@Entity
@Table(name = "user_table")
public class User extends PanacheEntityBase {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //값의 위치를 가르키는 Long타입
    public Long id;

    @NotNull
    @Pattern(regexp = Constants.LOGIN_REGEX)
    @Size(min = 1, max = 50)
    @Column(length = 50, unique = true, nullable = false)
    public String login;

    @Email
    @Column(name = "email", length = 60, nullable = false)
    public String email;


    @Column(name = "password", length = 60, nullable = false)
    @JsonbTransient
    public String password;

    @Column(name = "created_date", updatable = false)
    @Pattern(regexp = Constants.DATE_TIME_FORMAT)
    @JsonbTransient
    public Instant createdDate = Instant.now();

    @ManyToMany
    @JoinTable(name = "user_authority", joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")}, inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "name")})
    @Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
    @BatchSize(size = 20)
    @JsonbTransient
    public Set<Authority> authorities = new HashSet<>();


    public Uni<User> findByEmail(String email) {
        return find("email", email).firstResult();
    }

}
