import java.util.ArrayList;
import java.util.List;

public class ListaLectura {
    private int idLista;
    private String nombreLista;
    private String descripcion;
    private List<Libro> libros;

    public ListaLectura(int idLista, String nombreLista, String descripcion) {
        this.idLista = idLista;
        this.nombreLista = nombreLista;
        this.descripcion = descripcion;
        this.libros = new ArrayList<>();
    }

    public void agregarLibro(String isbn, List<Libro> biblioteca) {
        for (Libro l : biblioteca) {
            if (l.getIsbn().equals(isbn)) {
                libros.add(l);
                return;
            }
        }
    }

    public void quitarLibro(String isbn) {
        libros.removeIf(l -> l.getIsbn().equals(isbn));
    }

    public int getIdLista() {
        return idLista;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public String toString() {
        return idLista + " - " + nombreLista;
    }
}
