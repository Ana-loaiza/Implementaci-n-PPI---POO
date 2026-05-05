import java.util.*;

public class AutenticacionService {

    private List<Usuario> usuarios;
    private Usuario usuarioActual;

    public AutenticacionService(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Usuario registrarse(String nombre, String correo, String pass,
                               int cedula, long telefono, Date fecha, String rol) {

        for (Usuario u : usuarios) {
            if (u.getCorreo().equals(correo)) return null;
        }

        Usuario nuevo = new Usuario(
                usuarios.size() + 1, pass, rol,
                nombre, correo, cedula, telefono, fecha
        );

        usuarios.add(nuevo);
        return nuevo;
    }

    public Usuario iniciarSesion(String correo, String pass) {
        for (Usuario u : usuarios) {
            if (u.getCorreo().equals(correo) &&
                    u.editarContraseña(pass, pass)) {
                usuarioActual = u;
                return u;
            }
        }
        return null;
    }

    public void cerrarSesion() {
        usuarioActual = null;
    }

    public Usuario getUsuarioActual() {
        return usuarioActual;
    }
}