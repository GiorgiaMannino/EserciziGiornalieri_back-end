package it.epicode.Esercizio1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rettangolo {
private double altezza;
private double larghezza;
public double perimetro  ( ) {
    return ((larghezza + altezza) * 2);
}

public  double area () {
    return (larghezza * altezza);
}
}
