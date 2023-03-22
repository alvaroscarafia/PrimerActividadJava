package TP4;
import java.util.Scanner;

public class compras {
    Scanner dato = new Scanner(System.in);
    public void compraproducto(){

        String nproducto = "";
        double precio, total;
        double totalpagar = 0;
        int cantidad;

        System.out.println("Ingreso el nombre del producto");
        nproducto= dato.next();

        System.out.println("Ingreso el precio del producto");
        precio = dato.nextDouble();

        System.out.println("Ingreso la cantidad");
        cantidad =dato.nextInt();

        total = precio * cantidad;
        System.out.println("El total es : " + total);

        if(total > 1000){
            System.out.println("El descuento es ; "+ total*0.20);
            totalpagar = total - (total*0.20);
            System.out.println("El neto a pagar es : "+totalpagar);
        }else{
            System.out.println("No hay descuentos");
        }
    }
    public void seccion ( ) {

        String cliente;
        System.out.println("Ingreso el nombre del cliente");
        cliente = dato.next();

        System.out.println("Ingrese el nombre de la sección de productos: ");
        String opcion ="";

        System.out.println("Frutas");
        System.out.println("Verduras");
        System.out.println("Gaseosas");

        opcion = dato.next();
        switch(opcion) {
            case "Frutas":  compraproducto();  break;
            case "Verduras":  compraproducto();  break;
            case "Gaseosas":  compraproducto();  break;
        }
    }
    public static void main (String []args){
        compras cp = new compras();
        cp.seccion();
    }
}