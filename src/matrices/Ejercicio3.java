/*
3) Crear dos matrices de nxn y sumar sus valores, los resultados se deben almacenar en otra matriz. 
Los valores y la longitud, seran insertados por el usuario. Mostrar las matrices originales y el resultado.
*/
package matrices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio3 {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        int[][] matriz1;
        int[][] matriz2;

        System.out.println("Introduce el tamaño de la matriz: ");
        int tamaño = Integer.parseInt(scanner.readLine());

        matriz1 = new int[tamaño][tamaño];
        matriz2 = new int[tamaño][tamaño];

        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz1[i].length; j++) {
                System.out.println("Introduce el valor de " + (i + 1) + "x" + (j + 1) + " de la MATRIZ 1");
                matriz1[i][j] = Integer.parseInt(scanner.readLine());
                System.out.println("Introduce el valor de " + (i + 1) + "x" + (j + 1) + " de la MATRIZ 1");
                matriz2[i][j] = Integer.parseInt(scanner.readLine());
            }
        }

        int[][] matrizModificada = new int[tamaño][tamaño];

        for (int i = 0; i < matrizModificada.length; i++) {
            for (int j = 0; j < matrizModificada[i].length; j++) {
                matrizModificada[i][j] = matriz1[i][j] + matriz2[i][j];
            }
        }

        mostrarMatrices(matriz1, matriz2, matrizModificada);

        scanner.close();
    }

    private static void mostrarMatrices(int[][] matriz1, int[][] matriz2, int[][] matrizModificada) {
        System.out.println("\nMATRICES ORIGINALES: ");

        System.out.println("\u001B[34m");
        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz1[i].length; j++) {
                System.out.print(matriz1[i][j] + "    ");
            }
            System.out.println();
        }
        System.out.println("\u001B[35m");
        for (int i = 0; i < matriz2.length; i++) {
            for (int j = 0; j < matriz2[i].length; j++) {
                System.out.print(matriz2[i][j] + "    ");
            }
            System.out.println();
        }

        System.out.println("\u001B[0m");
        System.out.println("\nMATRIZ MODIFICADA: ");
        System.out.println("\u001B[32m");
        for (int i = 0; i < matrizModificada.length; i++) {
            for (int j = 0; j < matrizModificada[i].length; j++) {
                System.out.print(matrizModificada[i][j] + "     ");
            }
            System.out.println();
        }
        System.out.println("\u001B[0m");
    }
}
