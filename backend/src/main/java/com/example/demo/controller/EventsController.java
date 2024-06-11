package com.example.demo.controller;

import com.example.demo.services.socialevent.SocialEventCRUDService;
import com.example.demo.services.socialevent.SocialEventService;
import com.example.demo.services.socialevent.ToggleAssistEventUseCase;
import com.example.demo.services.socialevent.dto.CreateSocialEventDTO;
import com.example.demo.services.socialevent.dto.EventQualificationDTO;
import com.example.demo.services.socialevent.dto.SocialEventInfoDTO;
import com.example.demo.services.socialevent.dto.UserEventAssistRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


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
    public ResponseEntity<SocialEventInfoDTO> create(
            @RequestParam(name = "eventName") String eventName,
            @RequestParam(name = "startDate") Date startDate,
            @RequestParam(name = "placeName") String placeName,
            @RequestParam(name = "address") String address,
            @RequestParam(name = "city") String city,
            @RequestParam(name = "category") Long categoryId,
            @RequestParam(name = "audienceCapacity") Long audienceCapacity,
            @RequestParam(name = "finishDate") Date finishDate,
            @RequestParam(name = "price") BigDecimal price,
            MultipartFile image,
            @RequestBody(required = false) CreateSocialEventDTO body) {

        List<Long> categoriesId = new ArrayList<>();
        categoriesId.add(categoryId);

        CreateSocialEventDTO dto = CreateSocialEventDTO.builder()
                .eventName(eventName)
                .startDate(startDate)
                .placeName(placeName)
                .address(address)
                .city(city)
                .categoriesId(categoriesId)
                .audienceCapacity(audienceCapacity)
                .finishDate(finishDate)
                .price(price)
                .image(image)
                .build();

        return ResponseEntity.ok(this.service.create(dto));
    }

    @PatchMapping("/assist")
    public ResponseEntity<UserEventAssistRequest> toggleAssist(@RequestBody UserEventAssistRequest body) {
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok(this.toggleAssistEventUseCase.assists(body, email));
    }

    @GetMapping("/qualification/{eventId}")
    public ResponseEntity<EventQualificationDTO> eventQualification(@PathVariable Long eventId) {
        return ResponseEntity.ok(this.socialEventService.getQualification(eventId));
    }
}
