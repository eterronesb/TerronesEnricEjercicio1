import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Ejercicio1 {

    private static final int Max_Filas = 10;
    private static final int Max_Columnas =10;
    private static int[][] matriz;
    private static int filas, columnas;
    private static int[] explosiones;
    private static int countExplosiones = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Introduce el número de filas:");
         while (true){
             filas = scanner.nextInt();
             if (filas > 0 && filas <= Max_Filas) break;
             System.out.println("Numero de filas incorrecto. Debe ser entre 1 y " +Max_Filas);
         }

         System.out.println("Introduce el numero de columnas");
         while (true){
             columnas = scanner.nextInt();
             if (columnas > 0 && columnas <= Max_Columnas) break;
             System.out.println("Numero de columnas incorrecta. Debe ser entre 1 y " +Max_Columnas);
         }

         matriz = new int[filas][columnas];
         for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = random.nextInt(9) + 1;
            }
        }
        explosiones = new int[filas * columnas];

        while (true) {
            System.out.println("[2] Poner Bomba");
            System.out.println("[1] Mostrar matriz");
            System.out.println("[0] Salir");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 0:
                    System.out.println("Adios, muchas gracias");
                    scanner.close();
                    return;
                case 1:
                    mostrarMatriz();
                    break;
                case 2:
                    ponerBomba(scanner);
                    break;
                default:
                    System.out.println("Opción no válida, elige otra opcion valida.");
                    break;
            }
        }
    }
    private static void mostrarMatriz() {
        System.out.println("Contenido de la matriz:");
        for (int i = 0; i < filas; i++){
            for (int j = 0; j < columnas; j++) {
                System.out.println (matriz[i][j] + "");
            }
            System.out.println();
        }
    }
    private static void ponerBomba (Scanner scanner){
        int x,y;
        while (true) {
            System.out.println("Fila (0 a " + (filas - 1) +"): ");
            x = scanner.nextInt();
            System.out.println("Columna (0 a " + (columnas - 1) +"): ");
            y = scanner.nextInt();

            if(x >= 0 && x < filas && y>= 0 && y < columnas) {
                break;
            } else {
                System.out.println("Coordenadas no válidas, intenta de nuevo.");
            }
        }
        int explosion = 0;

        for (int i = 0; i < columnas; i++) {
            explosion += matriz[x][i];
        }
        for (int i = 0; i < filas; i++) {
            explosion += matriz[i][y];
        }
        explosion -= matriz[x][y];
        System.out.println("Daño de la explosión: " + explosion);

        for (int i = 0; i < columnas; i++) {
            matriz[x][i] =0;
        }
        for (int i = 0; i < filas; i++){
            matriz[x][i] = 0;
        }
        explosiones[countExplosiones++] = explosion;

        boolean finJuego = true;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (matriz[i][j] != 0) {
                    finJuego = false;
                    break;
                }
            }
        }
        if (finJuego) {
            System.out.println("Felicidades!! Todos los valores han sido eliminados.");
        }
    }
}