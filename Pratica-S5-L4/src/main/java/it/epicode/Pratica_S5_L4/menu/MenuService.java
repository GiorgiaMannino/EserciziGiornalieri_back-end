package it.epicode.Pratica_S5_L4.menu;

import it.epicode.Pratica_S5_L4.bevande.Bevanda;
import it.epicode.Pratica_S5_L4.bevande.BevandaService;
import it.epicode.Pratica_S5_L4.pizze.Pizza;
import it.epicode.Pratica_S5_L4.pizze.PizzaService;
import it.epicode.Pratica_S5_L4.toppings.Topping;
import it.epicode.Pratica_S5_L4.toppings.ToppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class MenuService {
    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private PizzaService pizzaService;
    @Autowired
    private BevandaService bevandaService;
    @Autowired
    private ToppingService toppingService;

    public void createData() {
        Set<ElementoMenu> elementi = new HashSet<>();
        for (Pizza p : pizzaService.findAll()) {
            elementi.add(p);
        }
        for (Bevanda b : bevandaService.findAll()) {
            elementi.add(b);
        }
        for (Topping t : toppingService.findAll()) {
            elementi.add(t);
        }
        Menu m = new Menu();
        m.setNome("Menu Speciale");
        m.setDescrizione("Il nostro menu speciale");
        m.setElementi(elementi);
        menuRepository.save(m);
    }

    public Menu getMenu() {
        return menuRepository.findAll().get(0);
    }
}