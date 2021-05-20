package com.example.projektai.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@NoArgsConstructor
@Getter
@Setter
public class Opinion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int rate;

    @NotNull
    @NotEmpty
    private String content;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    private Client client;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    private Film film;
}
