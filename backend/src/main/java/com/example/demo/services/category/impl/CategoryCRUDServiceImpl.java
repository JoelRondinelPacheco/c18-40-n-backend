package com.example.demo.services.category.impl;

import com.example.demo.persistence.entities.Category;
import com.example.demo.persistence.repository.CategoryRepository;
import com.example.demo.services.DtoMapper;
import com.example.demo.services.category.CategoryCRUDService;
import com.example.demo.services.category.dto.CategoryInfoDTO;
import com.example.demo.services.category.dto.CreateCategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryCRUDServiceImpl implements CategoryCRUDService {

    private final CategoryRepository categoryRepository;
    @Qualifier("categoryMapper")
    private final DtoMapper<CategoryInfoDTO, Category> mapper;

    @Autowired
    public CategoryCRUDServiceImpl(CategoryRepository categoryRepository, DtoMapper<CategoryInfoDTO, Category> mapper) {
        this.categoryRepository = categoryRepository;
        this.mapper = mapper;
    }

    @Override
    public CategoryInfoDTO create(CreateCategoryDTO categoryInfo) {
        Category category = new Category();
        category.setName(category.getName());

        Category categorySaved = this.categoryRepository.save(category);

        return this.mapper.entityToDTO(categorySaved);
    }

    @Override
    public CategoryInfoDTO update(CategoryInfoDTO categoryInfo) {
        Category category = this.categoryRepository.findById(categoryInfo.getId()).orElseThrow();
        category.setName(category.getName());

        Category categoryUpdated = this.categoryRepository.save(category);

        return this.mapper.entityToDTO(categoryUpdated);
    }

    @Override
    public Page<CategoryInfoDTO> getCategories(Pageable pageable) {
        return this.categoryRepository.findAll(pageable).map(this.mapper::entityToDTO);
    }

    @Override
    public void delete(Long categoryId) {
        // TODO VER QUE HACER ON DELETE
    }
}
