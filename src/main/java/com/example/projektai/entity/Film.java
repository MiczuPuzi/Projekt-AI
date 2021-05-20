package com.example.projektai.entity;




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
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty
    private String title;

    @NotNull
    @NotEmpty
    private String genre;

    @ManyToOne(fetch = FetchType.EAGER)
    private Director director;

    @NotNull
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "film")
    private Set<FilmScreening> filmScreenings;

    @NotNull
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "film")
    private Set<Opinion> opinions;

    public Film(){
        this.filmScreenings = new HashSet<>();
        this.opinions = new HashSet<>();
    }
}
