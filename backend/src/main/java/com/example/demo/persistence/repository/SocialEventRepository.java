package com.example.demo.persistence.repository;

import com.example.demo.persistence.entities.SocialEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialEventRepository extends JpaRepository<SocialEvent, Long> {
}