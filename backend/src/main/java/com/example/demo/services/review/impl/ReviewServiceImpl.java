package com.example.demo.services.review.impl;

import com.example.demo.persistence.entities.Review;
import com.example.demo.persistence.entities.SocialEvent;
import com.example.demo.persistence.entities.User;
import com.example.demo.persistence.repository.ReviewRepository;
import com.example.demo.services.review.ReviewService;
import com.example.demo.services.review.dto.AddReviewRequest;
import com.example.demo.services.review.dto.ReviewInfoDTO;
import com.example.demo.services.review.dto.ReviewInfoQueryDTO;
import com.example.demo.services.socialevent.SocialEventCRUDService;
import com.example.demo.services.user.UserCRUDService;
import com.example.demo.services.user.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final SocialEventCRUDService socialEventService;
    private final UserCRUDService userService;
    private final UserUtils userUtils;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository, SocialEventCRUDService socialEventService, UserCRUDService userService, UserUtils userUtils) {
        this.reviewRepository = reviewRepository;
        this.socialEventService = socialEventService;
        this.userService = userService;
        this.userUtils = userUtils;
    }

    @Override
    public Page<ReviewInfoQueryDTO> getReviews(Long id, Pageable pageable) {
        return this.reviewRepository.findByEvent_Id(id, pageable);
    }

    @Override
    public ReviewInfoQueryDTO addReview(Long eventId, AddReviewRequest body) {
        //todo chekcear que el usario asistio a ese evento
        SocialEvent socialEvent = this.socialEventService.getById(eventId);
        User user = this.userService.getUserByEmail(body.getUserEmail());
        Review r = Review.builder()
                .qualification(body.getQualification())
                .comment(body.getComment())
                .event(socialEvent)
                .user(user)
                .build();
        r = this.reviewRepository.save(r);
        
        return ReviewInfoDTO.builder()
                .id(r.getId())
                .comment(r.getComment())
                .qualification(r.getQualification())
                .username(
                    this.userUtils.getUsername(user)
                )
                .build();
    }
}
