import java.util.Date;

public class Recomendacion {
    private int idRecomendacion;
    private String tipo;
    private Date fecha;
    private String isbnLibro;

    public Recomendacion(int idRecomendacion, String tipo, Date fecha, String isbnLibro) {
        this.idRecomendacion = idRecomendacion;
        this.tipo = tipo;
        this.fecha = fecha;
        this.isbnLibro = isbnLibro;
    }

    public void agregarRecomendacion() {
        System.out.println("Recomendación creada");
    }

    public String getTipo() {
        return tipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getIsbnLibro() {
        return isbnLibro;
    }
}
