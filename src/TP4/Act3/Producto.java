package TP4.Act3;

public class Producto { //CLASE PRODUCTO
    private String nombre;
    private int precio;
    private int cantidad;
    private static final Double descuento = 0.8;

    public Producto(String nombreP,int precio){ // CONSTRUCTOR
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;

        Producto prod1 = new Producto("Banana", 200);
    }

    //METODOS
    public String getNombre() {
        return this.nombre;
    }
    public int getPrecio(){
        return this.precio;
    }

}
