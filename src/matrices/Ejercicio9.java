package matrices;

import java.util.Scanner;

public class Ejercicio9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] tablero = new char[3][3];

        String jugador1;
        String jugador2;

        char J1 = 'X';
        char J2 = 'O';
        char vacio = '-';

        // turno actual
        // true = J1, false = J2
        boolean turno = true;
        int fila, columna;
        boolean posValida, correcto;

        System.out.println("Introduce tu nombre: ");
        jugador1 = scanner.nextLine();
        System.out.println("Introduce tu nombre: ");
        jugador2 = scanner.nextLine();

        System.out.println("\nJUGUEMOS");
        System.out.println("-----------");
        System.out.println("\n" + jugador1 + " --> " + Colores.ROJO + "X" + Colores.RESTART);
        System.out.println(jugador2 + " --> " + Colores.AZUL + "O" + Colores.RESTART);

        vaciarTablero(tablero);

        // No salimos hasta que uno gane o no haya mas posibilidades
        while (!finPartida(tablero, vacio)) {

            do {

                // mostramos el jugador al que le toca
                mostrarTurnoActual(turno, jugador1, jugador2);

                // muestro el tablero
                mostrarTablero(tablero);

                correcto = false;
                fila = pedirInteger("Dame la fila", scanner);
                columna = pedirInteger("Dame la columna", scanner);

                // Validamos la posicion
                posValida = validarPosicion(tablero, fila, columna);

                // Si es valido, comprobamos que no haya ninguna marca
                if (posValida) {

                    // Si no hay marca, significa que es correcto
                    if (!hayValorPosicion(tablero, fila, columna, vacio)) {
                        correcto = true;
                    } else {
                        System.out.println("Ya hay una marca en esa posicion");
                    }
                } else {
                    System.out.println("La posicion no es valida");
                }

                // Mientras no sea correcto, no salgo
            } while (!correcto);

            // depende del turno, inserta un simbolo u otro
            if (turno) {
                insertarEn(tablero, fila, columna, J1);
            } else {
                insertarEn(tablero, fila, columna, J2);
            }

            // cambio de turno
            turno = !turno;
        }

        // Muestra el tablero
        mostrarTablero(tablero);

        // Mostramos el ganador
        mostrarGanador(tablero, J1, J2, vacio, jugador1, jugador2);

        scanner.close();

    }

    private static void mostrarGanador(char[][] tablero, char j1, char j2, char vacio, String jugador1,
            String jugador2) {
        char simbolo = coincidenciaLinea(tablero, vacio);

        if (simbolo != vacio) {
            ganador(simbolo, j1, j2, 1, jugador1, jugador2);

            return;
        }

        simbolo = coincidenciaColumna(tablero, vacio);

        if (simbolo != vacio) {
            ganador(simbolo, j1, j2, 2, jugador1, jugador2);

            return;
        }

        simbolo = coincidenciaDiagonal(tablero, vacio);

        if (simbolo != vacio) {
            ganador(simbolo, j1, j2, vacio, jugador1, jugador2);

            return;

        }

        System.out.println("\nHAY EMPATE. ");

    }

    private static void ganador(char simbolo, char j1, char j2, int tipo, String jugador1, String jugador2) {
        switch (tipo) {
            case 1:
                if (simbolo == j1) {
                    System.out.println("Ha ganado " + jugador1 + " por línea: ");
                } else {
                    System.out.println("Ha ganado " + jugador2 + " por línea. ");
                }
                break;
            case 2:
                if (simbolo == j1) {
                    System.out.println("Ha ganado " + jugador1 + " por columna: ");
                } else {
                    System.out.println("Ha ganado " + jugador2 + " por columna. ");
                }
                break;
            case 3:
                if (simbolo == j1) {
                    System.out.println("Ha ganado " + jugador1 + " por diagonal: ");
                } else {
                    System.out.println("Ha ganado " + jugador2 + " por diagonal. ");
                }
                break;
        }
    }

    private static void insertarEn(char[][] tablero, int fila, int columna, char j) {
        tablero[fila][columna] = j;
    }

    private static boolean hayValorPosicion(char[][] tablero, int fila, int columna, char vacio) {
        if (tablero[fila][columna] != vacio) {
            return true;
        }

        return false;
    }

    private static boolean validarPosicion(char[][] tablero, int fila, int columna) {
        if (tablero[fila][columna] == '-') {
            return true;
        } else {
            return false;
        }
    }

    private static void mostrarTurnoActual(boolean turno, String jugador1, String jugador2) {
        if (turno) {
            System.out.println("TURNO DE: " + jugador1);
        } else {
            System.out.println("TURNO DE " + jugador2);
        }
    }

    public static boolean finPartida(char[][] matriz, char simboloDef) {

        if (matrizLlena(matriz, simboloDef)
                || coincidenciaLinea(matriz, simboloDef) != simboloDef
                || coincidenciaColumna(matriz, simboloDef) != simboloDef
                || coincidenciaDiagonal(matriz, simboloDef) != simboloDef) {
            return true;
        }

        return false;
    }

    private static boolean matrizLlena(char[][] matriz, char simboloDef) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == simboloDef) {
                    return false;
                }
            }
        }
        return true;
    }

    public static char coincidenciaLinea(char[][] matriz, char simboloDef) {

        char simbolo;
        boolean coincidencia;

        for (int i = 0; i < matriz.length; i++) {
            // Reiniciamos la coincidencia
            coincidencia = true;
            // Cogemos el simbolo de la fila
            simbolo = matriz[i][0];
            if (simbolo != simboloDef) {
                for (int j = 1; j < matriz[0].length; j++) {
                    // sino coincide ya no habra ganadro en esta fila
                    if (simbolo != matriz[i][j]) {
                        coincidencia = false;
                    }
                }
                // Si no se mete en el if, devuelvo el simbolo ganador
                if (coincidencia) {
                    return simbolo;
                }
            }
        }
        // Si no hay ganador, devuelvo el simbolo por defecto
        return simboloDef;
    }

    public static char coincidenciaColumna(char[][] matriz, char simboloDef) {

        char simbolo;
        boolean coincidencia;

        for (int j = 0; j < matriz.length; j++) {
            // Reiniciamos la coincidencia
            coincidencia = true;
            // Cogemos el simbolo de la columna
            simbolo = matriz[0][j];
            if (simbolo != simboloDef) {
                for (int i = 1; i < matriz[0].length; i++) {
                    // sino coincide ya no habra ganadro en esta fila
                    if (simbolo != matriz[i][j]) {
                        coincidencia = false;
                    }
                }
                // Si no se mete en el if, devuelvo el simbolo ganador
                if (coincidencia) {
                    return simbolo;
                }
            }
        }
        // Si no hay ganador, devuelvo el simbolo por defecto
        return simboloDef;

    }

    public static char coincidenciaDiagonal(char[][] matriz, char simboloDef) {

        char simbolo;
        boolean coincidencia = true;

        // Diagonal principal
        simbolo = matriz[0][0];
        if (simbolo != simboloDef) {
            for (int i = 1; i < matriz.length; i++) {
                // sino coincide ya no habra ganadro en esta fila
                if (simbolo != matriz[i][i]) {
                    coincidencia = false;
                }
            }
            // Si no se mete en el if, devuelvo el simbolo ganador
            if (coincidencia) {
                return simbolo;
            }
        }
        // Diagonal inversa
        simbolo = matriz[0][2];
        if (simbolo != simboloDef) {
            for (int i = 1, j = 1; i < matriz.length; i++, j--) {
                // sino coincide ya no habra ganadro en esta fila
                if (simbolo != matriz[i][j]) {
                    coincidencia = false;
                }
            }
            // Si no se mete en el if, devuelvo el simbolo ganador
            if (coincidencia) {
                return simbolo;
            }
        }
        // Si no hay ganador, devuelvo el simbolo por defecto
        return simboloDef;
    }

    public static int pedirInteger(String mensaje, Scanner scanner) {
        System.out.println(mensaje);
        int numero = scanner.nextInt();
        numero -= 1;

        return numero;
    }

    private static void vaciarTablero(char[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = '-';
            }
        }
    }

    private static void mostrarTablero(char[][] tablero) {
        System.out.println(Colores.MORADO + "\n-------------");
        for (int i = 0; i < tablero.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print("" + Colores.ROJO + tablero[i][j] + Colores.MORADO + " | ");
            }
            System.out.println("\n-------------");
        }
        System.out.println(Colores.RESTART);
    }
}
