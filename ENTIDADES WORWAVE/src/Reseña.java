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


    public void editarComentario(String nuevoTexto) {
        if (nuevoTexto != null && !nuevoTexto.isEmpty()) {
            this.comentario = nuevoTexto;
        }
    }

    public void cambiarCalificacion(float valor) {
        if (valor >= 0 && valor <= 5) {
            this.calificacion = valor;
        } else {
            System.out.println("La calificación debe estar entre 0 y 5");
        }
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

    public float getCalificacion() {
        return calificacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getComentario() {
        return comentario;
    }

    public String resumen() {
        return "ID: " + idReseña +
                " | ISBN: " + isbnLibro +
                " | Calificación: " + calificacion +
                " | Fecha: " + fecha +
                " | Comentario: " + comentario;
    }
}