package ArbolPractica;

import java.util.Scanner;

public class Main {
    public static void main(String[] argumentos) {
        ArbolG<String> arbol = new ArbolG<>();

        arbol.insertar("Diego");
        arbol.insertar("Carlos");
        arbol.insertar("Keyla");
        arbol.insertar("Toledo");
        arbol.insertar("Larissa");

        int opc = 0;

        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        do {
            System.out.println("\n\nIngrese una opcion: \n" +
                    "1.- Agregar Dato.\n" +
                    "2.- Mostrar Arbol.\n" +
                    "3.- Buscar Dato.\n" +
                    "4.- Salir");

            opc = sc.nextInt();

            switch (opc){
                case 1 ->{
                    String dato;

                    System.out.println("\nIngrese dato: ");
                    dato = sc2.nextLine();

                    arbol.insertar(dato);
                }
                case 2 ->{
                    System.out.println("\nRecorriendo inorden: ");
                    arbol.inorden();

                    System.out.println("\nRecorriendo postorden: ");
                    arbol.postorden();

                    System.out.println("\nRecorriendo preorden: ");
                    arbol.preorden();
                }
                case 3 ->{
                    String dato;

                    System.out.println("\nIngrese dato a buscar: ");
                    dato = sc2.nextLine();

                    System.out.println("\nBusqueda: ");
                    if (arbol.existe(dato)) {
                        System.out.println("\n¡El dato existe!");
                    } else {
                        System.out.println("\n¡El dato NO existe!");
                    }
                }
                case 4 -> {
                    System.out.println("Adios...");
                }
            }
        }while(opc != 4);
    }
}