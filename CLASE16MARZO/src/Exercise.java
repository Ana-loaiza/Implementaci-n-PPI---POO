import java.util.Scanner;
public class Exercise {

    /* Ejercicio: escribir un programa que pida ingresar coordenandas
    * (x,y) que represente puntos en el plano. Informar cuantos
    * puntos se encuentran en el primer, segundo, tercer y cuarto cuadrante.
    * Al comenzar el programa se pide al usuario que se ingrese la cantidad de puntos
    * a procesar
    */

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int cantidad, x, y;
        int primerCuadrante = 0;
        int segundoCuadrante = 0;
        int tercerCuadrante = 0;
        int cuartoCuadrante = 0;

        System.out.print("Ingrese la cantidad de puntos a procesar: ");
        cantidad = teclado.nextInt();

        for (int i = 1; i <= cantidad; i++) { //
            System.out.print("Ingrese las coordenadas del punto " + i + " (x y): ");
            x = teclado.nextInt();
            y = teclado.nextInt();

            if (x > 0 && y > 0) {
                primerCuadrante++;
            } else if (x < 0 && y > 0) {
                segundoCuadrante++;
            } else if (x < 0 && y < 0) {
                tercerCuadrante++;
            } else if (x > 0 && y < 0) {
                cuartoCuadrante++;
            }
        }

        System.out.println("Cantidad de puntos en el primer cuadrante: " + primerCuadrante);
        System.out.println("Cantidad de puntos en el segundo cuadrante: " + segundoCuadrante);
        System.out.println("Cantidad de puntos en el tercer cuadrante: " + tercerCuadrante);
        System.out.println("Cantidad de puntos en el cuarto cuadrante: " + cuartoCuadrante);
    }
}
