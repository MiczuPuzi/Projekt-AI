package com.example.projektai.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity

@Getter
@Setter
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private String lastName;

    private int phoneNumber;

    private int age;

    @NotNull
    @NotEmpty
    private String email;

    @NotNull
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.EAGER, mappedBy = "clients")
    private List<FilmScreening> filmScreenings;

    @NotNull
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "client")
    private Set<Opinion> opinions;

    public Client() {
        this.filmScreenings = new ArrayList<>();
        this.opinions = new HashSet<>();
    }
}
