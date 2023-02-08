package pinsoft.caloriecounter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pinsoft.caloriecounter.core.utilities.results.DataResult;
import pinsoft.caloriecounter.core.utilities.results.Result;
import pinsoft.caloriecounter.model.Nutrition;
import pinsoft.caloriecounter.repository.NutritionRepository;
import pinsoft.caloriecounter.service.NutritionService;

import java.util.List;

@RestController
@RequestMapping("/api/nutrition")
public class NutritionController {

    NutritionService nutritionService;

    @Autowired
    public NutritionController(NutritionService nutritionService,
                               NutritionRepository nutritionRepository) {
        this.nutritionService = nutritionService;
    }

    @PostMapping("/addNutrition")
    Result addNutrition(@RequestBody Nutrition nutrition){

       return nutritionService.addNutrition(nutrition);
    }

    @GetMapping("/getAllNutritions")
    public DataResult<List<Nutrition>> getAll(){
        return nutritionService.getAll();
    }


    @PutMapping("/editNutrition")
    public Result editNutrition(Nutrition nutrition){

        return nutritionService.editNutrition(nutrition);
    }

    @DeleteMapping("/deleteNutrition")
    Result deleteNutrition(int id){
        return nutritionService.deleteNutrition(id);
    }
}
