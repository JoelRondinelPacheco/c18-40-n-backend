package com.example.demo.services.socialevent.impl;

import com.example.demo.persistence.entities.SocialEvent;
import com.example.demo.persistence.entities.User;
import com.example.demo.persistence.repository.SocialEventRepository;
import com.example.demo.persistence.repository.UserRepository;
import com.example.demo.services.socialevent.SocialEventCRUDService;
import com.example.demo.services.socialevent.ToggleAssistEventUseCase;
import com.example.demo.services.socialevent.dto.UserEventAssistInfo;
import com.example.demo.services.user.UserCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToggleAssistEventUseCaseImpl implements ToggleAssistEventUseCase {

    private final SocialEventRepository socialEventRepository;
    private final UserCRUDService userCRUDService;
    private final SocialEventCRUDService socialEventCRUDService;
    private final UserRepository userRepository;

    @Autowired
    public ToggleAssistEventUseCaseImpl(SocialEventRepository socialEventRepository, UserCRUDService userCRUDService, SocialEventCRUDService socialEventCRUDService, UserRepository userRepository) {
        this.socialEventRepository = socialEventRepository;
        this.userCRUDService = userCRUDService;
        this.socialEventCRUDService = socialEventCRUDService;
        this.userRepository = userRepository;
    }

    @Override
    public UserEventAssistInfo assists(UserEventAssistInfo body) {

        boolean userAssists = this.userRepository.isUserAttendingEvent(body.email(), body.eventId());

        if (userAssists == body.assist()) {
            return body;
        }

        User user = this.userCRUDService.getUserByEmail(body.email());
        SocialEvent event = this.socialEventCRUDService.getById(body.eventId());

        if (body.assist()) {
            event.getGuests().add(user);
        } else {
            event.getGuests().remove(user);
        }

        this.socialEventCRUDService.updateEntity(event);

        return body;
    }
}
