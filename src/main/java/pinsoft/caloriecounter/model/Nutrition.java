package pinsoft.caloriecounter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "nutritions")
public class Nutrition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nutrition_id")
    private int nutritionId;
    @Column(name = "name")
    private String name;
    @Column(name = "kcal")
    private Double kcal;
    @Column(name = "protein")
    private Double protein;
    @Column(name = "carbonhydrate")
    private Double carbonhydrate;
    @Column(name = "fat")
    private Double fat;

}

