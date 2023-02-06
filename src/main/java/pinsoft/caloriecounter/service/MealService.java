package pinsoft.caloriecounter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import pinsoft.caloriecounter.model.Calorie;
import pinsoft.caloriecounter.model.Meal;
import pinsoft.caloriecounter.model.Nutrition;
import pinsoft.caloriecounter.model.User;
import pinsoft.caloriecounter.repository.MealRepository;
import pinsoft.caloriecounter.repository.NutritionRepository;
import pinsoft.caloriecounter.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MealService {

    MealRepository mealRepository;

    NutritionRepository nutritionRepository;

    UserRepository userRepository;

    @Autowired
    public MealService(MealRepository mealRepository, NutritionRepository nutritionRepository,UserRepository userRepository) {
        this.mealRepository = mealRepository;
        this.nutritionRepository = nutritionRepository;
        this.userRepository = userRepository;
    }




    public void addMeal(String mealName, List<Integer> nutrions, String userName, Date date){
        List<Nutrition> nutrion = new ArrayList<>();
        for (int i=0; nutrions.size()>i; i++){
            nutrion.add(nutritionRepository.findByNutritionId(nutrions.get(i)));
        }

        User user = userRepository.findByName(userName);


        Meal meal = new Meal();
        meal.setName(mealName);
        meal.setMealId(0);
        meal.setNutritions(nutrion);
        meal.setUser(user);
        meal.setDate(date);
        mealRepository.save(meal);
    }

    public Meal showMeal(int meal_id){
        return mealRepository.findByMealId(meal_id);
    }

    public void deleteMeal(int id){
        mealRepository.deleteById(id);
    }


    public Calorie showCalorie(int id, Date dateStart, Date dateEnd){
    Calorie calorie = new Calorie();

        double totalKcal = 0;
        double totalCarbonhydrate = 0;
        double totalProtein = 0;
        double totalFat = 0;

        List<Meal> mealList = mealRepository.findByUser_IdAndDateBetween(id, dateStart, dateEnd);

        for(int i=0; mealList.size()>i; i++){
            for (int j=0; mealList.get(i).getNutritions().size()>j; j++){
                totalKcal = totalKcal + mealList.get(i).getNutritions().get(j).getKcal();
                totalCarbonhydrate = totalCarbonhydrate + mealList.get(i).getNutritions().get(j).getCarbonhydrate();
                totalProtein = totalProtein + mealList.get(i).getNutritions().get(j).getProtein();
                totalFat = totalFat + mealList.get(i).getNutritions().get(j).getFat();
            }
        }

        calorie.setKcal(totalKcal);
        calorie.setCarbonhydrate(totalCarbonhydrate);
        calorie.setProtein(totalProtein);
        calorie.setFat(totalFat);

    return calorie;

    }

}
