/*
    Crea dos arrays multidimensionales de 2×3 y rellenalos como quieras (números aleatorios, por teclado o definido al crear el array).
    Haz un método que sume los arrays multidimensionales, es decir, la posición 0, 0 del array1 con la posición del array2 y así sucesivamente, 
    este metodo no debe devolver nada, haciendo que deba pasarse el array multidimensional de suma como parámetro. Muestra el contenido de cada array multidimensional.
 */

package matrices;

import java.util.Scanner;

public class Ejercicio10 {
    public static void main(String[] args) {
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        int[][] array1 = new int[2][3];
        int[][] array2 = new int[2][3];
        int[][] arrayMod = new int[2][3];
        int respuesta;

        importarArrays(array1, array2);
        mostrarArrays(array1, array2);

        do {
            System.out.println("\n1. SUMAR LOS ARRAYS");
            System.out.println("2. RESTAR LOS ARRAYS");
            System.out.println("3. MULTIPLICAR LOS ARRAYS");
            System.out.println("\nElige una opcion: ");
            respuesta = scanner.nextInt();

            switch (respuesta) {
                case 1:
                    sumarArray(array1, array2, arrayMod);
                    break;
                case 2:
                    restarArray(array1, array2, arrayMod);
                    break;
                case 3:
                    multiplicarArray(array1, array2, arrayMod);
                    break;
                default:
                    break;
            }
        } while (respuesta != 0);

        scanner.close();
    }

    private static void multiplicarArray(int[][] array1, int[][] array2, int[][] arrayMod) {
        for (int i = 0; i < arrayMod.length; i++) {
            for (int j = 0; j < arrayMod[i].length; j++) {
                arrayMod[i][j] = array1[i][j] * array2[i][j];
            }
        }
        
        System.out.println(Colores.MORADO + "\n-------------");
        for (int i = 0; i < arrayMod.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < arrayMod[i].length; j++) {
                System.out.print("" + Colores.ROJO + arrayMod[i][j] + Colores.MORADO + " | ");
            }
            System.out.println("\n-------------");
        }
        System.out.println(Colores.RESTART);
    }

    private static void restarArray(int[][] array1, int[][] array2, int[][] arrayMod) {
        for (int i = 0; i < arrayMod.length; i++) {
            for (int j = 0; j < arrayMod[i].length; j++) {
                arrayMod[i][j] = array1[i][j] - array2[i][j];
            }
        }
        
        System.out.println(Colores.MORADO + "\n-------------");
        for (int i = 0; i < arrayMod.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < arrayMod[i].length; j++) {
                System.out.print("" + Colores.ROJO + arrayMod[i][j] + Colores.MORADO + " | ");
            }
            System.out.println("\n-------------");
        }
        System.out.println(Colores.RESTART);
    }

    private static void sumarArray(int[][] array1, int[][] array2, int[][] arrayMod) {
        for (int i = 0; i < arrayMod.length; i++) {
            for (int j = 0; j < arrayMod[i].length; j++) {
                arrayMod[i][j] = array1[i][j] + array2[i][j];
            }
        }
        
        System.out.println(Colores.MORADO + "\n-------------");
        for (int i = 0; i < arrayMod.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < arrayMod[i].length; j++) {
                System.out.print("" + Colores.ROJO + arrayMod[i][j] + Colores.MORADO + " | ");
            }
            System.out.println("\n-------------");
        }
        System.out.println(Colores.RESTART);
    }

    private static void mostrarArrays(int[][] array1, int[][] array2) {
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array1[i].length; j++) {
                System.out.printf(array1[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\n");

        for (int i = 0; i < array2.length; i++) {
            for (int j = 0; j < array2[i].length; j++) {
                System.out.printf(array2[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void importarArrays(int[][] array1, int[][] array2) {
        int contador = 1;
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array1[i].length; j++) {
                array1[i][j] = contador;
                contador++;
            }
        }

        contador = 6;
        for (int i = 0; i < array2.length; i++) {
            for (int j = 0; j < array2[i].length; j++) {
                array2[i][j] = contador;
                contador--;
            }
        }
    }
}
