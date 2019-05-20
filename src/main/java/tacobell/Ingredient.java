package tacobell;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
/**@RequiredArgsConstructor ensures that you’ll still have a
required arguments constructor in addition to the private no-arguments constructor*/
@RequiredArgsConstructor
//JPA requires that entities have a noarguments constructor, so Lombok’s @NoArgsConstructor does that
@NoArgsConstructor(access= AccessLevel.PRIVATE, force=true)
@Entity
public class Ingredient {
    @Id
    private final String id;
    private final String name;
    private final Type type;

    public static enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
