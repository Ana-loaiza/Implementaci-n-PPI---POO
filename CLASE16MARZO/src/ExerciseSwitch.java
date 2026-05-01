import java.util.Scanner;
public class ExerciseSwitch {
    public static void main(String[] args) {
        //definir objeto tipo scanner para leer datos desde el teclado
        Scanner teclado = new Scanner (System.in);
        String ColorLuz;
        System.out.println("Ingrese color: ");
        ColorLuz = teclado.next();
        switch (ColorLuz){
            case "Verde":
                System.out.println("Continuar avanzando");
                break;
            case "Amarillo":
                System.out.println("Parada parcial");
                break;
            case "Rojo":
                System.out.println("Parada total");
                break;
            default:
                System.out.println("Color no reconocido");
        }
    }
}

//Realizar algoritmo que simule el funcionamiento de un asensor de un edificio de 5 pisos
//