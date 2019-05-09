package tacobell.data;

import tacobell.Ingredient;

public interface IngredientRepository {
    Iterable<Ingredient> findAll(); //Query for all ingredients into a collection of Ingredient objects
    Ingredient findOne(String id); //Query for a single Ingredient by its id
    Ingredient save(Ingredient ingredient); //Save an Ingredient object
}
