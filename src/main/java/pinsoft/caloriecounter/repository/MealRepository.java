package pinsoft.caloriecounter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pinsoft.caloriecounter.model.Meal;

import java.util.Date;
import java.util.List;

public interface MealRepository extends JpaRepository<Meal, Integer> {
    Meal findByMealId(int mealId);

    List<Meal> findByUser_IdAndDateBetween(int id, Date dateStart, Date dateEnd);


}
