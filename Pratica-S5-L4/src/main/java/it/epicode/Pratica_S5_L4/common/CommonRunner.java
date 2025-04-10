package it.epicode.Pratica_S5_L4.common;

import it.epicode.Pratica_S5_L4.bevande.BevandaService;
import it.epicode.Pratica_S5_L4.menu.MenuService;
import it.epicode.Pratica_S5_L4.ordini.Ordine;
import it.epicode.Pratica_S5_L4.ordini.OrdineService;
import it.epicode.Pratica_S5_L4.pizze.PizzaService;
import it.epicode.Pratica_S5_L4.tavoli.TavoloService;
import it.epicode.Pratica_S5_L4.toppings.ToppingService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommonRunner {

    @Autowired
    private PizzaService pizzaService;
    @Autowired
    private BevandaService bevandaService;
    @Autowired
    private ToppingService toppingService;
    @Autowired
    private TavoloService tavoloService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private OrdineService ordineService;

    @Autowired
    private Ordine ordine;

    @Transactional
    public void run(String... args) throws Exception {
        pizzaService.createData();
        bevandaService.createData();
        toppingService.createData();
        tavoloService.createData();
        menuService.createData();
        ordineService.createData();

        ordine.stampaOrdine();
    }
}
