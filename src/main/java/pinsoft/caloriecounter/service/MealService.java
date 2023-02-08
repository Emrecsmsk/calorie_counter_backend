package pinsoft.caloriecounter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pinsoft.caloriecounter.core.utilities.results.DataResult;
import pinsoft.caloriecounter.core.utilities.results.Result;
import pinsoft.caloriecounter.core.utilities.results.SuccessDataResult;
import pinsoft.caloriecounter.core.utilities.results.SuccessResult;
import pinsoft.caloriecounter.model.Meal;
import pinsoft.caloriecounter.model.Nutrition;
import pinsoft.caloriecounter.model.User;
import pinsoft.caloriecounter.repository.MealRepository;
import pinsoft.caloriecounter.repository.NutritionRepository;
import pinsoft.caloriecounter.repository.UserRepository;

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




    public Result addMeal(String mealName, List<Integer> nutrions, String userName, Date date){
        List<Nutrition> nutrion = new ArrayList<>();
        for (int i=0; nutrions.size()>i; i++){
            nutrion.add(nutritionRepository.findByNutritionId(nutrions.get(i)));
        }

        User user = userRepository.findByUserName(userName);


        Meal meal = new Meal();
        meal.setName(mealName);
        meal.setMealId(0);
        meal.setNutritions(nutrion);
        meal.setUser(user);
        meal.setDate(date);
        mealRepository.save(meal);

        return new SuccessResult();
    }

    public Result editMeal(int mealId, String mealName, List<Integer> nutrions){
        List<Nutrition> nutrion = new ArrayList<>();
        for (int i=0; nutrions.size()>i; i++){
            nutrion.add(nutritionRepository.findByNutritionId(nutrions.get(i)));
        }

        Meal meal = mealRepository.findByMealId(mealId);
        meal.setName(mealName);
        meal.setNutritions(nutrion);
        mealRepository.saveAndFlush(meal);
        return new SuccessResult();
    }

    public DataResult<Meal> showMeal(int meal_id){
        return new SuccessDataResult(mealRepository.findByMealId(meal_id));
    }

    public Result deleteMeal(int id){
        mealRepository.deleteById(id);
        return new SuccessResult();
    }

}
