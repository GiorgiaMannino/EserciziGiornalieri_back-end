package it.epicode.Esercizio2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListaNumeriCasuali {

    // funzione che genera una lista ordinata di N numeri casuali da 0 a 100
    public static List<Integer> generaListaCasuale(int N) {
        List<Integer> lista = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            lista.add((int) (Math.random() * 101)); // numeri casuali tra 0 e 100
        }
        Collections.sort(lista);
        return lista;
    }
}
