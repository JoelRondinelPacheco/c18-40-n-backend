package com.example.demo.controller;

import com.example.demo.services.review.ReviewService;
import com.example.demo.services.review.dto.AddReviewRequest;
import com.example.demo.services.review.dto.ReviewInfoQueryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Page<ReviewInfoQueryDTO>> getEventReviews(@PathVariable Long eventId, Pageable pageable) {
        return ResponseEntity.ok(this.reviewService.getReviews(eventId, pageable));
    }

    @PostMapping("/{eventId}")
    public ResponseEntity<ReviewInfoQueryDTO> addReview(@PathVariable Long eventId, @RequestBody AddReviewRequest body) {
        /*
            TODO
                QUE EL USUARIO SOLO PUEDA COMENTAR A EVENTOS QUE ASISTIO (QUE SE HABILITEN COMENTARIOS CUANDO TERMINO EL EVENTO??)
                QUE EL USUARIO SOLO PUEDA HACER UN COMENTARIO
         */
        return ResponseEntity.ok(this.reviewService.addReview(eventId, body));
    }
}
