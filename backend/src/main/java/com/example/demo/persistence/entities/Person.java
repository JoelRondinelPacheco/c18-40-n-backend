package com.example.demo.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "person")
@Getter
@Setter
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastname;
    private String username;
    private String address;
    private Long phoneNumber;
    @Column(unique = true)
    private String email;
    private String password;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(mappedBy = "organizer", fetch = FetchType.LAZY)
    private List<SocialEvent> events;

    @ManyToMany
    @JoinTable(
            name = "person_event_relation",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id")
    )
    private List<SocialEvent> attendedEvents;
}