package com.example.recipeapp.controller;

import com.example.recipeapp.entity.Meal;
import com.example.recipeapp.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/meals")
public class MealController {

    @Autowired
    private MealService mealService;
    
    @GetMapping
    public ResponseEntity<List<Meal>> getAllMeals(){
    	List<Meal> meals = mealService.getAllMeals();
    	return ResponseEntity.ok(meals);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Meal>> searchMealsByName(@RequestParam String name) {
        List<Meal> meals = mealService.searchMealsByName(name);
        System.out.println("Fetched Meals: " + meals); 
        return ResponseEntity.ok(meals);
    }


    @GetMapping("/letter")
    public ResponseEntity<List<Meal>> getMealsByFirstLetter(@RequestParam char letter) {
        return ResponseEntity.ok(mealService.getMealsByFirstLetter(letter));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMealById(@PathVariable Long id) {
        try {
            Meal meal = mealService.getMealById(id);
            return ResponseEntity.ok(meal);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(Collections.singletonMap("error", e.getMessage()));
        }
    }


    @GetMapping("/random/{count}")
    public ResponseEntity<List<Meal>> getRandomMeals(@PathVariable int count) {
        return ResponseEntity.ok(mealService.getRandomMeals(count));
    }
    
    @GetMapping("/filter-by-ingredient")
    public ResponseEntity<List<Meal>> filterMealsByIngredient(@RequestParam String ingredient) {
        return ResponseEntity.ok(mealService.filterMealsByIngredient(ingredient));
    }

    @GetMapping("/filter-by-area")
    public ResponseEntity<List<Meal>> filterMealsByArea(@RequestParam String area) {
        return ResponseEntity.ok(mealService.filterMealsByArea(area));
    }
    
    @PostMapping
    public ResponseEntity<Meal> addMenuItem(@RequestBody Meal meal) {
        Meal savedMeal = mealService.addMenuItem(meal);
        return ResponseEntity.ok(savedMeal);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Meal> updateMeal(@PathVariable Long id, @RequestBody Meal updatedMeal) {
        Meal meal = mealService.updateMeal(id, updatedMeal);
        return ResponseEntity.ok(meal);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMeal(@PathVariable Long id) {
        try {
            mealService.deleteMeal(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(Collections.singletonMap("error", e.getMessage()));
        }
    }


   
}
