import java.util.ArrayList;
public class GestionUsuarios {

    public void verUsuarios(Usuario admin, ArrayList<Usuario> lista) {

        if (!admin.getRol().equals("ADMIN")) {
            System.out.println("Acceso denegado");
            return;
        }

        for (Usuario u : lista) {
            System.out.println(u.getNombre() + " - " + u.getCorreo());
        }
    }

    public void eliminarUsuario(Usuario admin, ArrayList<Usuario> lista, String correo) {

        if (!admin.getRol().equals("ADMIN")) {
            System.out.println("Acceso denegado");
            return;
        }

        lista.removeIf(u -> u.getCorreo().equals(correo));
        System.out.println("Usuario eliminado");
    }

    public void bloquearUsuario(Usuario admin, ArrayList<Usuario> lista, String correo) {

        if (!admin.getRol().equals("ADMIN")) {
            System.out.println("Acceso denegado");
            return;
        }

        for (Usuario u : lista) {
            if (u.getCorreo().equals(correo)) {
                u.setBloqueado(true);
                System.out.println("Usuario bloqueado");
            }
        }
    }
}
