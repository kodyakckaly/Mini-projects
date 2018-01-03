/* ALGORITMO EXTENDIDO DE EUCLIDES DESARROLLADO EN RSA. */
// (MCD & Coeficientes de combinación lineal)
package aee;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author Diana Chavez @kodyakckaly
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GeneraClaves gc = new GeneraClaves();
        BigInteger[] textoCifrado;

        System.out.print("Introduzca el tamaño de claves: ");
        int tamaño = sc.nextInt();
        gc.tamPrimo = tamaño;
        gc.generarClaves(tamaño);
        System.out.println("Mensaje a criptar: ");
        String mensaje = sc.next();
        textoCifrado = gc.encripta(mensaje);

        for (int i = 0; i < textoCifrado.length; i++) {
            System.out.println("" + textoCifrado[i].toString());
        }

        String recuperarTexto = gc.desencripta(textoCifrado);
        System.out.println("\nDescifrando ... " + recuperarTexto);
    }
}
