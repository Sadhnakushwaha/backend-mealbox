package com.example.recipeapp.service;

import com.example.recipeapp.entity.Meal;
import com.example.recipeapp.exception.ResourceNotFoundException;
import com.example.recipeapp.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class MealService {

    @Autowired
    private MealRepository mealRepository;
    
    public List<Meal> getAllMeals(){
    	List<Meal> meals=mealRepository.findAll();
    	return meals;
    }

    public List<Meal> searchMealsByName(String name) {
        List<Meal> meals = mealRepository.findByStrMealContainingIgnoreCase(name);
        if (meals.isEmpty()) {
            throw new ResourceNotFoundException("No meals found with name: " + name);
        }
        return meals;
    }

    public List<Meal> getMealsByFirstLetter(char letter) {
        List<Meal> meals = mealRepository.findByStrMealStartingWithIgnoreCase(String.valueOf(letter));
        if (meals.isEmpty()) {
            throw new ResourceNotFoundException("No meals found starting with letter: " + letter);
        }
        return meals;
    }

    public Meal getMealById(Long id) {
        return mealRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Meal not found with id: " + id));
    }

    public List<Meal> getRandomMeals(int count) {
        List<Meal> allMeals = mealRepository.findAll();
        if (allMeals.isEmpty()) {
            throw new ResourceNotFoundException("No meals available.");
        }
        Random random = new Random();
        return IntStream.range(0, count)
                .mapToObj(i -> allMeals.get(random.nextInt(allMeals.size())))
                .collect(Collectors.toList());
    }
    
    public List<Meal> filterMealsByIngredient(String ingredient) {
        return mealRepository.findByStrIngredient1ContainingIgnoreCase(ingredient);
    }

    public List<Meal> filterMealsByArea(String area) {
        return mealRepository.findByStrAreaIgnoreCase(area);
    }

    public List<Meal> filterMealsByCategory(String categoryName) {
        return mealRepository.findByCategory_StrCategoryIgnoreCase(categoryName);
    }
    public Meal addMenuItem(Meal meal) {
        return mealRepository.save(meal);
    }
    
    

    public Meal updateMeal(Long id, Meal updatedMeal) {
        Optional<Meal> optionalMeal = mealRepository.findById(id);
        if (!optionalMeal.isPresent()) {
            throw new ResourceNotFoundException("Meal not found with id: " + id);
        }

        Meal existingMeal = optionalMeal.get();
        
        // Update fields
        existingMeal.setStrMeal(updatedMeal.getStrMeal());
        existingMeal.setCategory(updatedMeal.getCategory());
        existingMeal.setStrArea(updatedMeal.getStrArea());
        existingMeal.setStrInstructions(updatedMeal.getStrInstructions());
        existingMeal.setStrMealThumb(updatedMeal.getStrMealThumb());
        existingMeal.setStrTags(updatedMeal.getStrTags());
        existingMeal.setStrYoutube(updatedMeal.getStrYoutube());
        existingMeal.setStrIngredient1(updatedMeal.getStrIngredient1());
        existingMeal.setStrIngredient2(updatedMeal.getStrIngredient2());
        existingMeal.setStrIngredient3(updatedMeal.getStrIngredient3());
        existingMeal.setStrIngredient4(updatedMeal.getStrIngredient4());
        existingMeal.setStrIngredient5(updatedMeal.getStrIngredient5());
        existingMeal.setStrMeasure1(updatedMeal.getStrMeasure1());
        existingMeal.setStrMeasure2(updatedMeal.getStrMeasure2());
        existingMeal.setStrMeasure3(updatedMeal.getStrMeasure3());
        existingMeal.setStrMeasure4(updatedMeal.getStrMeasure4());
        existingMeal.setStrMeasure5(updatedMeal.getStrMeasure5());
        existingMeal.setStrSource(updatedMeal.getStrSource());
        existingMeal.setStrImageSource(updatedMeal.getStrImageSource());
        existingMeal.setStrCreativeCommonsConfirmed(updatedMeal.getStrCreativeCommonsConfirmed());
        existingMeal.setDateModified(updatedMeal.getDateModified());

        return mealRepository.save(existingMeal);
    }

    public void deleteMeal(Long id) {
        if (!mealRepository.existsById(id)) {
            throw new RuntimeException("Meal not found with id: " + id);
        }
        mealRepository.deleteById(id);
    }



    
}
