package TP6;
import java.util.Scanner;
import java.util.InputMismatchException;

public class CuadradoNumero {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int num;
        boolean continua;

        do {

            try {
                continua = false;
                System.out.println("Ingrese un numero entrero: ");
                num = entrada.nextInt();
                int cuadrado = num * num;
                System.out.println("El resultado es: " + cuadrado);
            } catch (InputMismatchException ex) {
                System.out.println("Debe ingresar un valor entero... PORFAVOR");
                entrada.next();
                continua = true;
            }

        } while (continua);

    }
}
