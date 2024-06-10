package com.example.demo.services.socialevent.impl;

import com.example.demo.exceptions.EntityNotFoundException;
import com.example.demo.persistence.entities.Category;
import com.example.demo.persistence.entities.User;
import com.example.demo.persistence.entities.SocialEvent;
import com.example.demo.persistence.repository.CategoryRepository;
import com.example.demo.persistence.repository.SocialEventRepository;
import com.example.demo.persistence.repository.UserRepository;
import com.example.demo.services.DtoMapper;
import com.example.demo.services.socialevent.SocialEventCRUDService;
import com.example.demo.services.socialevent.SocialEventService;
import com.example.demo.services.socialevent.dto.CreateSocialEventDTO;
import com.example.demo.services.socialevent.dto.SocialEventInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SocialEventCRUDServiceImpl implements SocialEventCRUDService {

    @Qualifier("socialEventMapper")
    private final DtoMapper<SocialEventInfoDTO, SocialEvent> mapper;
    private final CategoryRepository categoryRepository;
    private final SocialEventRepository socialEventRepository;
    private final UserRepository userRepository;
    private final SocialEventService socialEventService;

    @Autowired
    public SocialEventCRUDServiceImpl(DtoMapper<SocialEventInfoDTO, SocialEvent> mapper, CategoryRepository categoryRepository, SocialEventRepository socialEventRepository, UserRepository userRepository, SocialEventService socialEventService) {
        this.mapper = mapper;
        this.categoryRepository = categoryRepository;
        this.socialEventRepository = socialEventRepository;
        this.userRepository = userRepository;
        this.socialEventService = socialEventService;
    }

    @Override
    public SocialEventInfoDTO create(CreateSocialEventDTO info) {
        SocialEvent socialEvent = this.socialEventFromDTO(info);
        SocialEvent savedSocialEvent = this.socialEventRepository.save(socialEvent);
        return this.mapper.entityToDTO(savedSocialEvent);
    }

    @Override
    public SocialEventInfoDTO update(SocialEventInfoDTO update) {

        List<Category> categories = this.categoryRepository.findAllById(
                update.getCategories().stream()
                        .map(c -> c.getId())
                        .collect(Collectors.toList())
        );

        SocialEvent socialEvent = this.getById(update.getId());
        socialEvent.setName(update.getName());
        socialEvent.setAddress(update.getAddress());
        socialEvent.setStartDate(update.getStartDate());
        socialEvent.setContactInfo(update.getContactInfo());
        socialEvent.setDetails(update.getDetails());
        socialEvent.setPrice(update.getPrice());
        socialEvent.setPublished(update.isPublished());
        socialEvent.setMaxGuests(update.getMaxGuests());
        socialEvent.setCategories(categories);

        SocialEvent savedSocialEvent = this.socialEventRepository.save(socialEvent);
        return this.mapper.entityToDTO(savedSocialEvent);
    }

    @Override
    public SocialEvent updateEntity(SocialEvent socialEvent) {
        return this.socialEventRepository.save(socialEvent);
    }

    @Override
    public Page<SocialEventInfoDTO> getPage(Pageable pageable) {
        Object p = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return this.socialEventRepository.findAll(pageable).map(e -> this.socialEventInfo(e, (String) p));

    }

    private SocialEventInfoDTO socialEventInfo(SocialEvent socialEvent, String email) {
        boolean userAssists = false;
        Optional<User> userOptional = this.userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            userAssists  = this.userRepository.isUserAttendingEvent(userOptional.get().getId(), socialEvent.getId()) > 0 ;
        }

        BigDecimal eventTotalQualification = this.socialEventService.getQualification(socialEvent.getId()).qualification();
        SocialEventInfoDTO s = this.mapper.entityToDTO(socialEvent);
        s.setTotalQualification(eventTotalQualification);
        s.setUserAssists(userAssists);

        return s;
    }

    @Override
    public SocialEventInfoDTO getDTOById(Long id) {
        SocialEvent socialEvent = this.getById(id);
        return this.mapper.entityToDTO(socialEvent);
    }

    @Override
    public SocialEvent getById(Long id) {
        return this.socialEventRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("El evento solicitado no existe."));
    }

    @Override
    public void delete(Long eventId) {
        //this.socialEventRepository.deleteById(eventId);
        // TODO SOLO DESACTIVAR
    }

    private SocialEvent socialEventFromDTO(CreateSocialEventDTO dto) {

        User user = this.userRepository.findByEmail(dto.getOrganizerEmail()).orElseThrow();
        List<Category> categories = this.categoryRepository.findAllById(dto.getCategoriesId());

        SocialEvent socialEvent = new SocialEvent();
        socialEvent.setName(dto.getName());
        socialEvent.setMaxGuests(dto.getMaxGuests());

        socialEvent.setAddress(dto.getAddress());
        socialEvent.setCity(dto.getCity());
        socialEvent.setPlaceName(dto.getPlaceName());

        socialEvent.setStartDate(dto.getStartDate());
        socialEvent.setFinishDate(dto.getFinishDate());

        socialEvent.setContactInfo(dto.getContactInfo());
        socialEvent.setDetails(dto.getDetails());
        socialEvent.setPrice(dto.getPrice());
        socialEvent.setPublished(dto.isPublished());
        socialEvent.setCategories(categories);
        socialEvent.setOrganizer(user);

        return socialEvent;
    }
}
