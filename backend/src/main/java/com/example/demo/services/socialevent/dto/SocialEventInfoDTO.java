package com.example.demo.services.socialevent.dto;

import com.example.demo.services.category.dto.CategoryInfoDTO;
import com.example.demo.services.user.dto.UserInfoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SocialEventInfoDTO extends SocialEventBaseDTO {
    private Long id;
    private Long confirmedGuests;
    private List<CategoryInfoDTO> categories;
    private UserInfoDTO organizer;
}
