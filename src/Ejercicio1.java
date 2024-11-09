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

         matriz = new int[][];
         for (int i = 0; i < filas.lenght; i++) {
            for (int j = 0; j < columnas.lenght; j++) {
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
                    ponerbomba(scanner);
                    break;
                default:
                    System.out.println("Opción no válida, elige otra opcion valida.");
            }
        }
    }
    private static void mostrarMatriz() {
        System.out.println("Contenido de la matriz:");
        for (int i = 0; i < filas.length; i++){
            for (int j = 0; j < columnas,lenght; j++){
                System.out.println (matriz[i][j] + "");
            }
            System.out.println();
        }
    }

}