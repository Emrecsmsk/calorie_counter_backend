package pinsoft.caloriecounter.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pinsoft.caloriecounter.core.utilities.results.DataResult;
import pinsoft.caloriecounter.core.utilities.results.SuccessDataResult;
import pinsoft.caloriecounter.model.Calorie;
import pinsoft.caloriecounter.model.Meal;
import pinsoft.caloriecounter.repository.MealRepository;

import java.util.Date;
import java.util.List;

@Service
public class CalorieService {
    MealRepository mealRepository;

    @Autowired
    public CalorieService(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    public DataResult<Calorie> showCalorieAMeal(int id){
        Calorie calorie = new Calorie();

        double totalKcal = 0;
        double totalCarbonhydrate = 0;
        double totalProtein = 0;
        double totalFat = 0;

        Meal meal = mealRepository.findByMealId(id);

            for (int j=0; meal.getNutritions().size()>j; j++){
                totalKcal = totalKcal + meal.getNutritions().get(j).getKcal();
                totalCarbonhydrate = totalCarbonhydrate + meal.getNutritions().get(j).getCarbonhydrate();
                totalProtein = totalProtein + meal.getNutritions().get(j).getProtein();
                totalFat = totalFat + meal.getNutritions().get(j).getFat();
            }

        calorie.setKcal(totalKcal);
        calorie.setCarbonhydrate(totalCarbonhydrate);
        calorie.setProtein(totalProtein);
        calorie.setFat(totalFat);

        return new SuccessDataResult(calorie);

    }


    public DataResult<Calorie> showCalorieDateBetween(int id, Date dateStart, Date dateEnd){
        Calorie calorie = new Calorie();

        double totalKcal = 0;
        double totalCarbonhydrate = 0;
        double totalProtein = 0;
        double totalFat = 0;

        List<Meal> mealList = mealRepository.findByUser_IdAndDateBetween(id, dateStart, dateEnd);

        for(Meal meal : mealList){
            for (int j=0; meal.getNutritions().size()>j; j++){
                totalKcal = totalKcal + meal.getNutritions().get(j).getKcal();
                totalCarbonhydrate = totalCarbonhydrate + meal.getNutritions().get(j).getCarbonhydrate();
                totalProtein = totalProtein + meal.getNutritions().get(j).getProtein();
                totalFat = totalFat + meal.getNutritions().get(j).getFat();
            }
        }

        calorie.setKcal(totalKcal);
        calorie.setCarbonhydrate(totalCarbonhydrate);
        calorie.setProtein(totalProtein);
        calorie.setFat(totalFat);

        return new SuccessDataResult(calorie);

    }

}
