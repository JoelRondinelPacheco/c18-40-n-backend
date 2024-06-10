package com.example.demo.services.review;

import com.example.demo.services.review.dto.AddReviewRequest;
import com.example.demo.services.review.dto.ReviewInfoQueryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReviewService {
    Page<ReviewInfoQueryDTO> getReviews(Long id, Pageable pageable);

    ReviewInfoQueryDTO addReview(Long eventId, AddReviewRequest body);
}
