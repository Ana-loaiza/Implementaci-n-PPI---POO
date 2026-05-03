import java.util.ArrayList;
public class Autenticacion {

    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private Usuario usuarioActual;

    public Autenticacion() {
        usuarios.add(new Usuario("Admin", "admin", "123", "ADMIN"));
    }

    public void registrarse(String nombre, String correo, String contraseña) {
        usuarios.add(new Usuario(nombre, correo, contraseña, "USUARIO"));
        System.out.println("Usuario registrado");
    }

    public Usuario iniciarSesion(String correo, String contraseña) {

        for (Usuario u : usuarios) {

            if (u.getCorreo().equals(correo) && u.getContraseña().equals(contraseña)) {

                if (u.isBloqueado()) {
                    System.out.println("Usuario bloqueado");
                    return null;
                }

                usuarioActual = u;
                System.out.println("Bienvenido " + u.getNombre());
                return u;
            }
        }

        System.out.println("Datos incorrectos");
        return null;
    }

    public void cerrarSesion() {
        usuarioActual = null;
        System.out.println("Sesión cerrada");
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
}
