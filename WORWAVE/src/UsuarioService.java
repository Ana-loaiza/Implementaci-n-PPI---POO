import java.util.*;

public class UsuarioService {

    private List<Usuario> usuarios;

    public UsuarioService(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Usuario> verUsuarios() {
        return usuarios;
    }

    public boolean eliminarUsuario(int id) {
        return usuarios.removeIf(u -> u.getIdUsuario() == id);
    }

    public void bloquearUsuario(int id) {
        for (Usuario u : usuarios) {
            if (u.getIdUsuario() == id) {
                u.cambiarRol("bloqueado");
            }
        }
    }
}