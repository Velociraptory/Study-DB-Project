package tacobell.data;

import org.springframework.data.repository.CrudRepository;
import tacobell.Taco;

/**CrudRepository declares about a dozen methods for CRUD operations. it’s parameterized, with
 the first parameter being the entity type the repository is to persist,
 and the second parameter being the type of the entity ID property.
 When the application starts, Spring Data JPA automatically generates an implementation
 those methods. It only remains to inject them into the controllers*/
public interface TacoRepository extends CrudRepository<Taco, Long> {
    //Spring JDBC
    //Taco save(Taco design);
}
