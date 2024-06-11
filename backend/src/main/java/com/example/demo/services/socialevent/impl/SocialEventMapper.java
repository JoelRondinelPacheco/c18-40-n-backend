package com.example.demo.services.socialevent.impl;

import com.example.demo.persistence.entities.Category;
import com.example.demo.persistence.entities.User;
import com.example.demo.persistence.entities.SocialEvent;
import com.example.demo.services.DtoMapper;
import com.example.demo.services.category.dto.CategoryInfoDTO;
import com.example.demo.services.user.dto.UserInfoDTO;
import com.example.demo.services.socialevent.dto.SocialEventInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@Qualifier("socialEventMapper")
public class SocialEventMapper implements DtoMapper<SocialEventInfoDTO, SocialEvent> {

    @Qualifier("personMapper")
    private final DtoMapper<UserInfoDTO, User> personMapper;
    @Qualifier("categoryMapper")
    private final DtoMapper<CategoryInfoDTO, Category> categoryMapper;

    @Autowired
    public SocialEventMapper(DtoMapper<UserInfoDTO, User> personMapper, DtoMapper<CategoryInfoDTO, Category> categoryMapper) {
        this.personMapper = personMapper;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public SocialEventInfoDTO entityToDTO(SocialEvent socialEvent) {
        SocialEventInfoDTO socialEventInfoDTO = new SocialEventInfoDTO();
        socialEventInfoDTO.setId(socialEvent.getId());
        socialEventInfoDTO.setName(socialEvent.getName());
        socialEventInfoDTO.setAddress(socialEvent.getAddress());
        socialEventInfoDTO.setProgramatedDate(socialEvent.getProgrammedDate());
        socialEventInfoDTO.setContactInfo(socialEvent.getContactInfo());
        socialEventInfoDTO.setDetails(socialEvent.getDetails());
        socialEventInfoDTO.setPrice(socialEvent.getPrice());
        socialEventInfoDTO.setPublished(socialEvent.isPublished());
        socialEventInfoDTO.setMaxGuests(socialEvent.getMaxGuests());
        socialEventInfoDTO.setConfirmedGuests(socialEvent.getConfirmedGuests());
        socialEventInfoDTO.setCategories(
                socialEvent.getCategories().stream()
                        .map(category -> this.categoryMapper.entityToDTO(category))
                        .collect(Collectors.toList()));
        socialEventInfoDTO.setOrganizer(this.personMapper.entityToDTO(socialEvent.getOrganizer()));

        return socialEventInfoDTO;
    }

    @Override
    public SocialEvent dtoToEntity(SocialEventInfoDTO socialEventInfoDTO) {
        return null;
    }
}
