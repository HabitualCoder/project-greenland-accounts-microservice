package project.greenland.microservices.accounts.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.greenland.microservices.accounts.models.Coffee;
import project.greenland.microservices.accounts.repository.CoffeeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/coffees")
public class AccountsController {
   //private List<Coffee> coffees = new ArrayList<>();
   private final CoffeeRepository coffeeRepository;

   public AccountsController(CoffeeRepository coffeeRepository) {
      this.coffeeRepository=coffeeRepository;

      this.coffeeRepository.saveAll(List.of(
              new Coffee("Cafe Cereza"),
              new Coffee("Cafe Ganador"),
              new Coffee("Cafe Lareno"),
              new Coffee("Cafe Tres Pontas")
      ));
      /*coffees.addAll(List.of(
              new Coffee("Cafe Cereza"),
              new Coffee("Cafe Ganador"),
              new Coffee("Cafe Lareno"),
              new Coffee("Cafe Tres Pontas")
      ));*/
   }

   @GetMapping
   Iterable<Coffee> getCoffees() {
      //return coffees;
      return coffeeRepository.findAll();
   }

   @GetMapping("/{id}")
   Optional<Coffee> getCoffeeById(@PathVariable String id) {
      /*for(Coffee c:coffees) {
         if(c.getId().equals(id)) {
            return Optional.of(c);
         }
      }
      return Optional.empty();*/
      return coffeeRepository.findById(id);
   }

   @PostMapping
   Coffee postCoffee(@RequestBody Coffee coffee) {
      /*coffees.add(coffee);
      return coffee;*/
      return coffeeRepository.save(coffee);
   }

   @PutMapping("/{id}")
   ResponseEntity<Coffee> putCoffee(@PathVariable String id, @RequestBody Coffee coffee) {
      System.out.println("Id is: " + id);
      /*int coffeeIndex=-1;

      for(Coffee c:coffees) {
         if(c.getId().equals(id)) {
            coffeeIndex=coffees.indexOf(c);
            coffees.set(coffeeIndex, coffee);
         }
      }

      return (coffeeIndex==-1) ?
              new ResponseEntity<>(postCoffee(coffee), HttpStatus.CREATED) :
              new ResponseEntity<>(coffee, HttpStatus.OK);*/
      return (!coffeeRepository.existsById(id)) ?
              new ResponseEntity<>(coffeeRepository.save(coffee), HttpStatus.CREATED) :
              new ResponseEntity<>(coffeeRepository.save(coffee), HttpStatus.OK);
   }

   @DeleteMapping("/{id}")
   void deleteCoffee(@PathVariable String id) {
      System.out.println("Id is: " + id);
      //coffees.removeIf(c->c.getId().equals(id));
      coffeeRepository.deleteById(id);
   }
}
