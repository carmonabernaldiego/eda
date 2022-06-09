package ArbolPractica;

class NodoG<T extends Comparable<T>> {
    private T dato;
    private NodoG izquierda, derecha;

    public NodoG(T dato) {
        this.dato = dato;
        this.izquierda = this.derecha = null;
    }

    public T getDato() {
        return dato;
    }

    public NodoG getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(NodoG izquierda) {
        this.izquierda = izquierda;
    }

    public NodoG getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoG derecha) {
        this.derecha = derecha;
    }

    public void imprimirDato() {
        System.out.println(this.getDato());
    }
}

public class ArbolG<T extends Comparable<T>> {
    private NodoG raiz;

    public ArbolG() {}

    public boolean existe(T busqueda) {
        return existe(this.raiz, busqueda);
    }

    private boolean existe(NodoG n, T busqueda) {
        if (n == null) {
            return false;
        }
        if (n.getDato().equals(busqueda)) {
            return true;
        } else if (busqueda.compareTo((T) n.getDato()) < 0) {
            return existe(n.getIzquierda(), busqueda);
        } else {
            return existe(n.getDerecha(), busqueda);
        }

    }

    public void insertar(T dato) {
        if (this.raiz == null) {
            this.raiz = new NodoG(dato);
        } else {
            this.insertar(this.raiz, dato);
        }
    }

    private void insertar(NodoG padre, T dato) {
        if (dato.compareTo((T) padre.getDato()) > 0) {
            if (padre.getDerecha() == null) {
                padre.setDerecha(new NodoG(dato));
            } else {
                this.insertar(padre.getDerecha(), dato);
            }
        } else {
            if (padre.getIzquierda() == null) {
                padre.setIzquierda(new NodoG(dato));
            } else {
                this.insertar(padre.getIzquierda(), dato);
            }
        }
    }

    private void preorden(NodoG n) {
        if (n != null) {
            n.imprimirDato();
            preorden(n.getIzquierda());
            preorden(n.getDerecha());
        }
    }

    private void inorden(NodoG n) {
        if (n != null) {
            inorden(n.getIzquierda());
            n.imprimirDato();
            inorden(n.getDerecha());
        }
    }

    private void postorden(NodoG n) {
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