package com.example.demo.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //TODO DEFINIR SI ES DE 1 A 5 O OTRO RANGO
    @Column(precision = 2, scale = 1)
    private BigDecimal qualification;
    @Column(length = 500)
    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private SocialEvent event;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_data_email", referencedColumnName = "email")
    private User user;
}