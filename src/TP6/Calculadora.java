package TP6;
import java.util.Scanner;


public class Calculadora {
    public double nA;
    public String op;
    public double nB;
    public double resultado;

    public Calculadora(double nA, String op, double nB) {
        this.nA = nA;
        this.op = op;
        this.nB = nB;
    }


    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el primer numero, el signo de operacion y el segundo numero: ");
        Calculadora calculo = new Calculadora(
                teclado.nextDouble(),
                teclado.next(),
                teclado.nextDouble()
        );

        switch (calculo.op) {
            case "+" -> {
                calculo.resultado = calculo.nA + calculo.nB;
                System.out.println("El resultado es: " + calculo.resultado);
            }
            case "-" -> {
                calculo.resultado = calculo.nA - calculo.nB;
                System.out.println("El resultado es: " + calculo.resultado);
            }
            case "*" -> {
                calculo.resultado = calculo.nA * calculo.nB;
                System.out.println("El resultado es: " + calculo.resultado);
            }
            case "/" -> {
                calculo.resultado = calculo.nA / calculo.nB;
                System.out.println("El resultado es: " + calculo.resultado);
            }
            default -> System.out.println("ERROR, REINTENTE POR FAVOR");
        }
    }

}