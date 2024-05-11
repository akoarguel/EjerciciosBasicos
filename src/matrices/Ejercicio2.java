/*
Crear una matriz de 5 filas y n columnas (se pide al usuario). 
Rellenarlo con números aleatorios entre 0 y 10.
*/

package matrices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio2 {
    public static void main(String[] args) throws IOException, InterruptedException {

        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("INTRODUCE EL NÚMERO DE COLUMNAS QUE VA A TENER LA MATRIZ: ");
        int columnas = Integer.parseInt(scanner.readLine());

        int[][] matriz = new int[5][columnas];

        System.out.println("\u001B[32m" + "\n... GENERANDO ...");
        Thread.sleep(150);
        System.out.println("\u001B[33m" + ".");
        Thread.sleep(150);
        System.out.println("\u001B[33m" + ".");
        Thread.sleep(150);
        System.out.println("\u001B[33m" + "." + "\u001B[0m");
        Thread.sleep(150);
        System.out.println();

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = (int) Math.floor(Math.random()*10);
            }
        }

        for (int i = 0; i < matriz.length; i++) {
            int colorAleatorio = (int) (Math.floor(Math.random()*(36-32+1)+36));
            String color = "\u001B[" + colorAleatorio + "m";
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(color + matriz[i][j] + "\u001B[0m" + "   ");
            }
            System.out.println();
        }
        System.out.println("\n");
        scanner.close();
    }
}
