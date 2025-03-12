package it.epicode.Esercizio1;

public class StampeRettangolo {
    public static void stampa (Rettangolo rettangolo)
    {
        System.out.println("Area rettangolo" + rettangolo.area());
        System.out.println("Perimetro rettangolo" + rettangolo.perimetro());

    }
    public static void  stampaDueRettangoli (Rettangolo rettangolo1, Rettangolo rettangolo2) {
        System.out.println("Area rettangolo 1" + rettangolo1.area());
        System.out.println("Perimetro rettangolo 1" + rettangolo1.perimetro());
        System.out.println("Area rettangolo 2" + rettangolo2.area());
        System.out.println("Perimetro rettangolo 2" + rettangolo2.perimetro());
        System.out.println("Somma Aree rettangoli: " + (rettangolo1.area() + rettangolo2.area()));
        System.out.println("Somma Perimetri rettangoli: " + (rettangolo1.perimetro() + rettangolo2.perimetro()));

    }

}
