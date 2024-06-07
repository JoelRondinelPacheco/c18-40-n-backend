package com.example.demo.services.socialevent.impl;

import com.example.demo.persistence.repository.SocialEventRepository;
import com.example.demo.services.socialevent.ToggleAssistEventUseCase;
import com.example.demo.services.socialevent.dto.ToggleAssistEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToggleAssistEventUseCaseImpl implements ToggleAssistEventUseCase {

    private final SocialEventRepository socialEventRepository;

    @Autowired
    public ToggleAssistEventUseCaseImpl(SocialEventRepository socialEventRepository) {
        this.socialEventRepository = socialEventRepository;
    }

    @Override
    public String assists(ToggleAssistEvent body) {
        return "todo implement";
    }
}
