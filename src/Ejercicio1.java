import java.util.Random;
import java.util.Scanner;

public class Ejercicio1 {

    private static final int Max_Filas = 10;
    private static final int Max_Columnas = 10;
    private static final int Max_Explosiones = 100; // Tamaño máximo para el array de explosiones
    private static int[][] matriz;
    private static int filas, columnas;
    private static final int[] explosiones = new int[Max_Explosiones];
    private static int countExplosiones = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Introduce el número de filas:");
        while (true) {
            filas = scanner.nextInt();
            if (filas > 0 && filas <= Max_Filas) break;
            System.out.println("Número de filas incorrecto. Debe ser entre 1 y " + Max_Filas);
        }

        System.out.println("Introduce el número de columnas:");
        while (true) {
            columnas = scanner.nextInt();
            if (columnas > 0 && columnas <= Max_Columnas) break;
            System.out.println("Número de columnas incorrecto. Debe ser entre 1 y " + Max_Columnas);
        }

        matriz = new int[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = random.nextInt(9) + 1;
            }
        }

        while (true) {
            System.out.println("[3] Ver ranking de explosiones");
            System.out.println("[2] Poner Bomba");
            System.out.println("[1] Mostrar matriz");
            System.out.println("[0] Salir");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 0:
                    System.out.println("Adiós, muchas gracias");
                    scanner.close();
                    return;
                case 1:
                    mostrarMatriz();
                    break;
                case 2:
                    ponerBomba(scanner);
                    break;
                case 3:
                    mostrarRanking();
                    break;
                default:
                    System.out.println("Opción no válida, elige otra opción válida.");
                    break;
            }
        }
    }

    private static void mostrarMatriz() {
        System.out.println("Contenido de la matriz:");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void ponerBomba(Scanner scanner) {
        int x, y;
        while (true) {
            System.out.println("Fila (0 a " + (filas - 1) + "): ");
            x = scanner.nextInt();
            System.out.println("Columna (0 a " + (columnas - 1) + "): ");
            y = scanner.nextInt();

            if (x >= 0 && x < filas && y >= 0 && y < columnas) {
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
            matriz[x][i] = 0;
        }
        for (int i = 0; i < filas; i++) {
            matriz[i][y] = 0;
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
            System.out.println("¡Felicidades! Todos los valores han sido eliminados.");
        }
    }

    private static void mostrarRanking() {
        if (countExplosiones == 0) {
            System.out.println("No hay explosiones registradas en el ranking.");
            return;
        }

        int[] ranking = new int[countExplosiones];
        System.arraycopy(explosiones, 0, ranking, 0, countExplosiones);
        ordenarArrayDescendente(ranking);

        System.out.println("Ranking de explosiones:");
        for (int i = 0; i < countExplosiones; i++) {
            System.out.println((i + 1) + ". Daño de explosión: " + ranking[i]);
        }
    }

    private static void ordenarArrayDescendente(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] < array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}