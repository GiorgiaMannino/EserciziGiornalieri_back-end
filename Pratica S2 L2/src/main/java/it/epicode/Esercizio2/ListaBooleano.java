package it.epicode.Esercizio2;

import java.util.List;

public class ListaBooleano {

    public static void stampaParioDispari(List<Integer> lista, boolean b) {
        System.out.println(b ? "Valori in posizioni pari:" : "Valori in posizioni dispari:");

        for (int i = 0; i < lista.size(); i++) {
            if ((b && i % 2 == 0) || (!b && i % 2 != 0)) {
                System.out.print(lista.get(i) + " ");
            }
        }
        System.out.println();
    }
}
