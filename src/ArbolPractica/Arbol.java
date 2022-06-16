package ArbolPractica;

class Nodo {
    private int dato;
    private Nodo izquierda, derecha;

    public Nodo(int dato) {
        this.dato = dato;
        this.izquierda = this.derecha = null;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public Nodo getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(Nodo izquierda) {
        this.izquierda = izquierda;
    }

    public Nodo getDerecha() {
        return derecha;
    }

    public void setDerecha(Nodo derecha) {
        this.derecha = derecha;
    }

    public void imprimirDato() {
        System.out.println(this.getDato());
    }
}

public class Arbol {
    private Nodo raiz;

    public Arbol() {}

    public boolean existe(int busqueda) {
        return existe(this.raiz, busqueda);
    }

    private boolean existe(Nodo n, int busqueda) {
        if (n == null) {
            return false;
        }
        if (n.getDato() == busqueda) {
            return true;
        } else if (busqueda < n.getDato()) {
            return existe(n.getIzquierda(), busqueda);
        } else {
            return existe(n.getDerecha(), busqueda);
        }

    }

    public void insertar(int dato) {
        if (this.raiz == null) {
            this.raiz = new Nodo(dato);
        } else {
            this.insertar(this.raiz, dato);
        } 
    }

    private void insertar(Nodo padre, int dato) {
        if (dato > padre.getDato()) {
            if (padre.getDerecha() == null) {
                padre.setDerecha(new Nodo(dato));
            } else {
                this.insertar(padre.getDerecha(), dato);
            }
        } else {
            if (padre.getIzquierda() == null) {
                padre.setIzquierda(new Nodo(dato));
            } else {
                this.insertar(padre.getIzquierda(), dato);
            }
        }
    }

    public void eliminar(int dato) {
        eliminar(this.raiz, dato);
    }
    
    private Nodo eliminar(Nodo padre, int dato) {
        if(padre == null) return padre;

        if(dato < padre.getDato()) {
            padre.setIzquierda(eliminar(padre.getIzquierda(), dato));
        } else if(dato > padre.getDato()) {
            padre.setDerecha(eliminar(padre.getDerecha(), dato));
        } else {
            // Borrar nodo sin nodos hoja (nodos Padre)
            if(padre.getIzquierda() == null && padre.getDerecha() == null) {
                System.out.println("Borrando... " + dato);
                return null;
            } else if(padre.getIzquierda() == null) {
                // nodo con un nodo (sin nodo izquierdo)
                System.out.println("Borrando... " + dato);
                return padre.getDerecha();
            } else if(padre.getDerecha() == null) {
                // nodo con un nodo (sin nodo derecho)
                System.out.println("Borrando... " + dato);
                return padre.getIzquierda();
            } else {
                // nodos con dos nodos
                // busca el número mínimo en el subárbol derecho
                int valorMinimo = valorMinimo(padre.getDerecha());
                padre.setDato(valorMinimo);
                padre.setDerecha(eliminar(padre.getDerecha(), valorMinimo));
                System.out.println("Borrando... " + dato);
            }
        }
        return padre;
    }

    private int valorMinimo(Nodo nodo) {
        if(nodo.getIzquierda() != null) {
            return valorMinimo(nodo.getIzquierda());
        }
        return nodo.getDato();
    }

    private void preorden(Nodo n) {
        if (n != null) {
            n.imprimirDato();
            preorden(n.getIzquierda());
            preorden(n.getDerecha());
        }
    }

    private void inorden(Nodo n) {
        if (n != null) {
            inorden(n.getIzquierda());
            n.imprimirDato();
            inorden(n.getDerecha());
        }
    }

    private void postorden(Nodo n) {
        if (n != null) {
            postorden(n.getIzquierda());
            postorden(n.getDerecha());
            n.imprimirDato();
        }
    }

    public void preorden() {
        this.preorden(this.raiz);
    }

    public void inorden() {
        this.inorden(this.raiz);
    }

    public void postorden() {
        this.postorden(this.raiz);
    }
}