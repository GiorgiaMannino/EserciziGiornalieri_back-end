package it.epicode.cicli;

public class Esercizio_1 {

    //STRINGA PARI O DISPARI
    public static void main(String[] args) {
        // STRINGA PARI O DISPARI
        String stringa = "Ciao";
        if (stringa.length() % 2 == 0) {
            System.out.println("La stringa è pari");
        } else {
            System.out.println("La stringa è dispari");
        }


        // ANNO BISESTILE
        int anno = 2023;
        if (anno % 4 == 0 && (anno % 100 != 0 || anno % 400 == 0)) {
            System.out.println("L'anno è bisestile");
        } else {
            System.out.println("L'anno non è bisestile");
        }
    }
}