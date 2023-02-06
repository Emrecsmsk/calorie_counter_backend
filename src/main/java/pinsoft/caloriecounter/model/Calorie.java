package pinsoft.caloriecounter.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Calorie {

    private Double kcal;

    private Double protein;

    private Double carbonhydrate;

    private Double fat;
}
