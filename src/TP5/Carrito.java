package TP5;

public class Carrito {
    public String nombre;
    public int precio;
    public int cantidad;
    public static final Double descuento = 0.8;

    public Carrito(String nombre, int precio, int cantidad) { // CONSTRUCTOR
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

}

class Cliente extends Carrito{
    String cliente;
        public Cliente (String nombre,  int precio, int cantidad, String cliente){
            super(nombre,precio,cantidad);
            this.cliente = cliente;
        }
}


class Main {
    public static void main(String[] args) {
        Carrito producto1 = new Carrito("Banana", 200, 1);
        Carrito producto2 = new Carrito("Lechuga", 100, 1);
        Carrito producto3 = new Carrito("Coca Cola", 500, 1);
        Cliente cliente1 = new Cliente("Manzana", 300, 3,"Alvaro");

        System.out.println(producto1.nombre);
        System.out.println(producto3.nombre);
        System.out.println(producto2.nombre);
        System.out.println(cliente1.cliente);

    }


}