import java.util.Scanner;

public class MAIN {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        int mul3, mul5, valor, f, nomul;
        mul3 = 0;
        mul5 = 0;
        nomul = 0;
        for (f = 1; f <= 10; f++) {
            System.out.print("Ingrese un valor:");
            valor = teclado.nextInt();
            if (valor % 3 == 0) {
                mul3 = mul3 + 1;
            }
            if (valor % 5 == 0) {
                mul5 = mul5 + 1;
            }
            if (valor%3 != 0 && valor % 5 != 0) {
                nomul = nomul + 1;
            }
        }
        System.out.print("Cantidad de valores ingresados multiplos de 3: ");
        System.out.println(mul3);
        System.out.print("Cantidad de valores ingresados multiplos de 5: ");
        System.out.println(mul5);
        System.out.print("Cantidad de valores ingresados no multiplos de 3 ni de 5: ");
        System.out.println(nomul);
    }
}