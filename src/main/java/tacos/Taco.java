package tacos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class Taco {

    @NotNull
    @Size(min = 5,message = "Name must be at least 5 characters long")
    private String name;

    @NotNull
    @Size(min = 1,message = "You mus choose at least 1 ingredient")
    private List<Ingredient> ingredients;
}
