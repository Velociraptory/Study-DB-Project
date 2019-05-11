package tacobell.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import tacobell.Ingredient;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class JdbcIngredientRepository implements IngredientRepository{

    private JdbcTemplate jdbc;
    @Autowired //When Spring creates the JdbcIngredientRepository bean, it injects it with JdbcTemplate via the @Autowired annotated construction
    public JdbcIngredientRepository(JdbcTemplate jdbc) {
        /**The constructor assigns JdbcTemplate to an instance variable
        that will be used in other methods to query and insert into the database*/
        this.jdbc = jdbc;
    }

    @Override
    public Iterable<Ingredient> findAll() { //Query for all ingredients into a collection of Ingredient objects
        /**The query() method accepts the SQL for the query as well as an implementation
        of Spring’s RowMapper for the purpose of mapping each row in the result set to
        an object*/
        return jdbc.query("select id, name, type from Ingredient", this::mapRowToIngredient);
    }

    @Override
    public Ingredient findOne(String id) { //Query for a single Ingredient by its id
        /**findById() method only expects to return a single Ingredient object,
        so it uses the queryForObject() instead of query() */
        return jdbc.queryForObject("select id, name, type from Ingredient where id=?",
                this::mapRowToIngredient, id);
        /**it’s given the query to perform, a RowMapper, and the id
        of Ingredient to fetch, which is used in place of the ? in the query*/
    }

    private Ingredient mapRowToIngredient(ResultSet rs, int rowNum)
            throws SQLException { //generating object from result set
        return new Ingredient(
                rs.getString("id"),
                rs.getString("name"),
                Ingredient.Type.valueOf(rs.getString("type"))); //????
    }

  /**  @Override  explicit RowMapper implementation version without java's 8 method references
    public Ingredient findOne(String id) {
        return jdbc.queryForObject(
                "select id, name, type from Ingredient where id=?",
                new RowMapper<Ingredient>() {
                }
        public Ingredient mapRow(ResultSet rs, int rowNum)
      throws SQLException {
            return new Ingredient(
                    rs.getString("id"),
                    rs.getString("name"),
                    Ingredient.Type.valueOf(rs.getString("type")));
        };
    }, id); */

  @Override
  public Ingredient save(Ingredient ingredient) { //Save an Ingredient object
      jdbc.update(
              "insert into Ingredient (id, name, type) values (?, ?, ?)",
              ingredient.getId(),
              ingredient.getName(),
              ingredient.getType().toString());
      return ingredient;
  }
}
