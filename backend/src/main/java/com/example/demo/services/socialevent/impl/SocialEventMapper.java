package com.example.demo.services.socialevent.impl;

import com.example.demo.persistence.entities.SocialEvent;
import com.example.demo.services.DtoMapper;
import com.example.demo.services.socialevent.dto.SocialEventInfoDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("socialEventMapper")
public class SocialEventMapper implements DtoMapper<SocialEventInfoDTO, SocialEvent> {
    @Override
    public SocialEventInfoDTO entityToDTO(SocialEvent socialEvent) {
        return null;
    }

    @Override
    public SocialEvent dtoToEntity(SocialEventInfoDTO socialEventInfoDTO) {
        return null;
    }
}
