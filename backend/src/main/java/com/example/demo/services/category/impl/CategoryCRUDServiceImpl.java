package com.example.demo.services.category.impl;

import com.example.demo.exceptions.EntityAlreadyExistsException;
import com.example.demo.exceptions.EntityNotFoundException;
import com.example.demo.persistence.entities.Category;
import com.example.demo.persistence.repository.CategoryRepository;
import com.example.demo.services.DtoMapper;
import com.example.demo.services.category.CategoryCRUDService;
import com.example.demo.services.category.dto.CategoryInfoDTO;
import com.example.demo.services.category.dto.CreateCategoryDTO;
import org.hibernate.exception.ConstraintViolationException;
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
        try {
            Category category = this.categoryFromDTO(categoryInfo);

            Category categorySaved = this.categoryRepository.save(category);

            return this.mapper.entityToDTO(categorySaved);
        } catch (ConstraintViolationException e) {
            throw new EntityAlreadyExistsException("La categoría con el nombre " + categoryInfo.getName() + " ya existe.");
        }
    }

    @Override
    public CategoryInfoDTO update(CategoryInfoDTO categoryInfo) {
        Category category = this.categoryRepository.findById(categoryInfo.getId()).orElseThrow(() -> new EntityNotFoundException("La categoría: " + categoryInfo.getName() + " no existe."));
        Category returnCategory = null;

        if (categoryInfo.getName().equals(category.getName())) {
            returnCategory = category;
        } else {
            category.setName(category.getName());
            returnCategory = this.categoryRepository.save(category);
        }

        return this.mapper.entityToDTO(returnCategory);
    }

    @Override
    public Page<CategoryInfoDTO> getCategories(Pageable pageable) {
        return this.categoryRepository.findAll(pageable).map(this.mapper::entityToDTO);
    }

    @Override
    public void delete(Long categoryId) {
        // TODO IMPLEMENTAR SOLO DESACTIVARLA
    }

    private Category categoryFromDTO (CreateCategoryDTO dto) {
        Category category = new Category();
        category.setName(dto.getName());
        return category;
    }
}
