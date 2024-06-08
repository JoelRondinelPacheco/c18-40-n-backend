package com.example.demo.services.socialevent;

import com.example.demo.services.socialevent.dto.UserEventAssistRequest;
import com.example.demo.services.socialevent.dto.UserEventAssistResponse;

public interface ToggleAssistEventUseCase {
    UserEventAssistResponse assists(UserEventAssistRequest body, String email);
}
