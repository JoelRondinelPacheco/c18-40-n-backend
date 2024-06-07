package com.example.demo.persistence.entities;

import com.example.demo.persistence.utils.RoleEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;


@Entity(name = "person")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
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
            name = "person_event_relation",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id")
    )
    private List<SocialEvent> attendedEvents;
62
}