package com.example.demo.services.category;

import com.example.demo.services.category.dto.CategoryInfoDTO;
import com.example.demo.services.category.dto.CreateCategoryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryCRUDService {
    CategoryInfoDTO create(CreateCategoryDTO categoryInfo);
    CategoryInfoDTO update(CategoryInfoDTO categoryInfo);
    Page<CategoryInfoDTO> getCategories(Pageable pageable);
    void delete(Long categoryId);
}
