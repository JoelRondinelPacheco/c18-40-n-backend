package com.example.demo.services.socialevent.impl;

import com.example.demo.persistence.entities.SocialEvent;
import com.example.demo.persistence.repository.SocialEventRepository;
import com.example.demo.services.DtoMapper;
import com.example.demo.services.socialevent.SocialEventCRUDService;
import com.example.demo.services.socialevent.dto.CreateSocialEventDTO;
import com.example.demo.services.socialevent.dto.SocialEventInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SocialEventCRUDServiceImpl implements SocialEventCRUDService {

    private final SocialEventRepository socialEventRepository;
    @Qualifier("socialEventMapper")
    private final DtoMapper<SocialEventInfoDTO, SocialEvent> mapper;

    @Autowired
    public SocialEventCRUDServiceImpl(SocialEventRepository socialEventRepository, DtoMapper<SocialEventInfoDTO, SocialEvent> mapper) {
        this.socialEventRepository = socialEventRepository;
        this.mapper = mapper;
    }

    @Override
    public SocialEventInfoDTO create(CreateSocialEventDTO info) {
        return null;
    }

    @Override
    public SocialEventInfoDTO update(SocialEventInfoDTO update) {
        return null;
    }

    @Override
    public Page<SocialEventInfoDTO> getPage(Pageable pageable) {
        return null;
    }

    @Override
    public void delete(Long eventId) {

    }
}
