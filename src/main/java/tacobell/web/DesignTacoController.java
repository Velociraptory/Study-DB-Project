package tacobell.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import tacobell.Ingredient;
import tacobell.Ingredient.Type;
import tacobell.Order;
import tacobell.Taco;
import tacobell.User;
import tacobell.data.IngredientRepository;
import tacobell.data.TacoRepository;
import tacobell.data.UserRepository;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j //логгер предоставленный lombok
@Controller
@RequestMapping("/design")
/** But unlike the Taco object in the session, you need the order to be present across multiple
 requests so that you can create multiple tacos and add them to the order.
 The class-level @SessionAttributes annotation specifies any model objects like
 the order attribute that should be kept in session and available across multiple requests
 (as i understood that: DesignTacoController and OrderController).*/
@SessionAttributes("order")
public class DesignTacoController {

    private final IngredientRepository ingredientRepo;

    private TacoRepository designRepo;

    private UserRepository userRepo;

    @Autowired
    public DesignTacoController(IngredientRepository ingredientRepo, TacoRepository designRepo, UserRepository userRepo) {
        //injecting repositories via annotated construction
        this.ingredientRepo = ingredientRepo;
        this.designRepo = designRepo;
        this.userRepo = userRepo;
    }

    /** As with the taco() method, the @ModelAttribute annotation on order() ensures
     that an Order object will be created in the model*/
    @ModelAttribute(name = "design")
    public Taco design() {
        return new Taco();
    }

    @ModelAttribute(name = "order")
    public Order order() {
        return new Order();
    }

    @GetMapping //здесь обрабатываем GET
    public String showDesignForm(Model model, Principal principal) { //инкапсуляция данных приложения с помощью модели
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepo.findAll().forEach(i -> ingredients.add(i)); //now we are have all ingredients from our ingredient repository

       /** List<Ingredient> ingredients = Arrays.asList( //hardcoded construct list of ingredients
                new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
                new Ingredient("COTO", "Corn Tortilla", Type.WRAP),
                new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
                new Ingredient("CARN", "Carnitas", Type.PROTEIN),
                new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES),
                new Ingredient("LETC", "Lettuce", Type.VEGGIES),
                new Ingredient("CHED", "Cheddar", Type.CHEESE),
                new Ingredient("JACK", "Monterrey Jack", Type.CHEESE),
                new Ingredient("SLSA", "Salsa", Type.SAUCE),
                new Ingredient("SRCR", "Sour Cream", Type.SAUCE)
        ); */
        Type[] types = Ingredient.Type.values();
        for (Type type : types) { //model construct (add list of ingredients for each type)
            model.addAttribute(type.toString().toLowerCase(), //формируем модель, где ключ это тип ингредиента
                    filterByType(ingredients, type)); //а значение список ингредиентов этого типа
        }

        model.addAttribute("design", new Taco()); //add designed taco to Model object

        String username = principal.getName();
        User user = userRepo.findByUsername(username);
        model.addAttribute("user", user);

        return "design"; //returning "design",
                        //which is the logical name of the view that will be used to
                        //render the model to the browser
    }
    private List<Ingredient> filterByType( //grouping ingredients by type
            List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

    @PostMapping //здесь обрабатываем POST
    /**@ModelAttribute is indicate that it's value should come from the model
    and that Spring MVC shouldn’t attempt to bind request parameters to it*/
    public String processDesign(@Valid @ModelAttribute ("design") Taco taco, Errors errors, @ModelAttribute Order order) {
        if (errors.hasErrors()) {
            return "design";
        }

        log.info("Processing design: " + taco);

        Taco saved = designRepo.save(taco); //save our designed taco to DB
        order.addDesign(saved); //It then adds the Taco object to the Order that’s kept in the session.

        return "redirect:/orders/current";
    }
}
