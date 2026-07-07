package com.example.recipeapp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
//@RunWith(MockitoJUnitRunner.class)
class MealTimeApplicationTests {

	@Test
	void contextLoads() {
	}
	
//	 @Mock
//	    private MealRepository mealRepository;
//
//	    @InjectMocks
//	    private MealService mealService;
//
//	    @Test
//	    public void testGetMealById() {
//	        Meal meal = new Meal(1L, "Pizza", "Italian", "Bake at 200C", "image.jpg");
//	        Mockito.when(mealRepository.findById(1L)).thenReturn(Optional.of(meal));
//
//	        MealDTO result = mealService.getMealById(1L);
//	        assertEquals("Pizza", result.getName());
//	    }

}
