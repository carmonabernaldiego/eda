package Proyecto;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.TreeSet;
import javax.swing.*;

/*
    Lo que se va a trabajar es un sistema de registro de usuarios de una red social, donde el hashtable va a ser usado
    para guardar los datos de registros de nuestros usuarios de manera de que estos esten encriptados y usamos el arbol
    como empresa para ver de manera ordenada todos los registros que tenemos en la plataforma.

    El Hastable y el Arbol estan conectados, de modo que si un usuario se da de baja de la plataforma (hashtable) el arbol
    actualizaria esa informción, al igual que si un usuario se da de alta, o cambia su usuario o contraseña.

    PSEUDOCODIGO
    AGREGAR:
    En el arbol como en el hashtable esto es lo mas sencillo, registramos los datos y los agregamos por diferente en cada uno

    ELIMINAR:
    Esto sigue siendo sencillo

    REEMPLAZAR:
    En el hast, se busca lo que se quiere remplazar y se remplaza
    en el arbol se eliminar y se agrega uno nuevo

    BUSCAR:
    Es facil, solo que tenemos que procurar que se busque el formato que tenemos en el tostring del arbol




    Hashtable
    (*)agregar
    (*)eliminar
    (*)remplazar (tambien lo hace el arbol)


    Arbol
    (*)agregar
    (*)eliminar
    ()buscar


    LAS LLAVES DEL HASH SON DE CUATRO DIGITOS POR LO MENOS


    LAS TAREAS QUE FALTAN EN EL PROYECTO ES AGREGAR 45 USUARIOS DE MANERA LOCAL CON LA KEY

    AGREGAR USUARIOS DE 5 EN 5 AL MOSTRAR

 */
public class Main {

  //SE CREA EL HASH Y EL ARBOL
  static int iterador = 213456;
  static Hashtable<String, Object> hash = new Hashtable<>();
  static TreeSet<String> arbol = new TreeSet<>();

  public static void main(String[] args) {
    preCargarUsuarios();

    do {
      int opc = Integer.parseInt(
        JOptionPane.showInputDialog(
          "1.Registrar Cuenta\n2.Eliminar Cuenta\n3.Cambiar Detalles de Cuenta\n4.Buscar Registro\n5.Mostrar Arbol\n6.Mostrar Hash\n7.Salir"
        )
      );
      switch (opc) {
        case 1:
          agregar();
          break;
        case 2:
          eliminar();
          break;
        case 3:
          remplazar();
          break;
        case 4:
          buscar();
          break;
        case 5:
          mostrarArbol();
          break;
        case 6:
          mostrarHash();
          break;
        case 7:
          System.exit(0);
          break;
        default:
      }
    } while (true);
  }

  public static void buscar() {
    String id, elementoHashTable;

    //SE PIDEN LOS DATOS DEL USUARIO A BUSCAR
    id = JOptionPane.showInputDialog("Ingrese ID de Registro: ");

    if (hash.get(id) != null) {
      if(arbol.contains(hash.get(id) + "")) {
        elementoHashTable = hash.get(id).toString();

        Iterator<String> i = arbol.iterator();

        while (i.hasNext()) {
          String elementoTreeSet = i.next();
          if(elementoTreeSet.equals(elementoHashTable)) {
            JOptionPane.showMessageDialog(null, "¡Usuario Encontrado!\n\n" + elementoTreeSet);
          }
        }
      }else {
        JOptionPane.showMessageDialog(null, "¡Usuario No Encontrado!");
      }
    } else {
      JOptionPane.showMessageDialog(null, "¡Usuario No Encontrado!");
    }
  }
  
  public static void remplazar() {
    String nombre, contraseña, id;

    id = JOptionPane.showInputDialog("Ingrese ID de Registro: ");

    if (hash.get(id) != null) { //Si es diferente de nulo, se le piden los datos para reemplazar
      nombre = JOptionPane.showInputDialog("Ingresa su nuevo nombre: ");
      contraseña = JOptionPane.showInputDialog("Ingrese su nueva contraseña: ");

      Usuario crearUsuario = new Usuario(nombre, contraseña);
      arbol.remove(hash.get(id) + "");
      arbol.add(crearUsuario + "");
      //COMO EL ARBOL NO PUEDE REPLAZAR, SE BORRA Y SE AÑADE
      hash.replace(id, crearUsuario);
    } else { //caso contrario
      JOptionPane.showMessageDialog(null, "ID DE REGISTRO NO VALIDA");
    }
    //EN EL CASO DEL ARBOL SE ELIMINA Y SE VUELVE A AGREGAR, POR QUE NO SE PUEDE REMPLAZAR

  }

  public static void agregar() {
    String nombre, contraseña;
    //SE PIDEN LOS DATOS PARA CREAR EL USUARIO Y AGREGARLOS AL ARBOL Y AL HASH
    nombre = JOptionPane.showInputDialog("Ingresa su nombre: ");
    contraseña = JOptionPane.showInputDialog("Ingrese su contraseña: ");

    Usuario crearUsuario = new Usuario(nombre, contraseña);

    hash.put(iterador + "", crearUsuario);
    arbol.add(crearUsuario + "");

    JOptionPane.showMessageDialog(null, "SU ID DE REGISTRO ES: " + iterador);
    iterador++;
  }

  public static void eliminar() {
    String id;
    //SE PIDEN LOS DATOS DEL USUARIO A ELIMINAR
    id = JOptionPane.showInputDialog("Ingrese ID de Registro: ");
    if (hash.get(id) != null) {
      arbol.remove(hash.get(id) + "");
      hash.remove(id);
      JOptionPane.showMessageDialog(null, "Usuario Eliminado");
    } else {
      JOptionPane.showMessageDialog(null, "ID NO VALIDO");
    }
  }

