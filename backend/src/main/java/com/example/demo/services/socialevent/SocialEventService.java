package com.example.demo.services.socialevent;

import com.example.demo.services.socialevent.dto.EventQualificationDTO;

public interface SocialEventService {
    EventQualificationDTO getQualification(Long id);
}
