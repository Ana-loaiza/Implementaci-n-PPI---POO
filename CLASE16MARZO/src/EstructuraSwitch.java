public class EstructuraSwitch {
    //Estructura selectiva Switch
    public static void main(String[] args) {
        //definición e inicialización de variables

        int lado1 = 0, lado2 = 0, lado3=0;
        int lado4 = 0, lado5 = 0, lado6=0;
        for (int f=0;f<1000;f++) {
            int dado = (int)(Math.random()*6)+1;
            if (dado==1)
                lado1++;
            else if (dado==2)
                lado2++;
            else if (dado==3)
                lado3++;
            else if (dado==4)
                lado4++;
            else if (dado==5)
                lado5++;
            else if (dado==6)
                lado6++;
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


