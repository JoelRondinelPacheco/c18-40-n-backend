package com.example.demo.services.review;

import com.example.demo.services.review.dto.ReviewInfoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReviewService {
    Page<ReviewInfoDTO> getReviews(Long id, Pageable pageable);
}