  public static void mostrarArbol() {
    String impresion = "";
    Iterator<String> i = arbol.iterator();
    int contador = 1;
    while (i.hasNext()) {
      impresion += i.next() + "\n";
      impresion += "***********************************************\n";
      if (contador == 8) {
        JOptionPane.showMessageDialog(null, impresion);
        impresion = "";
        contador = 0;
      }
      contador++;
    }
    JOptionPane.showMessageDialog(null, impresion);
  }

  public static void mostrarHash() {
    Enumeration nombres;
    nombres = hash.keys();
    String IDRegistro;

    String impresion = "";

    int contador = 1;
    while (nombres.hasMoreElements()) {
      IDRegistro = (String) nombres.nextElement();
      impresion += "ID Registro: " + IDRegistro + "\n" + hash.get(IDRegistro);
      impresion += "\n*********************************\n";
      if (contador == 8) {
        JOptionPane.showMessageDialog(null, impresion);
        impresion = "";
        contador = 0;
      }
      contador++;
    }
    JOptionPane.showMessageDialog(null, impresion);
  }

  public static void preCargarUsuarios() {
    Usuario[] usuariosPreCargados = new Usuario[50];

    usuariosPreCargados[0] = new Usuario("IZIPMexicanito", "pepapig23");
    usuariosPreCargados[1] = new Usuario("MrChaidez", "Victor132");
    usuariosPreCargados[2] = new Usuario("SlayahYT", "ender123");
    usuariosPreCargados[3] = new Usuario("BlackGuezzy", "MaxMiranda324");
    usuariosPreCargados[4] = new Usuario("DestructorDelAmor", "love123");
    usuariosPreCargados[5] = new Usuario("OscarMoscar", "amogta3124");
    usuariosPreCargados[6] = new Usuario("XxHechizeroxX", "amoacarolina");
    usuariosPreCargados[7] = new Usuario("PokeCrack", "bulbasor32");
    usuariosPreCargados[8] = new Usuario("CBDx", "321herc");
    usuariosPreCargados[9] = new Usuario("ZEDNEM", "Hiram12345");
    usuariosPreCargados[10] = new Usuario("CaroZG", "amoacarolina");
    usuariosPreCargados[11] = new Usuario("JesusN$", "n8123fa5");
    usuariosPreCargados[12] = new Usuario("LunitaUwU", "karol21");
    usuariosPreCargados[13] = new Usuario("KeyxXx", "Lorena04");
    usuariosPreCargados[14] = new Usuario("UPLover", "politecnicaLaMejor");
    usuariosPreCargados[15] = new Usuario("SprayingDruid06", "xaScfR 12");
    usuariosPreCargados[16] = new Usuario("Mara04", "kmws020304");
    usuariosPreCargados[17] = new Usuario("KGFk", "kalcio23");
    usuariosPreCargados[18] = new Usuario("XxCGERxX", "canicas04");
    usuariosPreCargados[19] = new Usuario("Nick", "1234");
    usuariosPreCargados[20] = new Usuario("Kraken", "2345dfsw");
    usuariosPreCargados[21] = new Usuario("Bowser", "mariomelarosa23");
    usuariosPreCargados[22] = new Usuario("PowerRangerRojo", "elblancoesmejor03");
    usuariosPreCargados[23] = new Usuario("Tiger", "sains23");
    usuariosPreCargados[24] = new Usuario("Creepy", "dedomochon23");
    usuariosPreCargados[25] = new Usuario("Sasquatch", "rickymorty");
    usuariosPreCargados[26] = new Usuario("SlayerPro", "demon23");
    usuariosPreCargados[27] = new Usuario("Rick", "wuabalabadu");
    usuariosPreCargados[28] = new Usuario("Morty", "jesicateamo12");
    usuariosPreCargados[29] = new Usuario("SteelShoot", "disparando23");
    usuariosPreCargados[30] = new Usuario("Indominus", "23");
    usuariosPreCargados[31] = new Usuario("Ironelad", "payaso23");
    usuariosPreCargados[32] = new Usuario("LectorRaider", "2351ker");
    usuariosPreCargados[33] = new Usuario("Fire-Bred", "panintegral23");
    usuariosPreCargados[34] = new Usuario("MrMendez", "ds2elmejor");
    usuariosPreCargados[35] = new Usuario("RuedaDS", "ds2thebest");
    usuariosPreCargados[36] = new Usuario("FarreraXx", "olijuwu");
    usuariosPreCargados[37] = new Usuario("Sophia", "olakace23");
    usuariosPreCargados[38] = new Usuario("BadBunny", "conejomalo");
    usuariosPreCargados[39] = new Usuario("Blitz", "ajg132");
    usuariosPreCargados[40] = new Usuario("Zarmander", "webos034");
    usuariosPreCargados[41] = new Usuario("Amigdala", "faringitis64");
    usuariosPreCargados[42] = new Usuario("Becerron", "olakase02");
    usuariosPreCargados[43] = new Usuario("ChaidezRed", "webosrevbueltos023");
    usuariosPreCargados[44] = new Usuario("Danixs", "fOc0sw");
    usuariosPreCargados[45] = new Usuario("Ernend", "Legolas23");
    usuariosPreCargados[46] = new Usuario("FocaLoca", "imerazy23");
    usuariosPreCargados[47] = new Usuario("Gerardox", "gfa2sdw");
    usuariosPreCargados[48] = new Usuario("Hiraaam", "hiram12345");
    usuariosPreCargados[49] = new Usuario("IphoneRobado", "ayudanecesitomoney2");

    for (int i = 0; i < 50; i++) {
      arbol.add(usuariosPreCargados[i] + "");
      hash.put(iterador + "", usuariosPreCargados[i]);
      iterador++;
    }
  }
}