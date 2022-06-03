package ArbolBinario;

public class Main {

  /**
   * @param args the command line arguments
   */
  //public static nodo valor;
  public static void main(String[] args) {
    java.util.Scanner leer = new java.util.Scanner(System.in);
    arbol x = new arbol();
    int z;
    System.out.print("Ingrese el numero de Datos a capturar: ");
    z = leer.nextInt();
    for (int i = 1; i <= z; i++) {
      int m, e;
      System.out.println("Ingrese Dato " + i + ": ");
      m = leer.nextInt();
      System.out.println("Ingrese Edad " + i + ": ");
      e = leer.nextInt();
      x.alta(m, e);
    }
    System.out.println("Valores Capturados en PreOrden:");
    x.imprimirpreorden();
    System.out.println("Valores en InOrden:");
    x.imI();
    int q;
    System.out.print("\nIngrese dato a borrar: ");
    q = leer.nextInt();
    x.baja(q);
    System.out.println("\nDespues de borrar el dato " + q + " :");
    x.imI();
    //x.imprimirpreorden();
  }
}