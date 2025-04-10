package it.epicode.Pratica_S5_L4.tavoli;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TavoloService {

    @Autowired
    private TavoloRepository tavoloRepository;
    @Autowired
    private Faker faker;

    public void createData() {
        for (int i = 1; i <= 20; i++) {
            Tavolo t = new Tavolo();
            t.setNumeroTavolo(i);
            t.setNumeroCopertiMax(4);
            t.setStato(StatoTavolo.LIBERO);
            tavoloRepository.save(t);
        }
    }

    public List<Tavolo> findAll() {
        return tavoloRepository.findAll();
    }
}