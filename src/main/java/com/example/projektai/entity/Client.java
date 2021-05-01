package com.example.projektai.entity;

import com.sun.istack.NotNull;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Long clientId;

    @NotNull
    private String name;

    @NotNull
    private String lastName;

    @NotNull
    private int phoneNumber;

    @NotNull
    private int age;

    @NotNull
    private String email;

    @ManyToMany
    @JoinColumn(name = "seance_id")
    private List<Seance> seances;

    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "opinion_id")
    private Set<Opinion> opinions;
}
