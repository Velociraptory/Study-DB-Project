package tacobell.data;

import org.springframework.data.repository.CrudRepository;
import tacobell.Ingredient;
/**CrudRepository declares about a dozen methods for CRUD operations. it’s parameterized, with
 the first parameter being the entity type the repository is to persist,
 and the second parameter being the type of the entity ID property.
 When the application starts, Spring Data JPA automatically generates an implementation
 those methods. It only remains to inject them into the controllers*/
public interface IngredientRepository extends CrudRepository<Ingredient, String> {
    //Spring JDBC
    //Iterable<Ingredient> findAll(); //Query for all ingredients into a collection of Ingredient objects
    //Ingredient findOne(String id); //Query for a single Ingredient by its id
    //Ingredient save(Ingredient ingredient); //Save an Ingredient object
}
