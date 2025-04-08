package it.epicode.Pratica_S5_L2.ordini;


import it.epicode.Pratica_S5_L2.menu.Menu;
import it.epicode.Pratica_S5_L2.tavoli.StatoTavolo;
import it.epicode.Pratica_S5_L2.tavoli.Tavolo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.List;

@Component
public class OrdineRunner implements CommandLineRunner {

    @Autowired
    private Menu menu;

    @Value("${app.costo.coperto}")
    private double costoCoperto;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("costo coperto: " + costoCoperto);

        Tavolo tavolo = new Tavolo(2, 3);
        tavolo.setStato(StatoTavolo.OCCUPATO);

        Ordine ordine = new Ordine();
        ordine.setNumeroOrdine(1);
        ordine.setStatoOrdine(StatoOrdine.IN_CORSO);
        ordine.setCoperti(2);
        ordine.setOraOrdine(LocalTime.now());


        ordine.setElementi( List.of(
                menu.getPizze().get(0),
                menu.getPizze().get(1),
                menu.getBevande().get(0),
                menu.getBevande().get(1),
                menu.getToppings().get(3),
                menu.getToppings().get(4)

        ));
        ordine.setTavolo(tavolo);

   ordine.stampaOrdine(costoCoperto);


    }
}
