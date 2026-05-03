public class Reseña {

    private int id;
    private String texto;
    private String tituloLibro;

    public Reseña(int id, String texto, String tituloLibro) {
        this.id = id;
        this.texto = texto;
        this.tituloLibro = tituloLibro;
    }

    public int getId() { return id; }
    public String getTexto() { return texto; }
    public String getTituloLibro() { return tituloLibro; }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
