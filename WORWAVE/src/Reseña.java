import java.util.Date;

public class Reseña {

    private int idReseña;
    private String comentario;
    private float calificacion;
    private Date fecha;
    private String isbnLibro;
    private int idUsuario;

    public Reseña(int idReseña, String comentario, float calificacion,
                  Date fecha, String isbnLibro, int idUsuario) {
        this.idReseña = idReseña;
        this.comentario = comentario;
        this.calificacion = calificacion;
        this.fecha = fecha;
        this.isbnLibro = isbnLibro;
        this.idUsuario = idUsuario;
    }

    public void editarComentario(String texto) {
        if (!texto.isEmpty()) this.comentario = texto;
    }

    public void cambiarCalificacion(float valor) {
        if (valor >= 0 && valor <= 5) this.calificacion = valor;
    }

    public int getIdReseña() {
        return idReseña;
    }

    public String getIsbnLibro() {
        return isbnLibro;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String resumen() {
        return "ID: " + idReseña +
                " | ISBN: " + isbnLibro +
                " | Calificación: " + calificacion +
                " | Fecha: " + fecha +
                " | Comentario: " + comentario;
    }
}