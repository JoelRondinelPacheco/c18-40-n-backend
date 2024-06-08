package com.example.demo.controller;

import com.example.demo.services.review.ReviewService;
import com.example.demo.services.review.dto.ReviewInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/event/{eventId}")
    public ResponseEntity<Page<ReviewInfoDTO>> getEventReviews(@PathVariable Long id, Pageable pageable) {
        return ResponseEntity.ok(this.reviewService.getReviews(id, pageable));
    }
}
