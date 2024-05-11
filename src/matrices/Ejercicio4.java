/*
4) Nos piden crear una matriz de 4×4 de números enteros que inicialmente esta vacía, nos piden hacer un menú con estas opciones:

Rellenar TODA la matriz de números, debes pedírselo al usuario.
Suma de una fila que se pedirá al usuario (controlar que elija una correcta)
Suma de una columna que se pedirá al usuario (controlar que elija una correcta)
Sumar la diagonal principal (ver ejemplo)
Sumar la diagonal inversa (ver ejemplo)
La media de todos los valores de la matriz

IMPORTANTE: hasta que no se haga la primera opción, el resto de opciones no se deberán de ejecutar, 
simplemente mostrar un mensaje donde diga que debes rellenar la matriz
*/
package matrices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio4 {
    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        int respuesta;
        int[][] matriz = new int[4][4];
        boolean matrizLlena = false;

        do {
            System.out.print("\u001B[0m");
            menu();
            System.out.println("ELIGE UNA DE LAS OPCIONES: ");
            respuesta = Integer.parseInt(scanner.readLine());
            switch (respuesta) {
                case 0:
                    System.out.println("\u001B[31m" + "\n... GENERANDO ...");
                    Thread.sleep(150);
                    System.out.println("\u001B[31m" + ".");
                    Thread.sleep(150);
                    System.out.println("\u001B[31m" + ".");
                    Thread.sleep(150);
                    System.out.println("\u001B[31m" + "." + "\u001B[0m");
                    Thread.sleep(150);
                    System.out.println();
                    break;
                case 1:
                    rellenarMatriz(scanner, matriz);
                    matrizLlena = true;
                    break;
                case 2:
                    if (matrizLlena == true) {
                        sumaFila(scanner, matriz);
                    } else {
                        System.out.println("\u001B[31m" + "ºERRORº DEBES INTRODUCIR PRIMERO LA MATRIZ. ");
                    }
                    break;
                case 3:
                    if (matrizLlena == true) {
                        sumaColumna(scanner, matriz);
                    } else {
                        System.out.println("\u001B[31m" + "ºERRORº DEBES INTRODUCIR PRIMERO LA MATRIZ. ");
                    }
                    break;
                default:
                    break;
            }

        } while (respuesta != 0);

        scanner.close();
    }

    private static void sumaColumna(BufferedReader scanner, int[][] matriz) {
        System.out.println("INTRODCUE LA COL");
    }

    private static void sumaFila(BufferedReader scanner, int[][] matriz) throws NumberFormatException, IOException {
        System.out.println("INTRODUCE LA FILA QUE QUIERES SUMAR: (1-4)");
        int fila = Integer.parseInt(scanner.readLine());
        int suma = 0;

        for (int i = 0; i < matriz[(fila - 1)].length; i++) {
            suma += matriz[fila - 1][i];
        }

        System.out.println("\u001B[32m" + "LA SUMA DE LA FILA ES DE: " + "\u001B[35m" + suma);
    }

    private static void rellenarMatriz(BufferedReader scanner, int[][] matriz)
            throws NumberFormatException, IOException {

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.println("INTRODUCE UN VALOR (1-9)" + (i + 1) + " DE LA MATRIZ. ");
                matriz[i][j] = Integer.parseInt(scanner.readLine());
            }
        }
    }

    private static void menu() {
        System.out.println("\u001B[37m" + "\n     ||  MENU  ||      ");
        System.out.println("\u001B[34m" + "1. RELLENAR MATRIZ");
        System.out.println("\u001B[35m" + "2. SUMAR UNA FILA");
        System.out.println("\u001B[33m" + "3. SUMAR UNA COLUMNA");
        System.out.println("\u001B[36m" + "5. SUMAR DIAGONAL");
        System.out.println("\u001B[32m" + "6. SUMAR DIAGONAL INVERSA");
        System.out.println("\u001B[30m" + "7. MEDIA DE LA MATRIZ");
        System.out.println("\u001B[31m" + "\nSALIR");
        System.out.println("\u001B[0m");
    }
}
