package tacos.web;

import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tacos.service.RestApi;

@RestController
@RequestMapping("/addIngredients")
public class IngredientAppController {
    @Resource
    private RestApi restApi;

    @GetMapping("/add")
    public ResponseEntity<String> addB(){
        restApi.addB();
        return ResponseEntity.ok("Добавлено");
    }
}
