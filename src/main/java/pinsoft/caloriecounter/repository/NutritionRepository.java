package pinsoft.caloriecounter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pinsoft.caloriecounter.model.Nutrition;


public interface NutritionRepository extends JpaRepository<Nutrition, Integer> {


    Nutrition findByNutritionId(int nutritionId);


}
