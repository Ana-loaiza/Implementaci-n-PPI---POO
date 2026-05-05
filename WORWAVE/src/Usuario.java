import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Usuario extends Persona {

    private int idUsuario;
    private String contraseña;
    private String rol;
    private List<ListaLectura> listas;

    public Usuario(int idUsuario, String contraseña, String rol,
                   String nombre, String correo, int cedula,
                   long telefono, Date fechaNacimiento) {

        super(nombre, correo, cedula, telefono, fechaNacimiento);
        this.idUsuario = idUsuario;
        this.contraseña = contraseña;
        this.rol = rol;
        this.listas = new ArrayList<>();
    }

    public void editarPerfil(String nombre, String correo) {
        if (!nombre.isEmpty()) this.nombre = nombre;
        if (correo.contains("@")) this.correo = correo;
    }

    public boolean editarContraseña(String actual, String nueva) {
        if (this.contraseña.equals(actual) && nueva.length() >= 4) {
            this.contraseña = nueva;
            return true;
        }
        return false;
    }

    public void cambiarRol(String nuevoRol) {
        this.rol = nuevoRol;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public String getRol() {
        return rol;
    }

    public List<ListaLectura> getListas() {
        return listas;
    }
}
