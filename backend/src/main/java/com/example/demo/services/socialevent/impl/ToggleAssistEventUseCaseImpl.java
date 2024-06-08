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

import java.util.Optional;

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

        UserEventAssistResponse response = UserEventAssistResponse.builder()
                .eventId(body.getEventId())
                .assist(body.isAssist())
                .build();

        Optional<User> userOptional = this.userRepository.findByEmail(email);

        if (userOptional.isEmpty()) {
            response.setInfo("Usuario necesita estar logeado");
            return response;
        }

        User user = userOptional.get();
        Long revent = this.userRepository.isUserAttendingEvent(user.getId(), body.getEventId());

        boolean userAssists  = revent > 0 ;

        if (userAssists == body.isAssist()) {
            response.setInfo(this.equalAssistParameter(body.isAssist()));
            return response;
        }

        SocialEvent event = this.socialEventCRUDService.getById(body.getEventId());

        if (body.isAssist()) {
            user.getAttendedEvents().add(event);
        } else {
            user.getAttendedEvents().remove(event);
        }

        this.userRepository.save(user);
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
