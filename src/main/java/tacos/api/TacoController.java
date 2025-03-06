package tacos.api;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tacos.Taco;
import tacos.data.TacoCrudRepository;
import tacos.data.TacoRepository;

import java.util.Optional;

@RestController    //Эта анотация показывает что надо returns всех методов включать в тело ответа
@RequestMapping(path = "/api/tacos",
        produces = "application/json")
@CrossOrigin(origins = "http://tacocloud:8080")
public class TacoController {

    final private TacoRepository tacoRepo;
    final private TacoCrudRepository tacoCrudRepository;

    public TacoController(TacoRepository tacoRepo,TacoCrudRepository tacoCrudRepository) {
        this.tacoRepo = tacoRepo;
        this.tacoCrudRepository = tacoCrudRepository;
    }

    @GetMapping(params = "recent")
    public Iterable<Taco> recentTacos() {
        PageRequest page = PageRequest.of(
                0, 12, Sort.by("createdAt").descending());
        return tacoRepo.findAll(page).getContent();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Taco> tacoById(@PathVariable("id")Long id){
        Optional<Taco> optTaco = tacoCrudRepository.findById(id);
        if(optTaco.isPresent()){
            return new ResponseEntity<>(optTaco.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Taco postTaco(@RequestBody Taco taco){
        return tacoCrudRepository.save(taco);
    }
}
