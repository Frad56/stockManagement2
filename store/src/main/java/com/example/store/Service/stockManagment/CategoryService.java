package com.example.store.Service.stockManagment;


import com.example.store.Model.StockMangement.Category;

import java.util.List;

public interface CategoryService {

    Category saveCategory(Category category);

    Category findCategoryById(Long categoryId);

    List<Category> fetchCategoryList();

    void deleteCategoryByID(Long categoryID);
}
