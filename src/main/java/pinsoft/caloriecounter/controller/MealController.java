package pinsoft.caloriecounter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import pinsoft.caloriecounter.core.utilities.results.DataResult;
import pinsoft.caloriecounter.core.utilities.results.Result;
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

    @PostMapping("/addMeal")
    Result addNutrition(@RequestParam("mealName") String mealName, @RequestParam("nutrions") List<Integer> nutrions, @RequestParam("user") String userName, @DateTimeFormat(pattern= "MM-dd-yyyy") @RequestBody Date date){
      return mealService.addMeal(mealName, nutrions, userName, date);
    }

    @PutMapping("/editMeal")
    Result editMeal(@RequestParam("userId") int userId,@RequestParam("mealName") String mealName, @RequestParam("nutrions") List<Integer> nutrions){
        return mealService.editMeal(userId, mealName, nutrions);
    }

    @GetMapping("/showMeal")
    DataResult showMeal(int meal_id){
        return mealService.showMeal(meal_id);
    }

    @DeleteMapping("/deleteMeal")
    Result deleteMeal(int id){
        return mealService.deleteMeal(id);
    }
}

