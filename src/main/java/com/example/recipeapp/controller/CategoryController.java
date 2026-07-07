package com.example.recipeapp.controller;

import com.example.recipeapp.entity.Category;
import com.example.recipeapp.entity.Meal;
import com.example.recipeapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        System.out.println(" Categories Returned: " + categories);  
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }
    
    @GetMapping("/filter")
    public ResponseEntity<List<Meal>> filterMealsByCategory(@RequestParam String category) {
        return ResponseEntity.ok(categoryService.filterMealsByCategory(category));
    }
}
