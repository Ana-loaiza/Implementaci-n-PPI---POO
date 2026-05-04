import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Usuario extends Persona {

    private int idUsuario;
    private String contraseña;
    private List<ListaLectura> listas;

    public Usuario(int idUsuario, String contraseña, String nombre, String correo,
                   int cedula, long telefono, Date fechaNacimiento) {
        super(nombre, correo, cedula, telefono, fechaNacimiento);
        this.idUsuario = idUsuario;
        this.contraseña = contraseña;
        this.listas = new ArrayList<>();
    }

    public void editarPerfil(String nuevoNombre, String nuevoCorreo) {
        if (nuevoNombre != null && !nuevoNombre.isEmpty()) {
            this.nombre = nuevoNombre;
        }
        if (nuevoCorreo != null && nuevoCorreo.contains("@")) {
            this.correo = nuevoCorreo;
        }
    }

    public boolean editarContraseña(String actual, String nueva) {
        if (this.contraseña.equals(actual) && nueva.length() >= 4) {
            this.contraseña = nueva;
            return true;
        }
        return false;
    }

    public void agregarLista(ListaLectura lista) {
        listas.add(lista);
    }

    public List<ListaLectura> getListas() {
        return listas;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getCorreo() {
        return correo;
    }
}
