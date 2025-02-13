package tacos.data;

import org.springframework.data.repository.CrudRepository;
import tacos.Taco;

public interface TacoCrudRepository extends CrudRepository<Taco,Long> {
}
