package it.epicode.Pratica_S5_L4.toppings;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToppingService {
    @Autowired
    private ToppingRepository toppingRepository;
    @Autowired
    private Faker faker;

    public void createData() {
        for (int i = 1; i <= 20; i++) {
            Topping t = new Topping();
            t.setNome("Topping " + faker.food().ingredient());
            t.setDescrizione("Extra " + faker.lorem().sentence());
            t.setPrezzo(faker.number().randomDouble(2, 0, 3));
            t.setCalorie(faker.number().numberBetween(10, 100));
            toppingRepository.save(t);
        }
    }

    public List<Topping> findAll() {
        return toppingRepository.findAll();
    }
}