package tacos.service;

import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tacos.Ingredient;
import tacos.data.IngredientRepository;
import tacos.data.TacoCrudRepository;

import java.util.List;

@Slf4j
@Service
@Transactional
public class RestApi {
    @Resource
    private IngredientRepository repo;
    private TacoCrudRepository tacoCrudRepository;
    private RestTemplate rest;


    public void addB() {
        List<Ingredient> ingredients = List.of(
                new Ingredient(null, "Flour Tortilla", Ingredient.Type.valueOf("WRAP")),

                new Ingredient(null, "Corn Tortilla", Ingredient.Type.WRAP),

                new Ingredient(null, "Ground Beef", Ingredient.Type.PROTEIN),

                new Ingredient(null, "Carnitas", Ingredient.Type.PROTEIN),

                new Ingredient(null, "Diced Tomatoes", Ingredient.Type.VEGGIES),

                new Ingredient(null, "lettuce", Ingredient.Type.VEGGIES),

                new Ingredient(null, "Cheddar", Ingredient.Type.CHEESE),

                new Ingredient(null, "Monterrey Jack", Ingredient.Type.CHEESE),

                new Ingredient(null, "Salsa", Ingredient.Type.SAUCE),

                new Ingredient(null, "Sour Cream", Ingredient.Type.SAUCE));
        repo.saveAll(ingredients);

/*        public void addBTaco() {
            Taco taco1 = new Taco();
            taco1.setName("Carnivore");
            taco1.setIngredients(Arrays.asList(flourTortilla, groundBeef, carnitas,
                    sourCream, salsa, cheddar));
            tacoCrudRepository.save(taco1);


            Taco taco2 = new Taco();
            taco2.setName("Bovine Bounty");
            taco2.setIngredients(Arrays.asList(
                    cornTortilla, groundBeef, cheddar,
                    jack, sourCream));
            tacoCrudRepository.save(taco2);

            Taco taco3 = new Taco();
            taco3.setName("Veg-Out");
            taco3.setIngredients(Arrays.asList(flourTortilla, cornTortilla, tomatoes,
                    lettuce, salsa));
            tacoCrudRepository.save(taco3);
        }

    }

    ;*/

    }
    public Ingredient createIngredient(Ingredient ingredient) {
        ResponseEntity<Ingredient> responseEntity =
                rest.postForEntity("http://localhost:8080/ingredients",
                        ingredient,
                        Ingredient.class);
        log.info("New resource created at {}",
                responseEntity.getHeaders().getLocation());
        return responseEntity.getBody();
    }
}