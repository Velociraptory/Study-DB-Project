package tacobell.data;

import org.springframework.data.repository.CrudRepository;
import tacobell.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
    //Spring JDBC
    //Order save(Order order);

    //Spring Data Jpa
    //List<Order> findByDeliveryZip(String deliveryZip);
    //List<Order> readOrdersByDeliveryZipAndPlacedAtBetween(String deliveryZip, Date startDate, Date endDate);
    //List<Order> findByDeliveryToAndDeliveryCityAllIgnoresCase(String deliveryTo, String deliveryCity);
    //List<Order> findByDeliveryCityOrderByDeliveryTo(String city);
}
