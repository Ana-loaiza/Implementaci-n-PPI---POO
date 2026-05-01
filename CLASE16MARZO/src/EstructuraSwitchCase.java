public class EstructuraSwitchCase {
    public static void main(String[] args) {

        int lado1 = 0;
        int lado2 = 0;
        int lado3 = 0;
        int lado4 = 0;
        int lado5 = 0;
        int lado6 = 0;
        for (int f=0;f<1000;f++) {
            int dado = (int)(Math.random()*6)+1;
            switch (dado) {
                case 1:
                    lado1++;
                    break;
                case 2:
                    lado2++;
                    break;
                case 3:
                    lado3++;
                    break;
                case 4:
                    lado4++;
                    break;
                case 5:
                    lado5++;
                    break;
                case 6:
                    lado6++;
                    break;
    }
        }
        System.out.println("EL RESULTADO DE LA PRIMERA SIMULACIÓN");
        System.out.println("La cantidad de veces que salio el lado 1 es: " + lado1);
        System.out.println("La cantidad de veces que salio el lado 2 es: " + lado2);
        System.out.println("La cantidad de veces que salio el lado 3 es: " + lado3);
        System.out.println("La cantidad de veces que salio el lado 4 es: " + lado4);
        System.out.println("La cantidad de veces que salio el lado 5 es: " + lado5);
        System.out.println("La cantidad de veces que salio el lado 6 es: " + lado6);
    }
}
