import java.util.Date;
import java.util.List;

public class Recomendacion {

    private int idRecomendacion;
    private String isbnLibro;
    private String tipo;
    private Date fecha;

    public Recomendacion(int idRecomendacion, String tipo,
                         Date fecha, String isbnLibro) {
        this.idRecomendacion = idRecomendacion;
        this.tipo = tipo;
        this.fecha = fecha;
        this.isbnLibro = isbnLibro;
    }

    public String getIsbnLibro() {
        return isbnLibro;
    }

    public String getTipo() {
        return tipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public boolean esReciente() {
        long diff = new Date().getTime() - fecha.getTime();
        return diff < (7L * 24 * 60 * 60 * 1000);
    }

    public static void agregarRecomendacion(List<Recomendacion> lista,
                                            String isbn, String tipo) {

        lista.add(new Recomendacion(
                lista.size() + 1,
                tipo,
                new Date(),
                isbn
        ));
    }

    public String resumen() {
        return "ID: " + idRecomendacion +
                " | ISBN: " + isbnLibro +
                " | Tipo: " + tipo +
                " | Fecha: " + fecha;
    }
}