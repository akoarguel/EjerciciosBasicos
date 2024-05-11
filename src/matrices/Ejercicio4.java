/*

TERMINADO

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
        System.out.println();
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
                    System.out.println("\u001B[31m" + "\n... SALIENDO ...");
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
                    if (matrizLlena == true) {
                        System.out.println("\u001B[31m" + "ºERRORº LA MATRIZ YA HA SIDO INTRODUCIDA. ");
                    } else {

                    }
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
                case 4:
                    if (matrizLlena == true) {
                        sumaDiagonal(matriz);
                    } else {
                        System.out.println("\u001B[31m" + "ºERRORº DEBES INTRODUCIR PRIMERO LA MATRIZ. ");
                    }
                    break;
                case 5:
                    if (matrizLlena == true) {
                        sumaDiagonalInversa(matriz);
                    } else {
                        System.out.println("\u001B[31m" + "ºERRORº DEBES INTRODUCIR PRIMERO LA MATRIZ. ");
                    }
                    break;
                case 6:
                    if (matrizLlena == true) {
                        media(matriz);
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

    private static void media(int[][] matriz) {
        int suma = 0;
        int media = 0;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " + ");
                suma += matriz[i][j];
            }
        }

        media = suma / matriz.length;

        System.out.println("\n\u001B[32m" + "LA SUMA TOTAL ES DE: " + "\u001B[35m" + suma);
        System.out.println("\n\u001B[32m" + "LA MEDIA DE LA MATRIZ ES DE: " + "\u001B[35m" + media);
    }

    private static void sumaDiagonalInversa(int[][] matriz) {
        // matriz[1][4] matriz[2][3] matriz[3][2] matriz[4][1]

        int suma = 0;
        int n = matriz.length;

        for (int i = 0; i < n; i++) {
            System.out.print(matriz[n - 1 - i][n - 1 - i] + " + ");
            suma += matriz[n - 1 - i][n - 1 - i];
        }

        System.out.println("\n\u001B[32m" + "LA SUMA DE LA DIAGONAL INVERSA ES DE: " + "\u001B[35m" + suma);
    }

    private static void sumaDiagonal(int[][] matriz) {
        // matriz[1][1] matriz[2][2] matriz[3][3] matriz[4][4]

        int suma = 0;

        for (int i = 0; i < matriz.length; i++) {
            System.out.print(matriz[i][i] + " + ");
            suma += matriz[i][i];
        }

        System.out.println("\u001B[32m" + "LA SUMA DE LA DIAGONAL ES DE: " + "\u001B[35m" + suma);
    }

    private static void sumaColumna(BufferedReader scanner, int[][] matriz) throws NumberFormatException, IOException {
        System.out.println("INTRODUCE LA COLUMNA QUE QUIERES SUMAR (1-4)");
        int columna = Integer.parseInt(scanner.readLine()) - 1; // Ajustar el índice de la columna a 0-based

        if (columna < 0 || columna >= matriz[0].length) {
            System.out.println("\u001B[31m" + "ERROR. NO HAS INTRODUCIDO UNA COLUMNA VÁLIDA");
            return;
        }

        int suma = 0;

        for (int i = 0; i < matriz.length; i++) {
            System.out.print(matriz[i][columna] + " + ");
            suma += matriz[i][columna];
        }

        System.out.println("\u001B[32m" + "LA SUMA DE LA COLUMNA ES DE: " + "\u001B[35m" + suma);
    }

    private static void sumaFila(BufferedReader scanner, int[][] matriz) throws NumberFormatException, IOException {
        System.out.println("INTRODUCE EL NÚMERO DE LA FILA QUE QUIERES SUMAR (1-4):");
        int fila = Integer.parseInt(scanner.readLine()) - 1; // Ajustar el índice de la fila a 0-based

        if (fila < 0 || fila >= matriz.length) {
            System.out.println("\u001B[31m" + "ERROR. NO HAS INTRODUCIDO UNA FILA VÁLIDA");
            return;
        }

        int suma = 0;

        for (int i = 0; i < matriz[fila].length; i++) {
            System.out.print(matriz[fila][i] + " + ");
            suma += matriz[fila][i];
        }

        System.out.println("\u001B[32m" + "LA SUMA DE LA FILA ES DE: " + "\u001B[35m" + suma);
    }

    private static void rellenarMatriz(BufferedReader scanner, int[][] matriz)
            throws NumberFormatException, IOException {

        System.out.println();

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.println("INTRODUCE UN VALOR " + (i + 1) + "/" + (j + 1) + " DE LA MATRIZ.");
                matriz[i][j] = Integer.parseInt(scanner.readLine());
            }
        }

        System.out.println();
        for (int k = 0; k < 20; k++) {
            System.out.print("-");
        }
        System.out.println();

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(" " + matriz[i][j] + " | ");
            }
            System.out.println(); // Salto de línea al final de cada fila
            // Imprimir línea divisoria entre filas
            for (int k = 0; k < matriz[i].length * 4 + matriz[i].length; k++) {
                System.out.print("-");
            }
            System.out.println(); // Salto de línea después de la línea divisoria
        } // Salto de línea después de la línea divisoria
    }

    private static void menu() {
        System.out.println("\u001B[37m" + "\n     ||  MENU  ||      ");
        System.out.println("\u001B[34m" + "\n1. RELLENAR MATRIZ");
        System.out.println("\u001B[35m" + "2. SUMAR UNA FILA");
        System.out.println("\u001B[33m" + "3. SUMAR UNA COLUMNA");
        System.out.println("\u001B[36m" + "4. SUMAR DIAGONAL");
        System.out.println("\u001B[32m" + "5. SUMAR DIAGONAL INVERSA");
        System.out.println("\u001B[30m" + "6. MEDIA DE LA MATRIZ");
        System.out.println("\u001B[31m" + "\n0. SALIR");
        System.out.println("\u001B[0m");
    }
}
