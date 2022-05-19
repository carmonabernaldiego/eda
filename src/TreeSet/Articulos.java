package TreeSet;

public class Articulos {
    int id;
    String nombre;
    String descripcion;
    double precio;

    public Articulos(int id, String nombre, String descripcion, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return
                "\n\nId: " + id + "\n" +
                        "Nombre:" + nombre + "\n" +
                        "Descripcion:" + descripcion + "\n" +
                        "Precio:" + precio;
    }
}