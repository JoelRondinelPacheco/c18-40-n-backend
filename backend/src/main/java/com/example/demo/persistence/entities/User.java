package com.example.demo.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity(name = "user_data")
@Data
@NoArgsConstructor
@AllArgsConstructor
//todo cambiar a user
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastname;
    private String username;
    private String address;
    private Long phoneNumber;

    @Column(unique = true, nullable = false)
    private String email;

    @OneToMany(mappedBy = "organizer", fetch = FetchType.LAZY)
    private List<SocialEvent> events;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_data_event_relation",
            joinColumns = @JoinColumn(name = "user_data_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id")
    )
    private List<SocialEvent> attendedEvents;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Review> reviews;

}