package com.example.demo.controller;

import com.example.demo.services.socialevent.SocialEventCRUDService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/event")
public class EventsController {

    private final SocialEventCRUDService service;

    public EventsController(SocialEventCRUDService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> getAll(Pageable pageable) {
        return null;
    }
    /*


    ENDPOINTS
     */
}
