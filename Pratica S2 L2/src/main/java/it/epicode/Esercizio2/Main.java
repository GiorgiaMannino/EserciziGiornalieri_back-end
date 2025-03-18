package it.epicode.Esercizio2;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // LISTA NUMERI CASUALI -  Chiede all'utente di inserire il valore di N

        System.out.print("Inserisci il numero di elementi N: ");
        int N = scanner.nextInt();

        // Genera la lista di numeri casuali
        List<Integer> lista = ListaNumeriCasuali.generaListaCasuale(N);
        System.out.println("Lista ordinata di " + N + " numeri casuali: " + lista);

        //  LISTA ORDINE INVERSO - Crea la lista con gli elementi seguiti dagli stessi in ordine inverso

        List<Integer> lista2 = ListaOrdineInverso.duplicaEInversa(lista);
        System.out.println("Lista originale + inversa: " + lista2);
        scanner.close();


        //  LISTA BOOLEANO - Creo una lista

        List<Integer> listaParioDispari = Arrays.asList(3, 7, 12, 25, 36, 48, 52, 67, 72, 89);
        System.out.println("Lista completa con posizioni sia pari che dispari: " + listaParioDispari);
        // Stampa numeri in posizioni pari
        ListaBooleano.stampaParioDispari(listaParioDispari, true);
        // Stampa numeri in posizioni dispari
        ListaBooleano.stampaParioDispari(listaParioDispari, false);
    }
}
