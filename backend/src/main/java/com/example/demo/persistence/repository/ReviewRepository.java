package com.example.demo.persistence.repository;

import com.example.demo.persistence.entities.Review;
import com.example.demo.services.review.dto.ReviewInfoQueryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    Page<ReviewInfoQueryDTO> findByEvent_Id(Long id, Pageable pageable);
}
