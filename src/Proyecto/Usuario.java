public class Usuario {
    private String usuario;
    private String contraseña;

    public Usuario(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return  "Usuario: "    + usuario + "\n" +
                "Contraseña: " +contraseña;
    }
}
