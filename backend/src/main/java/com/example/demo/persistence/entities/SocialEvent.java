package com.example.demo.persistence.entities;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Entity
public class SocialEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long invitedGuest;
    //TODO CHECK HOW TO SAVE ADDRESS
    private String address;
    private Date programatedDate;
    private String contactInfo;

    @Column(length = 2500)
    private String details;
    private BigInteger price;
    private String tags; //TODO HABIA QUE AGREGARLO???
    private boolean published;
    private Long maxGuests;


    @ManyToMany
    @JoinTable(
            name = "event_category_relation",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories;

    @OneToMany(mappedBy = "event", fetch = FetchType.LAZY)
    private List<Qualification> qualifications;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "organizer_id")
    private Person organizer;

    @ManyToMany(mappedBy = "attendedEvents")
    private List<Person> guests;
}
