package com.example.demo.services.socialevent.dto;

import com.example.demo.services.category.dto.CategoryInfoDTO;
import com.example.demo.services.person.dto.PersonInfoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SocialEventInfoDTO extends SocialEventBaseDTO {
    private Long id;
    private Long confirmedGuests;
    private List<CategoryInfoDTO> categories;
    private PersonInfoDTO organizer;
}
