package com.example.demo.services.socialevent.impl;

import com.example.demo.persistence.entities.SocialEvent;
import com.example.demo.persistence.entities.User;
import com.example.demo.persistence.repository.SocialEventRepository;
import com.example.demo.persistence.repository.UserRepository;
import com.example.demo.services.socialevent.SocialEventCRUDService;
import com.example.demo.services.socialevent.ToggleAssistEventUseCase;
import com.example.demo.services.socialevent.dto.UserEventAssistRequest;
import com.example.demo.services.socialevent.dto.UserEventAssistResponse;
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
    public UserEventAssistResponse assists(UserEventAssistRequest body, String email) {

        boolean userAssists = this.userRepository.isUserAttendingEvent(email, body.getEventId());

        UserEventAssistResponse response = UserEventAssistResponse.builder()
                .eventId(body.getEventId())
                .assist(body.isAssist())
                .build();

        if (userAssists == body.isAssist()) {
            response.setInfo(this.equalAssistParameter(body.isAssist()));
            return response;
        }

        User user = this.userCRUDService.getUserByEmail(email);
        SocialEvent event = this.socialEventCRUDService.getById(body.getEventId());

        if (body.isAssist()) {
            event.getGuests().add(user);
        } else {
            event.getGuests().remove(user);
        }

        this.socialEventCRUDService.updateEntity(event);
        response.setInfo(this.getAssistResponse(body.isAssist()));
        return response;
    }

    private String equalAssistParameter(boolean assist) {
        return assist ? "El usuario ya se registro en este evento" : "El usuario no esta registrado en este evento";
    }

    private String getAssistResponse(boolean assist) {
        return assist ? "Confirmacion de asistencia exitosa" : "Cancelacion de asistencia exitosa";
    }
}
