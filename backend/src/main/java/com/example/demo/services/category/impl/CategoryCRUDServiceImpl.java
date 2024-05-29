package com.example.demo.services.category.impl;

import com.example.demo.services.category.CategoryCRUDService;
import com.example.demo.services.category.dto.CategoryInfoDTO;
import com.example.demo.services.category.dto.CreateCategoryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class CategoryCRUDServiceImpl implements CategoryCRUDService {
    @Override
    public CategoryInfoDTO create(CreateCategoryDTO categoryInfo) {
        return null;
    }

    @Override
    public CategoryInfoDTO update(CategoryInfoDTO categoryInfo) {
        return null;
    }

    @Override
    public Page<CategoryInfoDTO> getCategories(Pageable pageable) {
        return null;
    }

    @Override
    public void delete(Long categoryId) {

    }
}
