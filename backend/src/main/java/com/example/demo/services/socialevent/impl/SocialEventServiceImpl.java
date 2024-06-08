package com.example.demo.services.socialevent.impl;

import com.example.demo.persistence.repository.SocialEventRepository;
import com.example.demo.services.socialevent.SocialEventService;
import com.example.demo.services.socialevent.dto.EventQualificationDTO;
import com.example.demo.services.socialevent.dto.EventQualificationQueryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class SocialEventServiceImpl implements SocialEventService {

    private final SocialEventRepository socialEventRepository;

    @Autowired
    public SocialEventServiceImpl(SocialEventRepository socialEventRepository) {
        this.socialEventRepository = socialEventRepository;
    }

    @Override
    public EventQualificationDTO getQualification(Long id) {
        EventQualificationQueryDTO eventQualification = this.socialEventRepository.getEventQualification(id);
        return new EventQualificationDTO(id, this.calc(eventQualification.getSum(), eventQualification.getTotalComments()));
    }

    private BigDecimal calc(BigDecimal qualificationSum, Long total) {
        return qualificationSum.divide(new BigDecimal(total), 1, RoundingMode.HALF_EVEN);
    }
}
