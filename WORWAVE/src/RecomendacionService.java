import java.util.*;

public class RecomendacionService {

    private List<Recomendacion> recomendaciones;

    public RecomendacionService(List<Recomendacion> recomendaciones) {
        this.recomendaciones = recomendaciones;
    }

    public void generarRecomendacion(String isbn, String tipo) {
        recomendaciones.add(new Recomendacion(
                recomendaciones.size() + 1,
                tipo,
                new Date(),
                isbn
        ));
    }

    public List<Recomendacion> verRecomendaciones() {
        return recomendaciones;
    }
}
