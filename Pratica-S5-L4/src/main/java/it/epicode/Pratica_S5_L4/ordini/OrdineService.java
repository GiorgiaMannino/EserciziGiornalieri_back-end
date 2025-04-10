package it.epicode.Pratica_S5_L4.ordini;


import it.epicode.Pratica_S5_L4.menu.ElementoMenu;
import it.epicode.Pratica_S5_L4.menu.Menu;
import it.epicode.Pratica_S5_L4.menu.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrdineService {

    @Autowired
    private OrdineRepository ordineRepository;

    @Autowired
    private MenuService menuService;

    public void createData() {
        // Crea un ordine utilizzando il menu creato
        Menu menu = menuService.getMenu();
        Ordine ordine = new Ordine();
        int coperti = 2;
        ordine.setCoperti(coperti);
        List<ElementoMenu> elementiOrdinati = new ArrayList<>();
        // Per ogni coperto aggiungiamo tutti gli elementi del menu
        for (int i = 0; i < coperti; i++) {
            for (ElementoMenu em : menu.getElementi()) {
                elementiOrdinati.add(em);
            }
        }
        ordine.setElementi(elementiOrdinati);
        // Il tavolo può essere impostato se creato (per semplicità omesso qui)
        ordineRepository.save(ordine);

        // Stampa l'ordine tramite il metodo definito nell'entity
        ordine.stampaOrdine();
    }

    public List<Ordine> findAll() {
        return ordineRepository.findAll();
    }


}
