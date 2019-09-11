package com.myfrigo.service;

import com.myfrigo.domain.Category;

import java.util.List;

public interface CategoryService {


    public Category addNewCategory(String nom);
    public List<Category> getAllCategory();
    public void deleteCategory(String name);
    public Category getCategoryByName(String name);
}
