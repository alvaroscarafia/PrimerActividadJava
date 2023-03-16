package TP4;
import java.util.Scanner;
public class Act1 {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);

        System.out.println("Ingrese su nombre");
            String nombre = lectura.next();
        System.out.println("Ingrese su apellido");
            String apellido = lectura.next();
        System.out.println("Ingrese su edad");
            int edad = lectura.nextInt();

        System.out.println("Su nombre completo es: " + nombre + " " + apellido);
        System.out.println("Tiene " + edad + " años");
    }
}
