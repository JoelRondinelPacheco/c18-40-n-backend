package com.example.demo.persistence.repository;

import com.example.demo.persistence.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    @Query("SELECT true FROM SocialEvent e "
            + "JOIN e.guests a "
            + "WHERE a.email = :userEmail AND e.id = :eventId")
    public boolean isUserAttendingEvent(String userEmail, Long eventId);

}
