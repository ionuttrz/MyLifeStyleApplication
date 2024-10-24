package com.ProiectareSoftware.myLifeStyle.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data     //no need for constructor, getters and setters
@Entity
@Table(name = "user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    private String gender;

    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @ManyToMany
    private Set<Role> roles;

}
