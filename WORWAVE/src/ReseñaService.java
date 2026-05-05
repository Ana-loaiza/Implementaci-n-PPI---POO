import java.util.*;

public class ReseñaService {

    private List<Reseña> reseñas;

    public ReseñaService(List<Reseña> reseñas) {
        this.reseñas = reseñas;
    }

    public void crearReseña(String isbn, String comentario,
                            float calificacion, int idUsuario) {

        reseñas.add(new Reseña(
                reseñas.size() + 1,
                comentario,
                calificacion,
                new Date(),
                isbn,
                idUsuario
        ));
    }

    public boolean eliminarReseña(int id) {
        return reseñas.removeIf(r -> r.getIdReseña() == id);
    }

    public boolean editarReseña(int id, String comentario, Float calificacion) {
        for (Reseña r : reseñas) {
            if (r.getIdReseña() == id) {
                if (comentario != null) r.editarComentario(comentario);
                if (calificacion != null) r.cambiarCalificacion(calificacion);
                return true;
            }
        }
        return false;
    }

    public List<Reseña> obtenerPorLibro(String isbn) {
        List<Reseña> lista = new ArrayList<>();

        for (Reseña r : reseñas) {
            if (r.getIsbnLibro().equals(isbn)) {
                lista.add(r);
            }
        }
        return lista;
    }
}
