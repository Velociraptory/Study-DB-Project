package tacobell.data;

import tacobell.Order;

public interface OrderRepository {
    Order save(Order order);
}
