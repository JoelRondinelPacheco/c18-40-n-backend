package com.example.demo.persistence.repository;

import com.example.demo.persistence.entities.SocialEvent;
import com.example.demo.services.socialevent.dto.EventQualificationQueryDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialEventRepository extends JpaRepository<SocialEvent, Long> {

    @Query(value = "SELECT SUM(r.qualification) as sum, COUNT(*) AS totalComments FROM review r WHERE r.event_id = :eventId", nativeQuery = true)
    EventQualificationQueryDTO getEventQualification(Long eventId);
}
