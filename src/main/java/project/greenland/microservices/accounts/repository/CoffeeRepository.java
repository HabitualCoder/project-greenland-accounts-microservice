package project.greenland.microservices.accounts.repository;

import org.springframework.data.repository.CrudRepository;
import project.greenland.microservices.accounts.models.Coffee;

public interface CoffeeRepository extends CrudRepository<Coffee, String> {
}
