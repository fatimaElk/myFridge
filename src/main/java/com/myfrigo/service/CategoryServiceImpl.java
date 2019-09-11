package com.myfrigo.service;

import com.myfrigo.domain.Aliment;
import com.myfrigo.domain.Category;
import com.myfrigo.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service

public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryService.class);

    @Override
    public Category addNewCategory(String nom) {
        Category category = new Category();
        if (categoryRepository.findByName(nom) == null) {
            categoryRepository.save(category);
            return category;
        } else {
            return categoryRepository.findByName(nom);
        }
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public void deleteCategory(String name) {
        Category category = getCategoryByName(name);
        categoryRepository.delete(category);

    }

    @Override
    public Category getCategoryByName(String name) {
        return categoryRepository.findByName(name);
    }


}


