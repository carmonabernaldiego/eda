package ArbolBinario;

class nodo {

  int dato; //key o llave
  int edad;
  nodo der;
  nodo izq;

  nodo(int dat, int ed) {
    this.dato = dat;
    this.edad = ed;
    this.der = null;
    this.izq = null;
  }
}

public class arbol {

  nodo raiz = null;

  public boolean tieneraiz() {
    if (raiz == null) return false; else return true;
  }

  public arbol alta(int dat, int ed) {
    if (!tieneraiz()) {
      nodo nuevo = new nodo(dat, ed);
      raiz = nuevo;
    } else {
      boolean izq;
      nodo actual = raiz;
      while (true) {
        if (actual.dato < dat) izq = false; else izq = true;
        if (!izq) {
          if (actual.der == null) {
            nodo nuevo = new nodo(dat, ed);
            actual.der = nuevo;
            break;
          } else actual = actual.der;
        } else {
          if (actual.izq == null) {
            nodo nuevo = new nodo(dat, ed);
            actual.izq = nuevo;
            break;
          } else actual = actual.izq;
        }
      }
    }
    return this;
  }

  public boolean baja(int dat) {
    nodo actual = raiz, anterior = raiz, temp;
    while (true) {
      if (actual == null) {
        System.out.println("1 actual= null: " + actual);
        break;
      }
      if (actual.dato == dat) {
        System.out.println("borrando: " + dat);
        //actual=null; 20/06/19
        actual.dato = 0;
        System.out.println("borrando dato en arbol: " + actual.dato);
        imIB();
        break;
      }
      anterior = actual;
      if (actual.dato < dat) {
        System.out.println(
          "Derecha1: " + dat + "valor en nodo del recorrido es: " + actual.dato
        );
        actual = actual.der;
        System.out.println(
          "Derecha1: " + dat + "valor en nodo del recorrido es: " + actual.dato
        );
      } else {
        System.out.println(
          "En el esle: " +
          dat +
          "valor en el nodo en el recorrido es:" +
          actual.dato
        );
        actual = actual.izq;
        System.out.println(
          "En el else: " +
          dat +
          "valor en el nodo en el recorrido es:" +
          actual.dato
        );
      }
    }
    if (actual == null) return false; else {
      if (actual == raiz) {
        temp = actual.izq;
        raiz = raiz.der;
        anterior = raiz;
      } else if (anterior.der == actual) {
        temp = actual.izq;
        anterior = actual.der;
      } else {
        temp = actual.izq;
        anterior.der = actual.izq;
      }
      // actual=new nodo();
      while (actual.izq != null) actual = actual.izq;
      actual.izq = temp;
      return true;
    }
  }

  public void imprimirpreorden() {
    ayudantePreorden(raiz);
  }

  public void ayudantePreorden(nodo dat) {
    if (dat == null) return;
    System.out.printf("%d ", dat.dato);
    ayudantePreorden(dat.der);
    ayudantePreorden(dat.izq);
  }

  public void imI() {
    imprimir_inorden(raiz);
  }

  public void imprimir_inorden(nodo dat) {
    if (dat != null) {
      imprimir_inorden(dat.izq);
      System.out.println(" " + dat.dato);
      imprimir_inorden(dat.der);
    }
  }

  public void imIB() {
    imprimir_baja(raiz);
  }

  public void imprimir_baja(nodo dat) {
    if (dat != null) {
      imprimir_baja(dat.izq);
      System.out.println(" " + dat.dato);
      imprimir_baja(dat.der);
    }
  }
}