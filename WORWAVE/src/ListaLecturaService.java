import java.util.*;

public class ListaLecturaService {

    public void crearLista(Usuario u, int id, String nombre) {
        u.getListas().add(new ListaLectura(id, nombre, ""));
    }

    public void agregarLibro(Usuario u, int idLista,
                             String isbn, List<Libro> libros) {
        for (ListaLectura l : u.getListas()) {
            if (l.getIdLista() == idLista) {
                l.agregarLibro(isbn, libros);
            }
        }
    }

    public void quitarLibro(Usuario u, int idLista, String isbn) {
        for (ListaLectura l : u.getListas()) {
            if (l.getIdLista() == idLista) {
                l.quitarLibro(isbn);
            }
        }
    }

    public List<ListaLectura> verListas(Usuario u) {
        return u.getListas();
    }
}
