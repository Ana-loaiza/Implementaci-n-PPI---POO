import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Autenticacion auth = new Autenticacion();
        GestionUsuarios gu = new GestionUsuarios();
        GestionLibros gl = new GestionLibros();
        GestionReseñas gr = new GestionReseñas();
        GestionListaLectura gll = new GestionListaLectura();
        GestionRecomendaciones gre = new GestionRecomendaciones();

        Usuario usuario = null;

        // LOGIN
        while (usuario == null) {
            System.out.println("1. Login");
            System.out.println("2. Registrar");
            int op = sc.nextInt();
            sc.nextLine();

            if (op == 1) {
                System.out.print("Correo: ");
                String c = sc.nextLine();

                System.out.print("Contraseña: ");
                String p = sc.nextLine();

                usuario = auth.iniciarSesion(c, p);

            } else {
                System.out.print("Nombre: ");
                String n = sc.nextLine();

                System.out.print("Correo: ");
                String c = sc.nextLine();

                System.out.print("Contraseña: ");
                String p = sc.nextLine();

                auth.registrarse(n, c, p);
            }
        }

        int opcion;

        do {
            System.out.println("\n1. Ver libros");
            System.out.println("2. Crear libro (admin)");
            System.out.println("3. Buscar libro");
            System.out.println("4. Ver detalle libro");
            System.out.println("5. Ver usuarios (admin)");
            System.out.println("6. Crear reseña");
            System.out.println("7. Ver reseñas");
            System.out.println("8. Lista lectura");
            System.out.println("9. Recomendaciones");
            System.out.println("10. Cerrar sesión");
            System.out.println("0. Salir");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    gl.verLibros();
                    break;

                case 2:
                    System.out.print("Título: ");
                    String t = sc.nextLine();

                    System.out.print("Detalle: ");
                    String d = sc.nextLine();

                    gl.crearLibro(usuario, t, d);
                    break;

                case 3:
                    System.out.print("Buscar: ");
                    gl.buscarLibro(sc.nextLine());
                    break;

                case 4:
                    System.out.print("Título del libro: ");
                    gl.verDetalleLibro(sc.nextLine());
                    break;

                case 5:
                    gu.verUsuarios(usuario, auth.getUsuarios());
                    break;

                case 6:
                    System.out.print("Título del libro: ");
                    String libro = sc.nextLine();

                    System.out.print("Reseña: ");
                    String texto = sc.nextLine();

                    gr.crearReseña(usuario, libro, texto);
                    break;

                case 7:
                    gr.verReseñas();
                    break;

                case 8:

                    int opLista;

                    do {
                        System.out.println("\n--- LISTA DE LECTURA ---");
                        System.out.println("1. Crear lista");
                        System.out.println("2. Agregar libro");
                        System.out.println("3. Ver lista");
                        System.out.println("4. Quitar libro");
                        System.out.println("0. Volver");

                        opLista = sc.nextInt();
                        sc.nextLine();

                        switch (opLista) {

                            case 1:
                                gll.crearLista();
                                break;

                            case 2:
                                System.out.print("Título: ");
                                String titulo = sc.nextLine();

                                boolean encontrado = false;

                                for (Libro l : gl.getLibros()) {
                                    if (l.getTitulo().equals(titulo)) {
                                        gll.agregarLibro(l);
                                        encontrado = true;
                                    }
                                }

                                if (!encontrado) {
                                    System.out.println("Libro no existe");
                                }
                                break;

                            case 3:
                                gll.verLista();
                                break;

                            case 4:
                                System.out.print("Quitar: ");
                                gll.quitarLibro(sc.nextLine());
                                break;
                        }

                    } while (opLista != 0);

                    break;

                case 9:
                    gre.verRecomendaciones();
                    break;

                case 10:
                    auth.cerrarSesion();
                    usuario = null;
                    break;
            }

        } while (opcion != 0);

        System.out.println("Fin del programa");
    }

}
