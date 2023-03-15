package TP3;
public class Act4 {
    public static void main(String[] args) {

        String productos[] = {"Remera", "Medias", "Short", "Ojotas", "Pelota","Campera"};
        double precios[] = {20000.99, 3250.50, 12000.50, 10000.99, 10500.25,33000.99};

        System.out.println("Lista de Productos y sus precios");

        for (int n = 0; n < productos.length; n++) {
            System.out.println("Articulo " + productos[n] + " Precio: $" + precios[n]);
        }
    }
}