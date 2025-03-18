package it.epicode.Esercizio1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Set<Integer> set = new HashSet<Integer>();

        // chiedo all'utente di inserire il numero di elementi da inserire
        int N = new Scanner(System.in).nextInt();
        for (int i = 0; i < N; i++) {
            set.add(new Scanner(System.in).nextInt());
        }
    }
}
