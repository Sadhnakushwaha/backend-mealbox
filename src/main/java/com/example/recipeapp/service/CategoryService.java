package com.example.recipeapp.service;

import com.example.recipeapp.entity.Category;
import com.example.recipeapp.entity.Meal;
import com.example.recipeapp.exception.ResourceNotFoundException;
import com.example.recipeapp.repository.CategoryRepository;
import com.example.recipeapp.repository.MealRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    
    @Autowired
    private MealRepository mealRepository;

    public List<Category> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        System.out.println("Fetched Categories: " + categories);  
        return categories;
    }


    public Category getCategoryById(Long id) {
    	 return categoryRepository.findById(id)
    		        .orElseThrow(() -> {
    		          
    		            return new ResourceNotFoundException("Category not found with id: " + id);
    		        });
    }
    
    public List<Meal> filterMealsByCategory(String categoryName) {
        return mealRepository.findByCategory_StrCategoryIgnoreCase(categoryName);
    }
}
