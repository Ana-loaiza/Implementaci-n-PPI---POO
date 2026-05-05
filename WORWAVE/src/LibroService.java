import java.util.*;

public class LibroService {

    private List<Libro> libros;

    public LibroService(List<Libro> libros) {
        this.libros = libros;
    }

    public void crearLibro(String isbn, String titulo,
                           String autor, String categoria, String descripcion) {
        libros.add(new Libro(isbn, titulo, autor, categoria, descripcion));
    }

    public boolean eliminarLibro(String isbn) {
        return libros.removeIf(l -> l.getIsbn().equals(isbn));
    }

    public boolean editarLibro(String isbn, String autor,
                               String categoria, String descripcion) {

        for (int i = 0; i < libros.size(); i++) {
            Libro l = libros.get(i);

            if (l.getIsbn().equals(isbn)) {
                libros.set(i, new Libro(
                        isbn,
                        l.getTitulo(),
                        autor,
                        categoria,
                        descripcion
                ));
                return true;
            }
        }
        return false;
    }

    public String verDetalleLibro(String isbn) {
        for (Libro l : libros) {
            if (l.getIsbn().equals(isbn)) {
                return l.obtenerResumen();
            }
        }
        return "Libro no encontrado";
    }

    public List<Libro> verLibros() {
        return libros;
    }


    public String mostrarLibros() {

        if (libros.isEmpty()) {
            return "No hay libros disponibles";
        }

        StringBuilder sb = new StringBuilder();

        for (Libro l : libros) {
            sb.append("ISBN: ").append(l.getIsbn())
                    .append(" | ").append(l.obtenerResumen())
                    .append("\n");
        }

        return sb.toString();
    }


    public String mostrarLibroPorISBN(String isbn) {

        for (Libro l : libros) {
            if (l.getIsbn().equals(isbn)) {
                return "ISBN: " + l.getIsbn() + " | " + l.obtenerResumen();
            }
        }

        return "Libro no encontrado";
    }

    public Libro buscarLibro(String isbn) {
        for (Libro l : libros) {
            if (l.getIsbn().equals(isbn)) return l;
        }
        return null;
    }
}
