package com.example.store.Service.stockManagment.interfaces;


import com.example.store.DTO.stockManagment.CategoryDTO;
import com.example.store.Model.StockMangement.Category;

import java.util.List;

public interface CategoryService {

    Category saveCategory(CategoryDTO category);

    Category findCategoryById(Long categoryId);

    List<Category> fetchCategoryList();

    Category updateCategory(CategoryDTO category, Long categoryId);

    void deleteCategoryById(Long categoryId);
}
