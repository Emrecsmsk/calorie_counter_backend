package pinsoft.caloriecounter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pinsoft.caloriecounter.model.Nutrition;
import pinsoft.caloriecounter.repository.NutritionRepository;
import pinsoft.caloriecounter.service.NutritionService;

import java.util.List;

@RestController
@RequestMapping("/api/nutrition")
public class NutritionController {

    NutritionService nutritionService;
    private final NutritionRepository nutritionRepository;

    @Autowired
    public NutritionController(NutritionService nutritionService,
                               NutritionRepository nutritionRepository) {
        this.nutritionService = nutritionService;
        this.nutritionRepository = nutritionRepository;
    }

    @PostMapping("/addnutrition")
    void addNutrition(@RequestBody Nutrition nutrition){
        nutritionService.addNutrition(nutrition);
    }

    @GetMapping("/getAll")
    public List<Nutrition> getAll(){
        return nutritionService.getAll();
    }

    @DeleteMapping("/deleteutrition")
    void deleteNutrition(int id){
        nutritionService.deleteNutrition(id);
    }
}
