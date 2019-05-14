package tacobell.data;

import org.springframework.data.repository.CrudRepository;
import tacobell.Taco;

public interface TacoRepository extends CrudRepository<Taco, Long> {
    //Spring JDBC
    //Taco save(Taco design);
}
