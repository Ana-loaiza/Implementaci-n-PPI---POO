public class GestionRecomendaciones {

    public void verRecomendaciones() {
        System.out.println("Recomendación del día: El Perfume ");
    }

    public void generarRecomendacion(Usuario u) {

        if (!u.getRol().equals("ADMIN")) {
            System.out.println("Acceso denegado");
            return;
        }

        System.out.println("Recomendación generada");
    }
}
