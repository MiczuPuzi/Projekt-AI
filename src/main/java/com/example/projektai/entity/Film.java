package com.example.projektai.entity;



import com.sun.istack.NotNull;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    private Long filmId;

    @NotNull
    private String name;

    @NotNull
    private String type;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "director_id")
    private Director director;

    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "seance_id")
    private Set<Seance> seances;

    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "opinion_id")
    private Set<Opinion> opinions;
}
