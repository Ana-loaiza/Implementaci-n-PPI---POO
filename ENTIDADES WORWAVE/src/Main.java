import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);

    static List<Usuario> usuarios = new ArrayList<>();
    static List<Libro> biblioteca = new ArrayList<>();
    static List<Reseña> reseñas = new ArrayList<>();
    static List<Recomendacion> recomendaciones = new ArrayList<>();

    static Usuario usuarioActual = null;

    public static void main(String[] args) {

        biblioteca.add(new Libro("1", "Clean Code", "Robert Martin", "Programación", "Buenas prácticas"));
        biblioteca.add(new Libro("2", "Java Básico", "", "", ""));

        int opcion;

        do {
            System.out.println("\n===== SISTEMA =====");
            System.out.println("1. Registrarse");
            System.out.println("2. Iniciar sesión");
            System.out.println("0. Salir");

            opcion = leerEntero();

            switch (opcion) {
                case 1: registrarse(); break;
                case 2:
                    login();
                    if (usuarioActual != null) menuPrincipal();
                    break;
            }

        } while (opcion != 0);
    }

    static void registrarse() {

        System.out.println("\n--- REGISTRO ---");

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Correo: ");
        String correo = sc.nextLine();

        if (buscarUsuarioPorCorreo(correo) != null) {
            System.out.println("Correo ya registrado");
            return;
        }

        System.out.print("Contraseña: ");
        String pass = sc.nextLine();

        System.out.print("Cédula: ");
        int cedula = leerEntero();

        System.out.print("Teléfono: ");
        long telefono = leerLong();

        Date fechaNacimiento = leerFecha();

        Usuario u = new Usuario(
                usuarios.size() + 1,
                pass,
                nombre,
                correo,
                cedula,
                telefono,
                fechaNacimiento
        );

        usuarios.add(u);
        System.out.println("Registro exitoso");
    }

    static void login() {

        System.out.println("\n--- LOGIN ---");

        System.out.print("Correo: ");
        String correo = sc.nextLine();

        System.out.print("Contraseña: ");
        String pass = sc.nextLine();

        Usuario u = buscarUsuarioPorCorreo(correo);

        if (u != null && u.editarContraseña(pass, pass)) {
            usuarioActual = u;
            System.out.println("Bienvenido " + correo);
        } else {
            System.out.println("Datos incorrectos");
        }
    }

    static Usuario buscarUsuarioPorCorreo(String correo) {
        for (Usuario u : usuarios) {
            if (correo.equals(u.getCorreo())) return u;
        }
        return null;
    }

    static void menuPrincipal() {

        int op;
        do {
            System.out.println("\n===== MENÚ =====");
            System.out.println("1. Ver libros");
            System.out.println("2. Crear lista");
            System.out.println("3. Agregar libro a lista");
            System.out.println("4. Quitar libro de lista");
            System.out.println("5. Crear reseña");
            System.out.println("6. Editar reseña");
            System.out.println("7. Crear recomendación");
            System.out.println("8. Ver recomendaciones");
            System.out.println("9. Ver listas");
            System.out.println("10. Editar perfil");
            System.out.println("11. Editar contraseña");
            System.out.println("0. Cerrar sesión");

            op = leerEntero();

            switch (op) {
                case 1: verLibrosConReseñas(); break;
                case 2: crearLista(); break;
                case 3: agregarLibroLista(); break;
                case 4: quitarLibroLista(); break;
                case 5: crearReseña(); break;
                case 6: editarReseña(); break;
                case 7: crearRecomendacion(); break;
                case 8: verRecomendaciones(); break;
                case 9: verListas(); break;
                case 10: editarPerfil(); break;
                case 11: editarPassword(); break;
            }

        } while (op != 0);

        usuarioActual = null;
    }

    static void verLibrosConReseñas() {

        for (Libro l : biblioteca) {

            System.out.println("\n========================");
            System.out.println("ISBN: " + l.getIsbn());
            System.out.println(l.obtenerResumen());

            System.out.println("Reseñas:");

            boolean tiene = false;

            for (Reseña r : reseñas) {
                if (r.getIsbnLibro().equals(l.getIsbn())) {
                    System.out.println("- " + r.resumen());
                    tiene = true;
                }
            }

            if (!tiene) {
                System.out.println("No tiene reseñas");
            }

            System.out.println("========================");
        }
    }

    static void crearLista() {
        System.out.print("ID lista: ");
        int id = leerEntero();

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        usuarioActual.agregarLista(new ListaLectura(id, nombre, ""));
    }

    static ListaLectura seleccionarLista() {

        List<ListaLectura> listas = usuarioActual.getListas();

        if (listas.isEmpty()) {
            System.out.println("No tienes listas");
            return null;
        }

        System.out.println("Seleccione una lista:");

        for (int i = 0; i < listas.size(); i++) {
            System.out.println((i + 1) + ". " + listas.get(i));
        }

        int op = leerEntero();

        if (op < 1 || op > listas.size()) return null;

        return listas.get(op - 1);
    }

    static void agregarLibroLista() {
        ListaLectura lista = seleccionarLista();
        if (lista == null) return;

        System.out.print("ISBN: ");
        String isbn = sc.nextLine();

        lista.agregarLibro(isbn, biblioteca);
    }

    static void quitarLibroLista() {
        ListaLectura lista = seleccionarLista();
        if (lista == null) return;

        System.out.print("ISBN a quitar: ");
        String isbn = sc.nextLine();

        lista.quitarLibro(isbn);
    }

    static void crearReseña() {

        if (biblioteca.isEmpty()) {
            System.out.println("No hay libros");
            return;
        }

        System.out.println("Seleccione libro:");

        for (int i = 0; i < biblioteca.size(); i++) {
            System.out.println((i + 1) + ". " + biblioteca.get(i).obtenerResumen());
        }

        int op = leerEntero();

        if (op < 1 || op > biblioteca.size()) {
            System.out.println("Opción inválida");
            return;
        }

        Libro libro = biblioteca.get(op - 1);

        System.out.print("Comentario: ");
        String comentario = sc.nextLine();

        System.out.print("Calificación: ");
        float cal = sc.nextFloat();
        sc.nextLine();

        reseñas.add(new Reseña(
                reseñas.size() + 1,
                comentario,
                cal,
                new Date(),
                libro.getIsbn(),
                usuarioActual.getIdUsuario()
        ));

        System.out.println("Reseña creada");
    }

    static void editarReseña() {

        List<Reseña> mis = new ArrayList<>();

        for (Reseña r : reseñas) {
            if (r.getIdUsuario() == usuarioActual.getIdUsuario()) {
                mis.add(r);
            }
        }

        if (mis.isEmpty()) {
            System.out.println("No tienes reseñas");
            return;
        }

        System.out.println("Seleccione reseña:");

        for (int i = 0; i < mis.size(); i++) {
            System.out.println((i + 1) + ". " + mis.get(i).resumen());
        }

        int op = leerEntero();

        if (op < 1 || op > mis.size()) return;

        Reseña r = mis.get(op - 1);

        System.out.println("1. Editar comentario");
        System.out.println("2. Cambiar calificación");

        int opc = leerEntero();

        if (opc == 1) {
            System.out.print("Nuevo comentario: ");
            r.editarComentario(sc.nextLine());
        } else if (opc == 2) {
            System.out.print("Nueva calificación: ");
            r.cambiarCalificacion(sc.nextFloat());
            sc.nextLine();
        }

        System.out.println("Reseña actualizada");
    }

    static void crearRecomendacion() {
        System.out.print("ISBN: ");
        String isbn = sc.nextLine();

        System.out.print("Tipo: ");
        String tipo = sc.nextLine();

        Recomendacion r = new Recomendacion(
                recomendaciones.size() + 1,
                tipo,
                new Date(),
                isbn
        );

        recomendaciones.add(r);
    }

    static void verRecomendaciones() {

        for (Recomendacion r : recomendaciones) {

            Libro l = buscarLibro(r.getIsbnLibro());

            System.out.println("Tipo: " + r.getTipo());
            System.out.println("Fecha: " + r.getFecha());

            if (l != null) {
                System.out.println("Libro: " + l.obtenerResumen());
            }

            System.out.println("----------------");
        }
    }

    static void verListas() {
        for (ListaLectura lista : usuarioActual.getListas()) {
            System.out.println("\nLista: " + lista);
            for (Libro l : lista.getLibros()) {
                System.out.println("- " + l.obtenerResumen());
            }
        }
    }

    static void editarPerfil() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Correo: ");
        String correo = sc.nextLine();

        usuarioActual.editarPerfil(nombre, correo);
    }

    static void editarPassword() {
        System.out.print("Actual: ");
        String actual = sc.nextLine();

        System.out.print("Nueva: ");
        String nueva = sc.nextLine();

        if (usuarioActual.editarContraseña(actual, nueva)) {
            System.out.println("Actualizada");
        } else {
            System.out.println("Error");
        }
    }

    static Libro buscarLibro(String isbn) {
        for (Libro l : biblioteca) {
            if (l.getIsbn().equals(isbn)) return l;
        }
        return null;
    }

    static Date leerFecha() {
        System.out.print("Fecha (yyyy-mm-dd): ");
        String f = sc.nextLine();
        try {
            String[] p = f.split("-");
            Calendar c = Calendar.getInstance();
            c.set(Integer.parseInt(p[0]), Integer.parseInt(p[1]) - 1, Integer.parseInt(p[2]));
            return c.getTime();
        } catch (Exception e) {
            return new Date();
        }
    }

    static int leerEntero() {
        while (!sc.hasNextInt()) {
            System.out.println("Número válido:");
            sc.next();
        }
        int n = sc.nextInt();
        sc.nextLine();
        return n;
    }

    static long leerLong() {
        while (!sc.hasNextLong()) {
            System.out.println("Número válido:");
            sc.next();
        }
        long n = sc.nextLong();
        sc.nextLine();
        return n;
    }
}