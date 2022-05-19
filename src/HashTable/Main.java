package HashTable;

import java.util.Scanner;
import java.util.Enumeration;
import java.util.Hashtable;

public class Main {
    static int i = 0;
    static Hashtable<String, Object> personal = new Hashtable<String, Object>();

    public static void main(String[] args) {
        int opc = 0;

        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        do {
            System.out.println("Ingrese una opcion: \n" +
                    "1.- Agregar Usuario\n" +
                    "2.- Mostrar Usuarios\n" +
                    "3.- Remplazar Usuario\n" +
                    "4.- Eliminar Usuario\n" +
                    "5.- Salir");

           opc = sc.nextInt();

           switch (opc){
               case 1 ->{
                   String nombre, direccion;
                   int edad;

                   System.out.println("Ingresa tu nombre: ");
                   nombre = sc2.nextLine();
                   System.out.println("Ingresa tu edad: ");
                   edad = sc.nextInt();

                   Persona persona = new Persona(nombre, edad);

                   personal.put((i+""), persona);
                   i++;
               }
               case 2 ->{
                   Enumeration nombres;
                   String id;

                   nombres = personal.keys();

                   String impresion = "\n\n+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n";

                   while (nombres.hasMoreElements()){
                       id = (String) nombres.nextElement();

                       impresion +="ID: " + id + "\n" + personal.get(id);
                       impresion += "\n+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n";
                   }
                   System.out.println(impresion);
               }
               case 3 ->{
                   String nombre;
                   int edad;

                   System.out.println("Ingrese el ID del personal a modificar: ");
                   String id = sc2.nextLine();
                   System.out.println("Ingresa tu nombre: ");
                   nombre = sc2.nextLine();
                   System.out.println("Ingresa tu edad: ");
                   edad = sc.nextInt();

                   Persona persona = new Persona(nombre, edad);

                   personal.replace(id, persona);
               }
               case 4 ->{
                   System.out.println("Ingrese el ID del personal a eliminar: ");
                   String id = sc.nextLine();
                   personal.remove(id);
               }
               case 5 -> {
                   System.out.println("Adios...");
               }
           }
        }while(opc != 5);
    }
}