package com.example.projektai.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

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
    @ManyToOne(fetch = FetchType.EAGER)
    private Film film;

}
