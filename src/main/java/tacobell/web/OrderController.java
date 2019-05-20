package tacobell.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import tacobell.Order;
import tacobell.User;
import tacobell.data.OrderRepository;

import javax.validation.Valid;

@Slf4j //логгер предоставленный lombok
@Controller
@RequestMapping("/orders")
@SessionAttributes("order")
public class OrderController {

    private OrderRepository orderRepo;

    @Autowired
    public OrderController(OrderRepository orderRepo) {
        //injecting repository via annotated construction
        this.orderRepo = orderRepo;
    }

    @GetMapping("/current")
    public String orderForm(@AuthenticationPrincipal User user,
                            @ModelAttribute Order order) {
         if (order.getName() == null) {
            order.setName(user.getFullname());
        }
        if (order.getStreet() == null) {
            order.setStreet(user.getStreet());
        }
        if (order.getCity() == null) {
            order.setCity(user.getCity());
        }
        if (order.getState() == null) {
            order.setState(user.getState());
        }
        if (order.getZip() == null) {
            order.setZip(user.getZip());
        }

        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid Order order, Errors errors, SessionStatus sessionStatus, @AuthenticationPrincipal User user) {
        if (errors.hasErrors()) {
            return "orderForm";
        }

        order.setUser(user);

        orderRepo.save(order); //save submitted Order object on the injected OrderRepository
        sessionStatus.setComplete(); //reset the session with current order

        log.info("Order submitted: " + order);
        return "redirect:/";
    }
}
