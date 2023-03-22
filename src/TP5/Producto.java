package TP5;

class Producto { //CLASE PRODUCTO
    private String nombre;
    private int precio;
    private int cantidad;
    private static final Double descuento = 0.8;

    public Producto(String nombre,int precio, int cantidad){ // CONSTRUCTOR
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    //METODOS
    public String getNombre() {
        return this.nombre;
    }
    public int getPrecio(){
        return this.precio;
    }

    private static void main(String[] args) {
        Producto producto1 = new Producto("Banana", 200, 1);
        Producto producto2 = new Producto("Lechuga", 100, 1);
        Producto producto3 = new Producto("Coca Cola", 500, 1);

        producto1.getNombre();
    }
}





