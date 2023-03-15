package TP3;

public class Act5 {
    public static void main(String[] args) {
        String cursos[]={"Programacion", "Logica","Ingles"};
        int notas[]={10,7,8};

        System.out.println("Promedio de Cursos");
        System.out.println("CURSO   NOTA");
        System.out.println("------   ----- ");

        int promedio=(notas[0]+notas[1]+notas[2])/3;

        for (int s=0;s<cursos.length;s++){
            System.out.println(cursos[s] + " "+notas[s]);
        }
        System.out.println("Su Promedio es : " + promedio);
    }
}
