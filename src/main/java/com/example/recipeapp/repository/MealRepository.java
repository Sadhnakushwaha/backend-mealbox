package com.example.recipeapp.repository;

import com.example.recipeapp.entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {

	@Query("SELECT m FROM Meal m WHERE UPPER(m.strMeal) LIKE UPPER(CONCAT('%', :name, '%'))")
	List<Meal> searchMealsByName(@Param("name") String name);

//	findByStrMealContainingIgnoreCase(String name) 
	
    List<Meal> findByStrMealContainingIgnoreCase(String name);
    
    List<Meal> findByStrMealStartingWithIgnoreCase(String letter);
    
    List<Meal> findByStrIngredient1ContainingIgnoreCase(String ingredient);
    
    List<Meal> findByStrAreaIgnoreCase(String area);
    
    List<Meal> findByCategory_StrCategoryIgnoreCase(String categoryName);
}
