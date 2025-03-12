package it.epicode.Esercizio1;


public class Main {
    public static void main(String[] args) {
        Rettangolo rettangolo = new Rettangolo(10, 20);
        Rettangolo rettangolo1 = new Rettangolo(20, 30);
        Rettangolo rettangolo2 = new Rettangolo(15, 35);

        StampeRettangolo.stampa(rettangolo);
        StampeRettangolo.stampa(rettangolo1);
        StampeRettangolo.stampa(rettangolo2);

        StampeRettangolo.stampaDueRettangoli(rettangolo1, rettangolo2);
    }

}