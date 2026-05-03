public class Usuario {
    private String nombre;
    private String correo;
    private String contraseña;
    private String rol; // ADMIN o USUARIO
    private boolean bloqueado;

    public Usuario(String nombre, String correo, String contraseña, String rol) {
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
        this.rol = rol;
        this.bloqueado = false;
    }

    public String getNombre() { return nombre; }
    public String getCorreo() { return correo; }
    public String getContraseña() { return contraseña; }
    public String getRol() { return rol; }
    public boolean isBloqueado() { return bloqueado; }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }
}

