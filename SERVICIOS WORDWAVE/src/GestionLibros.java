import java.util.ArrayList;
public class GestionLibros {

    private ArrayList<Libro> libros = new ArrayList<>();

    public void verLibros() {
        for (Libro l : libros) {
            System.out.println(l.getTitulo());
        }
    }

    public void crearLibro(Usuario u, String titulo, String detalle) {

        if (!u.getRol().equals("ADMIN")) {
            System.out.println("Acceso denegado");
            return;
        }

        libros.add(new Libro(titulo, detalle));
        System.out.println("Libro agregado");
    }

    public void editarLibro(Usuario u, String viejo, String nuevoDetalle) {

        if (!u.getRol().equals("ADMIN")) {
            System.out.println("Acceso denegado");
            return;
        }

        for (Libro l : libros) {
            if (l.getTitulo().equals(viejo)) {
                l.setDetalle(nuevoDetalle);
                System.out.println("Libro actualizado");
                return;
            }
        }

        System.out.println("Libro no encontrado");
    }

    public void buscarLibro(String titulo) {

        for (Libro l : libros) {
            if (l.getTitulo().equals(titulo)) {
                System.out.println("Encontrado: " + l.getTitulo());
                return;
            }
        }

        System.out.println("No existe");
    }

    public void verDetalleLibro(String titulo) {

        for (Libro l : libros) {
            if (l.getTitulo().equals(titulo)) {
                System.out.println("Título: " + l.getTitulo());
                System.out.println("Detalle: " + l.getDetalle());
                return;
            }
        }

        System.out.println("Libro no encontrado");
    }

    public void eliminarLibro(Usuario u, String titulo) {

        if (!u.getRol().equals("ADMIN")) {
            System.out.println("Acceso denegado");
            return;
        }

        libros.removeIf(l -> l.getTitulo().equals(titulo));
        System.out.println("Libro eliminado");
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }
}
