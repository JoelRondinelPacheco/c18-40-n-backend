package com.example.demo.services.socialevent;

import com.example.demo.services.socialevent.dto.UserEventAssistInfo;

public interface ToggleAssistEventUseCase {
    UserEventAssistInfo assists(UserEventAssistInfo body);
}
