package com.example.projektai.entity;

import com.sun.istack.NotNull;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "director_id")
    private Long directorId;

    @NotNull
    private String name;

    @NotNull
    private String lastName;

    @NotNull
    private int age;

    @OneToMany(cascade = {CascadeType.REMOVE},fetch = FetchType.EAGER)
    @JoinColumn(name = "film_id")
    private Set<Film> films;
}
