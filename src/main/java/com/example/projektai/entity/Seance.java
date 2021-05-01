package com.example.projektai.entity;

import com.sun.istack.NotNull;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
public class Seance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seance_id")
    private Long seanceId;

    @NotNull
    private LocalDateTime date;

    @NotNull
    private int roomNumber;

    @ManyToMany
    @JoinColumn(name = "client_id")
    private List<Client> clients;

    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;
}
