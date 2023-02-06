package pinsoft.caloriecounter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import pinsoft.caloriecounter.model.Calorie;
import pinsoft.caloriecounter.model.Meal;
import pinsoft.caloriecounter.service.MealService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/meal")
public class MealController {

    MealService mealService;

    @Autowired
    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @PostMapping("/addmeal")
    void addNutrition(@RequestParam("mealName") String mealName, @RequestParam("nutrions") List<Integer> nutrions, @RequestParam("user") String userName, @DateTimeFormat(pattern= "MM-dd-yyyy") @RequestBody Date date){
        mealService.addMeal(mealName, nutrions, userName, date);
    }

    @GetMapping("/showMeal")
     Meal showMeal(int meal_id){
        return mealService.showMeal(meal_id);
    }

    @DeleteMapping("/deleteMeal")
    void deleteMeal(int id){
        mealService.deleteMeal(id);
    }

    @GetMapping("/showCalorie")
    Calorie showCalorie(int id,@DateTimeFormat(pattern = "yyyy-MM-dd") Date dateStart,@DateTimeFormat(pattern = "yyyy-MM-dd") Date dateEnd){
        return mealService.showCalorie(id,dateStart,dateEnd);
    }


}
//
