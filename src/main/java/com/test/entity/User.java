package com.test.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "`user`")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    public User(String fullname, String login, String password) {
        this.fullname = fullname;
        this.login = login;
        this.password = password;
    }
}
