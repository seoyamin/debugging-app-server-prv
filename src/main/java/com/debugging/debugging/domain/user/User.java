package com.debugging.debugging.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @JsonIgnore
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "email", length = 45, unique = true)
    private String email;

    @JsonIgnore
    @Column(name = "password", length = 150)
    private String password;

    @Column(name = "nickname", length = 45, unique = true)
    private String nickname;

    @Column(name = "period")
    private Integer period;

}
