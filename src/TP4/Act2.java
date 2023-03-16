package TP4;
import java.util.Scanner;
public class Act2 {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in); // linea para ejecutar el scanner

        System.out.println("Ingrese su nombre");
        String nombre = lectura.next();

        System.out.println("Ingrese su apellido");
        String apellido = lectura.next();

        System.out.println("Ingrese su edad");
        int edad = lectura.nextInt();

        System.out.println("Su nombre es " + nombre + " " + apellido +" y tiene " + edad + " años");

        if(edad<=18){
            System.out.println("Usted es menor de edad");
        }else {
            System.out.println("Usted es mayor de edad diviertase");
        }

    }
}