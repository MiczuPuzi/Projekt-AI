package com.example.projektai.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class FilmScreening {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDateTime date;

    private int roomNumber;

    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "film_screenings_clients",joinColumns = @JoinColumn(name = "film_screening_id"),inverseJoinColumns = @JoinColumn(name = "client_id"))
    private List<Client> clients;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    private Film film;

    public FilmScreening(){
        this.clients = new ArrayList<>();
    }
}
