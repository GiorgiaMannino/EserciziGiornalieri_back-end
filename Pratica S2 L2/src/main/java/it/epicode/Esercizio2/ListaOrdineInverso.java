package it.epicode.Esercizio2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListaOrdineInverso {

    //funzione che crea una nuova lista con gli elementi originali seguiti dagli stessi in ordine inverso
    public static List<Integer> duplicaEInversa(List<Integer> lista) {
        List<Integer> nuovaLista = new ArrayList<>(lista);
        List<Integer> inversa = new ArrayList<>(lista);
        Collections.reverse(inversa);
        nuovaLista.addAll(inversa);
        return nuovaLista;
    }
}
