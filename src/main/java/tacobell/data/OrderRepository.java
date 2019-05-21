package tacobell.data;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import tacobell.Order;
import tacobell.User;

import java.util.List;

/**CrudRepository declares about a dozen methods for CRUD operations. it’s parameterized, with
 the first parameter being the entity type the repository is to persist,
 and the second parameter being the type of the entity ID property.
 When the application starts, Spring Data JPA automatically generates an implementation
 those methods. It only remains to inject them into the controllers*/
public interface OrderRepository extends CrudRepository<Order, Long> {
    //Spring JDBC
    //Order save(Order order);

    //Spring Data Jpa
    /**customized methods */
    //List<Order> findByDeliveryZip(String deliveryZip);
    //List<Order> readOrdersByDeliveryZipAndPlacedAtBetween(String deliveryZip, Date startDate, Date endDate);
    //List<Order> findByDeliveryToAndDeliveryCityAllIgnoresCase(String deliveryTo, String deliveryCity);
    //List<Order> findByDeliveryCityOrderByDeliveryTo(String city);

    //@Query("Order o where o.deliveryCity='Seattle'")
    //List<Order> readOrdersDeliveredInSeattle();

    List<Order> findByUserOrderByPlacedAtDesc(User user, Pageable pageable); /*pull all orders for current user
    and sort them by PlacedAt in descending order**/
}
