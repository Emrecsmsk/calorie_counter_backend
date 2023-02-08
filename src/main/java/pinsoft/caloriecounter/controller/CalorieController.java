package pinsoft.caloriecounter.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pinsoft.caloriecounter.core.utilities.results.DataResult;
import pinsoft.caloriecounter.model.Calorie;
import pinsoft.caloriecounter.service.CalorieService;

import java.util.Date;

@RestController
@RequestMapping("/api/calorie")
public class CalorieController {

    CalorieService calorieService;

    @Autowired
    public CalorieController(CalorieService calorieService) {
        this.calorieService = calorieService;
    }

    @GetMapping("/showCalorieDateBetween")
    DataResult<Calorie> showCalorie(int id, @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateStart, @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateEnd){
        return calorieService.showCalorieDateBetween(id,dateStart,dateEnd);
    }

    @GetMapping("/showCalorieAMeal")
    DataResult<Calorie> showCalorieAMeal(int id){
        return calorieService.showCalorieAMeal(id);
    }


}