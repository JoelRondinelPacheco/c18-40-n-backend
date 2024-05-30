package com.example.demo.services.socialevent.impl;

import com.example.demo.exceptions.EntityNotFoundException;
import com.example.demo.persistence.entities.Category;
import com.example.demo.persistence.entities.Person;
import com.example.demo.persistence.entities.SocialEvent;
import com.example.demo.persistence.repository.CategoryRepository;
import com.example.demo.persistence.repository.SocialEventRepository;
import com.example.demo.persistence.repository.UserRepository;
import com.example.demo.services.DtoMapper;
import com.example.demo.services.socialevent.SocialEventCRUDService;
import com.example.demo.services.socialevent.dto.CreateSocialEventDTO;
import com.example.demo.services.socialevent.dto.SocialEventInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SocialEventCRUDServiceImpl implements SocialEventCRUDService {

    @Qualifier("socialEventMapper")
    private final DtoMapper<SocialEventInfoDTO, SocialEvent> mapper;
    private final CategoryRepository categoryRepository;
    private final SocialEventRepository socialEventRepository;
    private final UserRepository userRepository;

    @Autowired
    public SocialEventCRUDServiceImpl(DtoMapper<SocialEventInfoDTO, SocialEvent> mapper, CategoryRepository categoryRepository, SocialEventRepository socialEventRepository, UserRepository userRepository) {
        this.mapper = mapper;
        this.categoryRepository = categoryRepository;
        this.socialEventRepository = socialEventRepository;
        this.userRepository = userRepository;

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
        socialEvent.setProgrammedDate(update.getProgramatedDate());
        socialEvent.setContactInfo(update.getContactInfo());
        socialEvent.setDetails(update.getDetails());
        socialEvent.setPrice(update.getPrice());
        socialEvent.setPublished(update.isPublished());
        socialEvent.setMaxGuests(update.getMaxGuests());
        socialEvent.setCategories(categories);
        return null;
    }

    @Override
    public Page<SocialEventInfoDTO> getPage(Pageable pageable) {
        return this.socialEventRepository.findAll(pageable).map(this.mapper::entityToDTO);
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

        Person person = this.userRepository.findByEmail(dto.getOrganizerEmail()).orElseThrow();
        List<Category> categories = this.categoryRepository.findAllById(dto.getCategoriesId());

        SocialEvent socialEvent = new SocialEvent();
        socialEvent.setName(dto.getName());
        socialEvent.setMaxGuests(dto.getMaxGuests());
        socialEvent.setAddress(dto.getAddress());
        socialEvent.setProgrammedDate(dto.getProgramatedDate());
        socialEvent.setContactInfo(dto.getContactInfo());
        socialEvent.setDetails(dto.getDetails());
        socialEvent.setPrice(dto.getPrice());
        socialEvent.setPublished(dto.isPublished());
        socialEvent.setCategories(categories);
        socialEvent.setOrganizer(person);

        return socialEvent;
    }
}
