package it.epicode.Pratica_S5_L4.pizze;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;

    @Autowired
    private Faker faker;

    public void createData() {
        for (int i = 1; i <= 20; i++) {
            Pizza pizza = new Pizza();
            pizza.setNome("Pizza " + faker.food().dish());
            pizza.setDescrizione("Deliziosa " + faker.lorem().sentence());
            pizza.setPrezzo(faker.number().randomDouble(2, 5, 15));
            pizza.setCalorie(faker.number().numberBetween(700, 1200));
            // Per semplicità non vengono associati toppings
            pizzaRepository.save(pizza);
        }
    }

    // findAll
    public List<Pizza> findAll() {
        return pizzaRepository.findAll();
    }

}
