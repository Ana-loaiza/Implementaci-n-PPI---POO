import java.util.ArrayList;
public class GestionListaLectura {

    private ArrayList<Libro> lista = new ArrayList<>();

    public void crearLista() {
        lista.clear();
        System.out.println("Lista creada");
    }

    public void agregarLibro(Libro l) {
        lista.add(l);
        System.out.println("Libro agregado");
    }

    public void quitarLibro(String titulo) {
        lista.removeIf(l -> l.getTitulo().equals(titulo));
        System.out.println("Libro eliminado de la lista");
    }

    public void verLista() {
        for (Libro l : lista) {
            System.out.println(l.getTitulo());
        }
    }
}
