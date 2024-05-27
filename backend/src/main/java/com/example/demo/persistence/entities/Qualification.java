package com.example.demo.persistence.entities;

import jakarta.persistence.*;

@Entity
public class Qualification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //TODO DEFINIR SI ES DE 1 A 5 O OTRO RANGO
    private Long quantity;
    @Column(length = 255)
    private String observations;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private SocialEvent event;
}
