package com.example.demo.services.socialevent;

import com.example.demo.persistence.entities.SocialEvent;
import com.example.demo.services.socialevent.dto.CreateSocialEventDTO;
import com.example.demo.services.socialevent.dto.SocialEventInfoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SocialEventCRUDService {
    SocialEventInfoDTO create(CreateSocialEventDTO info);
    SocialEventInfoDTO update(SocialEventInfoDTO update);

    SocialEvent updateEntity(SocialEvent socialEvent);
    Page<SocialEventInfoDTO> getPage(Pageable pageable);

    SocialEventInfoDTO getDTOById(Long id);
    SocialEvent getById(Long id);

    void delete(Long eventId);
}
