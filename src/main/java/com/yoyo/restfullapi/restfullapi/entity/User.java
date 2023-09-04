package com.yoyo.restfullapi.restfullapi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    private String username;
    private String password;
    private String name;
    private String token;

    //perlu dikasih @Column dikarenakan nama berbeda dg db
    @Column(name = "token_expired_at")
    private Long tokenExpiredAt;

    //referensi one to many dg contacts. set juga dari table contact
    @OneToMany(mappedBy = "user")
    private List<Contact> contacts;
}
