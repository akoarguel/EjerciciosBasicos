package matrices;

import java.util.Scanner;

import matrices.EjercicioPokemon.Constantes;

public class Ejercicio8 {
    public static void main(String[] args) {
        System.out.println();
        String[][] nombresGolosinas = {
                { "KitKat", "Chicles de fresa", "Lacasitos", "Palotes" },
                { "Kinder Bueno", "Bolsa variada Haribo", "Chetoos", "Twix" },
                { "Kinder Bueno", "M&M'S", "Papa Delta", "Chicles de menta" },
                { "Lacasitos", "Crunch", "Milkybar", "KitKat" }
        };
        double[][] precio = {
                { 1.1, 0.8, 1.5, 0.9 },
                { 1.8, 1, 1.2, 1 },
                { 1.8, 1.3, 1.2, 0.8 },
                { 1.5, 1.1, 1.1, 1.1 }
        };
        int cantidad[][] = new int[4][4];
        double beneficios = 0;
        int numVentas = 0;
        int opcion;

        rellenarMatriz(cantidad, 5);

        Scanner sn = new Scanner(System.in);

        do {
            System.out.print(Colores.RESTART);
            menu();
            System.out.println("\nElige una opcion: ");
            opcion = sn.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("\nINTRODUCE LA POSICION DE LA GOLOSINA: ");
                    sn.nextLine();
                    String posición = sn.nextLine();
                    int primerNum = Character.getNumericValue(posición.charAt(0));
                    int segundoNum = Character.getNumericValue(posición.charAt(1));

                    if (cantidad[primerNum][segundoNum] == 0) {
                        System.out.println(
                                "\nNO QUEDAN GOLOSINAS DE " + Colores.MORADO + nombresGolosinas[primerNum][segundoNum]);
                    }

                    System.out.println("\n" + Colores.AMARILLO + nombresGolosinas[primerNum][segundoNum] +
                            Colores.RESTART + "  -->  " + Colores.MORADO + precio[primerNum][segundoNum]);
                    cantidad[primerNum][segundoNum] -= 1;
                    System.out.println(Colores.NEGRO + "\nHa cambiado la cantiadad a: " +  cantidad[primerNum][segundoNum]);
                    beneficios += precio[primerNum][segundoNum];
                    System.out.println("Suma de beneficios realizada ");
                    numVentas++;
                    System.out.println("Suma de venta realizada ");
                    break;

                case 2:
                    mostrarGolosinas(nombresGolosinas, precio);
                    break;

                case 3:
                    sn.nextLine();
                    System.out.println("\nDebe introducir la contraseña para continuar: ");
                    String contraseña = sn.nextLine();
                    if (contraseña.equals("MaquinaExpendedora2017")) {
                        System.out.println(Colores.VERDE + "CONTRASEÑA CORRECTA " + Colores.RESTART);
                        System.out.println("\nIntroduce la posición de la golosina: ");
                        mostrarGolosinas(nombresGolosinas, precio);

                        String golosina = sn.nextLine();
                        int x = Character.getNumericValue(golosina.charAt(0));
                        int y = Character.getNumericValue(golosina.charAt(1));

                        System.out.println("Ha seleccionado: " + Colores.MORADO + nombresGolosinas[x][y]);
                        System.out.println(Colores.RESTART + "Hay " + cantidad[x][y] + " golosinas. ");
                        System.out.println("\n¿Cuantas desea rellenar?");
                        cantidad[x][y] += sn.nextInt();

                    } else {
                        System.out.println(Colores.ROJO + "ERROR. " + Colores.AMARILLO
                                + "CONTRASEÑA INCORRECTA. VOLVIENDO AL MENU");
                    }
                    break;
                case 0:
                    System.out.println(
                            "Ha habido un total de " + Colores.VERDE + numVentas + Colores.RESTART + " ventas. ");
                    System.out.println(
                            "Acabamos con unos beneficios de: " + Colores.VERDE + beneficios + Colores.RESTART);
                            System.out.println();
                    break;
                default:
                    System.out.println(Colores.ROJO + "ERROR. " + Colores.RESTART + "INTRODUCE UNA OPCIÓN VÁLIDA. ");
                    break;
            }
        } while (opcion != 0);

        sn.close();
    }

    private static void mostrarGolosinas(String[][] nombresGolosinas, double[][] precio) {
        for (int i = 0; i < precio.length; i++) {
            for (int j = 0; j < precio[i].length; j++) {
                System.out.println(Colores.MORADO + " --> " + Colores.RESTART + i + "/" + j + "  "
                        + nombresGolosinas[i][j] + " --> " + precio[i][j]);
            }
        }
    }

    private static void rellenarMatriz(int[][] cantidad, int i) {
        for (int j = 0; j < cantidad.length; j++) {
            for (int j2 = 0; j2 < cantidad[j].length; j2++) {
                cantidad[j][j2] = i;
            }
        }
    }

    private static void menu() {
        System.out.println(Constantes.BLANCO + "\n        ||  MENU  ||        ");
        System.out.println(Constantes.CIAN + "\n1. PEDIR GOLOSINA");
        System.out.println(Constantes.VERDE + "2. MOSTRAR GOLOSINAS");
        System.out.println(Constantes.AMARILLO + "3. RELLENAR GOLOSINAS ");
        System.out.println(Constantes.ROJO + "\n0. APAGAR MAQUINA");
        System.out.println(Constantes.RESTART);
    }
}
