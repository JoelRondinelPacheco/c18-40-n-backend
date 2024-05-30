package com.example.demo.services.category.impl;

import com.example.demo.persistence.entities.Category;
import com.example.demo.services.DtoMapper;
import com.example.demo.services.category.dto.CategoryInfoDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("categoryMapper")
public class CategoryMapper implements DtoMapper<CategoryInfoDTO, Category> {
    @Override
    public CategoryInfoDTO entityToDTO(Category category) {
        return null;
    }

    @Override
    public Category dtoToEntity(CategoryInfoDTO categoryInfoDTO) {
        return null;
    }
}
