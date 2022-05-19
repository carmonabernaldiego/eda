public class Persona {
    //Atributos
    String nombre;
    int edad;
    String direccion;


    public Persona(String nombre, int edad, String direccion) {
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return
                "Nombre: " + nombre + "\n" +
                "Edad:" + edad + "\n" +
                "Direccion: " + direccion;
    }
}
