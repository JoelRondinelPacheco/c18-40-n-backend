package com.example.demo.services.socialevent;

import com.example.demo.services.socialevent.dto.CreateSocialEventDTO;
import com.example.demo.services.socialevent.dto.SocialEventInfoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SocialEventCRUDService {
    SocialEventInfoDTO create(CreateSocialEventDTO info);
    SocialEventInfoDTO update(SocialEventInfoDTO update);
    Page<SocialEventInfoDTO> getPage(Pageable pageable);
    void delete(Long eventId);
}
