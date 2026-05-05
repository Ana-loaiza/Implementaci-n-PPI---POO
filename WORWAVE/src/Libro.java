public class Libro {

    private String isbn;
    private String titulo;
    private String autor;
    private String categoria;
    private String descripcion;

    public Libro(String isbn, String titulo, String autor,
                 String categoria, String descripcion) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.descripcion = descripcion;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor == null || autor.isEmpty() ? "Autor no disponible" : autor;
    }

    public String getCategoria() {
        return categoria == null || categoria.isEmpty() ? "Categoría no disponible" : categoria;
    }

    public String getDescripcion() {
        return descripcion == null || descripcion.isEmpty() ? "Sin descripción" : descripcion;
    }

    public String obtenerResumen() {
        return "Título: " + titulo +
                " | Autor: " + getAutor() +
                " | Categoría: " + getCategoria() +
                " | Descripción: " + getDescripcion();
    }
}
