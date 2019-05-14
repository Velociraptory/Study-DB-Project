package tacobell;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Taco {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO) //relying on the database to automatically generate the ID value
    private Long id;
    private Date createdAt;
    @NotNull
    @Size(min=5, message="Name must be at least 5 characters long")
    private String name;

    @ManyToMany(targetEntity=Ingredient.class) //relationship between a Taco and its associated Ingredient list
    @Size(min=1, message="You must choose at least 1 ingredient")
    private List<Ingredient> ingredients;

    //set the createdAt property to the current date and time before Taco is persisted
    @PrePersist
    void createdAt() {
        this.createdAt = new Date();
    }
}
