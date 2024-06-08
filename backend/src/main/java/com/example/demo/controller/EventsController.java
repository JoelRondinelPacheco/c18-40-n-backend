package com.example.demo.controller;

import com.example.demo.services.socialevent.SocialEventCRUDService;
import com.example.demo.services.socialevent.SocialEventService;
import com.example.demo.services.socialevent.ToggleAssistEventUseCase;
import com.example.demo.services.socialevent.dto.CreateSocialEventDTO;
import com.example.demo.services.socialevent.dto.EventQualificationDTO;
import com.example.demo.services.socialevent.dto.SocialEventInfoDTO;
import com.example.demo.services.socialevent.dto.ToggleAssistEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/event")
public class EventsController {

    private final SocialEventCRUDService service;
    private final ToggleAssistEventUseCase toggleAssistEventUseCase;
    private final SocialEventService socialEventService;

    @Autowired
    public EventsController(SocialEventCRUDService service, ToggleAssistEventUseCase toggleAssistEventUseCase, SocialEventService socialEventService) {
        this.service = service;
        this.toggleAssistEventUseCase = toggleAssistEventUseCase;
        this.socialEventService = socialEventService;
    }

    @GetMapping
    public ResponseEntity<?> getAll(Pageable pageable) {
        return ResponseEntity.ok(this.service.getPage(pageable));
    }

    @GetMapping("/{eventId}")
    public ResponseEntity<SocialEventInfoDTO> getById(@PathVariable Long eventId) {
        return ResponseEntity.ok(this.service.getDTOById(eventId));
    }

    @PostMapping
    public ResponseEntity<SocialEventInfoDTO> create(@RequestBody CreateSocialEventDTO body) {
        return ResponseEntity.ok(this.service.create(body));
    }

    @PatchMapping("/assist")
    public ResponseEntity<String> toggleAssist(@RequestBody ToggleAssistEvent body) {
        return ResponseEntity.ok(this.toggleAssistEventUseCase.assists(body));
    }

    @GetMapping("/qualification/{eventId}")
    public ResponseEntity<EventQualificationDTO> eventQualification(@PathVariable Long id) {
        return ResponseEntity.ok(this.socialEventService.getQualification(id));
    }
}
