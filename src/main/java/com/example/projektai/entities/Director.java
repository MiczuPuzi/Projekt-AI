package com.example.projektai.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private String lastName;


    private int age;

    @NotNull
    @OneToMany(cascade = {CascadeType.ALL},fetch = FetchType.EAGER,mappedBy = "director")
    private Set<Film> films;

    public Director(){
        this.films = new HashSet<>();
    }
}
