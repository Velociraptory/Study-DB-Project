package tacobell.data;

import org.springframework.data.repository.CrudRepository;
import tacobell.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {
    //Spring JDBC
    //Iterable<Ingredient> findAll(); //Query for all ingredients into a collection of Ingredient objects
    //Ingredient findOne(String id); //Query for a single Ingredient by its id
    //Ingredient save(Ingredient ingredient); //Save an Ingredient object
}
