package matrices.EjercicioPokemon;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException, InterruptedException {
        Scanner sn = new Scanner(System.in);
        int opcion = 0, tipo1, tipo2, tipo3, num_tipos;
        do {
            System.out.print(Constantes.RESTART);
            menu();
            System.out.println("\nElige una opción: ");
            opcion = sn.nextInt();
            switch (opcion) {
                case 1:
                    do {
                        System.out.println("\n¿VAS A INTRODUCIR 1 O 2 TIPOS? ");
                        num_tipos = sn.nextInt();
                        if (!(num_tipos == 1 || num_tipos == 2)) {
                            System.out.print(Constantes.ROJO + "\nERROR.");
                            System.out.print(Constantes.RESTART + " DEBES INTRODUCIR 1 o 2: ");
                        }
                    } while (!(num_tipos == 1 || num_tipos == 2));
                    System.out.println("\nPRIMER TIPO DE POKEMON: ");
                    tipo1 = elegirTipo(sn);
                    if (num_tipos == 2) {
                        do {
                            System.out.println("\nSEGUNDO TIPO DE POKEMON: ");
                            tipo2 = elegirTipo(sn);
                            if (tipo2 == tipo1) {
                                System.out.print(Constantes.ROJO + "ERROR.");
                                System.out.print(Constantes.RESTART + "LOS TIPOS NO DEBEN SER IGUALES: ");
                            }
                        } while (tipo2 == tipo1);
                        mostrarDebilidades(tipo1, tipo2);
                    } else {
                        mostrarDebilidades(tipo1);
                    }
                    break;
                case 2:
                    System.out.println("\nTIPO DE POKEMON ATACANTE: ");
                    tipo1 = elegirTipo(sn);
                    mostrarEficaces(tipo1);
                    break;
                case 3:
                    System.out.println("\nTIPO DE POKEMON: ");
                    tipo1 = elegirTipo(sn);
                    mostrarInfo(tipo1);
                    break;
                case 4:
                    do {

                        System.out.println("\nElije el numero de tipos del oponente, solo 1 o 2");
                        num_tipos = sn.nextInt();

                        if (!(num_tipos == 1 || num_tipos == 2)) {
                            System.out.println("\nTienes que introducir 1 o 2");
                        }

                    } while (!(num_tipos == 1 || num_tipos == 2));

                    System.out.println("\nPokemon atacante");
                    tipo1 = elegirTipo(sn);

                    System.out.println("\nPrimer tipo del pokemon oponente");
                    tipo2 = elegirTipo(sn);

                    if (num_tipos == 2) {

                        do {

                            System.out.println("\nSegundo tipo del pokemon oponente");
                            tipo3 = elegirTipo(sn);
                            if (tipo3 == tipo2) {
                                System.out.println("\nLos tipos no deben ser iguales");
                            }

                        } while (tipo2 == tipo3);

                        mostrarEficaciaTipo(tipo1, tipo2, tipo3);
                    } else {
                        mostrarEficaciaTipo(tipo1, tipo2);
                    }
                    break;
                case 0:
                    Thread.sleep(150);
                    System.out.print(Constantes.ROJO + "\nSALIENDO ");
                    Thread.sleep(150);
                    System.out.print(Constantes.MORADO + ". ");
                    Thread.sleep(150);
                    System.out.print(Constantes.AZUL + ". ");
                    Thread.sleep(150);
                    System.out.print(Constantes.CIAN + ". ");
                    Thread.sleep(150);
                    break;
                default:

                    break;
            }
        } while (opcion != 0);
    }

    public static void mostrarEficaciaTipo(int tipoAtacante, int tipoOponente) {
        System.out.println(mostrarEficacia(Constantes.efectividadesPokemon[tipoAtacante][tipoOponente]));
    }

    public static void mostrarEficaciaTipo(int tipoAtacante, int tipo1Oponente, int tipo2Oponente) {
        double efectividad = Constantes.efectividadesPokemon[tipoAtacante][tipo1Oponente]
                * Constantes.efectividadesPokemon[tipoAtacante][tipo2Oponente];
        System.out.println(mostrarEficacia(efectividad));
    }

    private static void mostrarInfo(int tipo) {
        for (int i = 0; i < Constantes.efectividadesPokemon.length; i++) {
            System.out.println(Constantes.MORADO + "--> " + Constantes.tiposPokemon[i] + "  "
                    + mostrarEficacia(Constantes.efectividadesPokemon[tipo][i]));
        }
    }

    private static void mostrarEficaces(int tipo) {
        for (int i = 0; i < Constantes.efectividadesPokemon.length; i++) {
            if (Constantes.efectividadesPokemon[tipo][i] == Constantes.EFICACIA_EME) {
                System.out.println(Constantes.MORADO + "--> " + Constantes.tiposPokemon[i]);
            }
        }
    }

    private static void mostrarDebilidades(int tipo) {
        for (int i = 0; i < Constantes.efectividadesPokemon.length; i++) {
            if (Constantes.efectividadesPokemon[i][tipo] == Constantes.EFICACIA_EME) {
                System.out.println(Constantes.MORADO + "--> " + Constantes.tiposPokemon[i]);
            }
        }
    }

    public static void mostrarDebilidades(int tipo1, int tipo2) {

        double efectividadFinal = 0;

        for (int i = 0; i < Constantes.efectividadesPokemon.length; i++) {

            efectividadFinal = Constantes.efectividadesPokemon[i][tipo1] * Constantes.efectividadesPokemon[i][tipo2];

            if (efectividadFinal >= Constantes.EFICACIA_EME) {
                System.out.println(
                        Constantes.MORADO + "--> " + Constantes.tiposPokemon[i] + ": x" + (int) efectividadFinal);
            }
        }
    }

    public static String mostrarEficacia(double eficacia) {

        String mensaje;

        if (eficacia == Constantes.EFICACIA_DE) {
            mensaje = Constantes.MENSAJES_EFICACIAS[Constantes.INDICE_DE];
        } else if (eficacia == Constantes.EFICACIA_EME) {
            mensaje = Constantes.MENSAJES_EFICACIAS[Constantes.INDICE_EME];
        } else if (eficacia == Constantes.EFICACIA_NEUTRO) {
            mensaje = Constantes.MENSAJES_EFICACIAS[Constantes.INDICE_NEUTRO];
        } else if (eficacia == Constantes.EFICACIA_NME) {
            mensaje = Constantes.MENSAJES_EFICACIAS[Constantes.INDICE_NME];
        } else if (eficacia == Constantes.EFICACIA_DNE) {
            mensaje = Constantes.MENSAJES_EFICACIAS[Constantes.INDICE_DNE];
        } else {
            mensaje = Constantes.MENSAJES_EFICACIAS[Constantes.INDICE_NA];
        }

        return mensaje;

    }

    private static void listarTipos() {
        System.out.println();
        for (int i = 0; i < Constantes.tiposPokemon.length; i++) {
            System.out.println(i + ". " + Constantes.tiposPokemon[i]);
        }

    }

    public static int elegirTipo(Scanner sn) {

        int eleccion;
        listarTipos();

        do {
            eleccion = sn.nextInt();

            if (!(eleccion >= 0 && eleccion < Constantes.tiposPokemon.length)) {
                System.out.println("\nTiene que estar entre 0 y 17");
            }

        } while (!(eleccion >= 0 && eleccion < Constantes.tiposPokemon.length));

        return eleccion;

    }

    private static void menu() {
        System.out.println(Constantes.BLANCO + "\n        ||  MENU  ||        ");
        System.out.println(Constantes.CIAN + "\n1. MOSTRAR DEBILIDADES");
        System.out.println(Constantes.VERDE + "2. MOSTRAR EFICACIAS");
        System.out.println(Constantes.AMARILLO + "3. MOSTRAR TODA LA INFORMACIÓN DE UN TIPO");
        System.out.println(Constantes.MORADO + "4. EFICACIA DE UN TIPO A OTRO");
        System.out.println(Constantes.ROJO + "\n0. SALIR");
        System.out.println(Constantes.RESTART);
    }
}
