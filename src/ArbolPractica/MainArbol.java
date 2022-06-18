package ArbolPractica;

import java.util.Scanner;

public class Main {
    public static void main(String[] argumentos) {
        Arbol arbol = new Arbol();

        arbol.insertar(50);
        arbol.insertar(12);
        arbol.insertar(8);
        arbol.insertar(45);
        arbol.insertar(34);
        arbol.insertar(78);
        arbol.insertar(89);

        int opc = 0;

        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        do {
            System.out.println("\n\nIngrese una opcion: \n" +
                    "1.- Agregar Dato.\n" +
                    "2.- Mostrar Arbol.\n" +
                    "3.- Buscar Dato.\n" +
                    "4.- Eliminar Dato.\n" +
                    "5.- Salir");

            opc = sc.nextInt();

            switch (opc){
                case 1 ->{
                    int dato;

                    System.out.println("\nIngrese dato: ");
                    dato = sc2.nextInt();

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
                    int dato;

                    System.out.println("\nIngrese dato a buscar: ");
                    dato = sc2.nextInt();

                    System.out.println("\nBusqueda: ");
                    if (arbol.existe(dato)) {
                        System.out.println("\n¡El dato existe!");
                    } else {
                        System.out.println("\n¡El dato NO existe!");
                    }
                }
                case 4 -> {
                    int dato;

                    System.out.println("\nIngrese dato a eliminar: ");
                    dato = sc2.nextInt();

                    if (arbol.existe(dato)) {
                        System.out.println("\nEliminar: ");
                        arbol.eliminar(dato);
                    } else {
                        System.out.println("\n¡El dato NO existe!");
                    }
                }
                case 5 -> {
                    System.out.println("Adios...");
                }
            }
        }while(opc != 5);
    }
}