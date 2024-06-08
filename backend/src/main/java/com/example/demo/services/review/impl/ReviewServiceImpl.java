package com.example.demo.services.review.impl;

import com.example.demo.persistence.entities.Review;
import com.example.demo.persistence.repository.ReviewRepository;
import com.example.demo.services.review.ReviewService;
import com.example.demo.services.review.dto.ReviewInfoDTO;
import com.example.demo.services.review.dto.ReviewInfoQueryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Page<ReviewInfoQueryDTO> getReviews(Long id, Pageable pageable) {
        return this.reviewRepository.findByEvent_Id(id, pageable);
    }
}
