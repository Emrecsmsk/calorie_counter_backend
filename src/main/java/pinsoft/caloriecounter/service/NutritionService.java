package pinsoft.caloriecounter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pinsoft.caloriecounter.model.Nutrition;
import pinsoft.caloriecounter.repository.NutritionRepository;

import java.util.List;

@Service
public class NutritionService {

    NutritionRepository nutritionRepository;

    @Autowired
    public NutritionService(NutritionRepository nutritionRepository) {
        this.nutritionRepository = nutritionRepository;
    }

    public void addNutrition(Nutrition nutrition){
        nutritionRepository.save(nutrition);
    }

    public List<Nutrition> getAll(){
       return nutritionRepository.findAll();
    }

    public void deleteNutrition(int id){
        nutritionRepository.deleteById(id);
    }


}
