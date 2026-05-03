import java.util.ArrayList;
public class GestionReseñas {

    private ArrayList<Reseña> reseñas = new ArrayList<>();
    private int contador = 1;

    public void crearReseña(Usuario u, String tituloLibro, String texto) {
        reseñas.add(new Reseña(contador++, texto, tituloLibro));
        System.out.println("Reseña creada");
    }

    public void verReseñas() {
        for (Reseña r : reseñas) {
            System.out.println("Libro: " + r.getTituloLibro());
            System.out.println("Reseña: " + r.getTexto());
            System.out.println("----------------");
        }
    }

    public void editarReseña(Usuario u, int id, String nuevoTexto) {

        for (Reseña r : reseñas) {
            if (r.getId() == id) {
                r.setTexto(nuevoTexto);
                System.out.println("Reseña editada");
                return;
            }
        }

        System.out.println("No encontrada");
    }

    public void eliminarReseña(Usuario u, int id) {
        reseñas.removeIf(r -> r.getId() == id);
        System.out.println("Reseña eliminada");
    }
}
