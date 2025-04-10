package it.epicode.Pratica_S5_L4.bevande;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BevandaService {
    @Autowired
    private BevandaRepository bevandaRepository;

    @Autowired
    private Faker faker;

    public void createData() {
        for (int i = 1; i <= 20; i++) {
            Bevanda b = new Bevanda();
            b.setNome("Bevanda " + faker.food().ingredient());
            b.setDescrizione("Bibita " + faker.lorem().sentence());
            b.setPrezzo(faker.number().randomDouble(2, 1, 5));
            b.setCalorie(faker.number().numberBetween(50, 200));
            bevandaRepository.save(b);
        }
    }

    public List<Bevanda> findAll() {
        return bevandaRepository.findAll();
    }
}