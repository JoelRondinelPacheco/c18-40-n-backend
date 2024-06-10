package com.example.demo.persistence.repository;

import com.example.demo.persistence.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findById(Long id);

    /*@Query("SELECT e.* FROM SocialEvent e "
            + "JOIN e.guests a "
            + "WHERE a.email = :userEmail AND e.id = :eventId")*/
    @Query(value = "SELECT COUNT(*) FROM user_data_event_relation WHERE user_data_id = :userId AND event_id = :eventId", nativeQuery = true)
    public Long isUserAttendingEvent(Long userId, Long eventId);

}
