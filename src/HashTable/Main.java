package HashTable;

import java.util.Scanner;
import java.util.Enumeration;
import java.util.Hashtable;

public class Main {
    static int iterador = 0;
    static Hashtable<String, Object> usuarios=new Hashtable<String, Object>();

    public static void agregarUsuario( ){
        String nombre,direccion;
        int edad;
        nombre = JOptionPane.showInputDialog("Ingresa tu nombre: ");
        edad = Integer.parseInt( JOptionPane.showInputDialog("Ingresa tu edad: ") );
        direccion = JOptionPane.showInputDialog("Ingresa tu dirección: ");

        Persona crearUsuario = new Persona(nombre,edad,direccion);
        usuarios.put( (iterador+""), crearUsuario );
        iterador++;

    }

    public static void mostrarUsuarios( ){
        Enumeration nombres;
        nombres = usuarios.keys();
        String clave;

        String impresion ="*********************************\n";
        while (nombres.hasMoreElements()){
            clave = (String) nombres.nextElement();
            impresion +="Clave: "+clave + "\n" + usuarios.get(clave);
            impresion += "\n*********************************\n";
        }
        JOptionPane.showMessageDialog(null,impresion);
    }

    public static void reemplazarUsuario(){
        String key = JOptionPane.showInputDialog("Ingrese la clave de la persona a modificar: ");

        String nombre,direccion;
        int edad;
        nombre = JOptionPane.showInputDialog("Ingresa tu nombre: ");
        edad = Integer.parseInt( JOptionPane.showInputDialog("Ingresa tu edad: ") );
        direccion = JOptionPane.showInputDialog("Ingresa tu dirección: ");

        Persona crearUsuario = new Persona(nombre,edad,direccion);

        usuarios.replace(key,crearUsuario);


    }

    public static void eliminarUsuario(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la clave de la persona a eliminar: ");
        String key = sc.nextLine();
        usuarios.remove(key);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Ingrese la opción deseada: \n" +
                    "1. Agregar Usuario\n" +
                    "2. Mostrar Usuarios\n" +
                    "3. Remplazar Usuario\n" +
                    "4. Eliminar Usuario");
           int opc = sc.nextInt();

           switch (opc){
               case 1 ->{
                   agregarUsuario( );
               }
               case 2 ->{
                   mostrarUsuarios();
               }
               case 3 ->{
                   reemplazarUsuario();
               }
               case 4 ->{
                   eliminarUsuario();
               }
           }
        }while( true );
    }
}