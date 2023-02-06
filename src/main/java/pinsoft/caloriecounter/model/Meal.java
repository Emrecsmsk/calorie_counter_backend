package pinsoft.caloriecounter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "meals")
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meal_id")
    private int mealId;

    @Column(name = "date")
    private Date date;

    @Column(name="name")
    private String name;

    @ManyToMany
    @JoinColumn(name="nutrition_id")
    private List<Nutrition> nutritions;

    @ManyToOne
    @JoinColumn(name="id")
    private User user;



}
