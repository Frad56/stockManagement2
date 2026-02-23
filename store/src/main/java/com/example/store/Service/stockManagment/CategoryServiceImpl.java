package com.example.store.Service.stockManagment;


import com.example.store.Exception.ElementNotFoundException;
import com.example.store.Model.StockMangement.Category;
import com.example.store.Repository.StockManagment.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {


    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository =categoryRepository;
    }

    //add
    @Override
    public Category saveCategory(Category category){
        return categoryRepository.save(category);
    }

    //Read
    @Override
    public List<Category> fetchCategoryList(){
        return categoryRepository.findAll();
    }

    //delete
    @Override
    public void deleteCategoryByID(Long categoryId){
        if(!categoryRepository.existsById(categoryId)){
            throw new ElementNotFoundException(categoryId);
        }
        categoryRepository.deleteById(categoryId);
    }

    //Search
    @Override
    public Category findCategoryById(Long categoryId){
        return  categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ElementNotFoundException(categoryId));
    }
}

