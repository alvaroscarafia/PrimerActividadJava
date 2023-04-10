package TP5;
import java.util.Scanner;

class Producto {
    String nombreP;
    int cantidad;
    double precioUnitario;

    public Producto(String nombreP, int cantidad, double precioUnitario){
        this.nombreP = nombreP;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }
}

class itemCarrito extends Producto{
    double precioTotalP;

    public itemCarrito(String nombreP, int cantidad, double precioUnitario, double precioTotalP){

        super(nombreP, cantidad, precioUnitario);
        this.precioTotalP = precioTotalP;
    }

    public double metodoSumaTotal(){
        precioTotalP = precioUnitario * cantidad;
        return precioTotalP;
    }
}

class Descuento extends itemCarrito {
    double desc;

    public Descuento(String nombreP, int cantidad, double precioUnitario, double precioTotalP, double desc){
        super(nombreP, cantidad, precioUnitario, precioTotalP);
        this.desc = desc;
    }

}

public class Carrito {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese producto, cantidad y precio por unidad");
        Producto compra = new Producto(
                teclado.next(),
                teclado.nextInt(),
                teclado.nextInt()
        );
        itemCarrito itemc1 = new itemCarrito(
                compra.nombreP,
                compra.cantidad,
                compra.precioUnitario,
                compra.cantidad*compra.precioUnitario
        );
        System.out.println("Precio sin descuento: " + itemc1.precioTotalP);

        if(itemc1.precioTotalP>1000){
            Descuento compraDesc = new Descuento(
                    itemc1.nombreP,
                    itemc1.cantidad,
                    itemc1.precioUnitario,
                    itemc1.precioTotalP,
                    itemc1.precioTotalP - (itemc1.precioTotalP * 0.10)
            );
            double total = compraDesc.desc;
            System.out.println("Total: "+ total);
        }else{
            System.out.println("No hay descuento porque no supera los $1000");
        }
    }
}