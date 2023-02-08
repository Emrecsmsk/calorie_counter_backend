package pinsoft.caloriecounter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pinsoft.caloriecounter.core.utilities.results.DataResult;
import pinsoft.caloriecounter.core.utilities.results.Result;
import pinsoft.caloriecounter.core.utilities.results.SuccessDataResult;
import pinsoft.caloriecounter.core.utilities.results.SuccessResult;
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

    public Result addNutrition(Nutrition nutrition){
        nutritionRepository.save(nutrition);
        return new SuccessResult();
    }

    public DataResult<List<Nutrition>> getAll(){
       return new SuccessDataResult(nutritionRepository.findAll());
    }

    public Result editNutrition(Nutrition nutrition){
        nutritionRepository.saveAndFlush(nutrition);
        return new SuccessResult();
    }

    public Result deleteNutrition(int id){
        nutritionRepository.deleteById(id);
        return new SuccessResult();
    }


}
