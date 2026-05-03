public class Libro {

    private String titulo;
    private String detalle;

    public Libro(String titulo, String detalle) {
        this.titulo = titulo;
        this.detalle = detalle;
    }

    public String getTitulo() { return titulo; }
    public String getDetalle() { return detalle; }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
}

