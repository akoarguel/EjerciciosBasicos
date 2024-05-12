package matrices.EjercicioPokemon;

public class Constantes {

    public static String NEGRO = "\u001B[30m";
    public static String ROJO = "\u001B[31m";
    public static String VERDE = "\u001B[32m";
    public static String AMARILLO ="\u001B[33m";
    public static String AZUL = "\u001B[34m";
    public static String MORADO = "\u001B[35m";
    public static String CIAN = "\u001B[36m";
    public static String BLANCO = "\u001B[37m";
    public static String RESTART = "\u001B[0m";
     
    /*Tipos actuales de pokemon*/
    public static String[] tiposPokemon = {
                                            "ACERO", 
                                            "AGUA", 
                                            "BICHO",
                                            "DRAGÓN",
                                            "ELÉCTRICO",
                                            "FANTASMA",
                                            "FUEGO",
                                            "HADA",
                                            "HIELO",
                                            "LUCHA",
                                            "NORMAL",
                                            "PLANTA",
                                            "PSÍQUICO",
                                            "ROCA",
                                            "SINIESTRO",
                                            "TIERRA",
                                            "VENENO",
                                            "VOLADOR"
                                          };
     
    /*Mensaje segun la eficacia*/
    public static String[] MENSAJES_EFICACIAS = {
                                                    AMARILLO + "NO ES MUY EFICAZ", 
                                                    BLANCO + "NEUTRO", 
                                                    VERDE + "ES MUY EFICAZ", 
                                                    NEGRO + "NO AFECTA",
                                                    MORADO + "DOBLEMENTE EFICAZ", 
                                                    ROJO + "DOBLEMENTE NO MUY EFICAZ"
                                                };
  
    /*INDICES de los mensaje anteriores
        Asi no debes recordar en que posicion esta cada uno
    */
     
    public static int INDICE_NME=0;
    public static int INDICE_NEUTRO=1;
    public static int INDICE_EME=2;
    public static int INDICE_NA=3;
    public static int INDICE_DE=4;
    public static int INDICE_DNE=5;
     
    /*Eficiacias*/
     
    public static double EFICACIA_DE=4; /*DOBLEMENTE EFICAZ*/
    public static double EFICACIA_EME=2; /*ES MUY EFICAZ*/
    public static double EFICACIA_NEUTRO=1;
    public static double EFICACIA_NME=0.5; /*NO ES MUY EFICAZ*/
    public static double EFICACIA_DNE=0.25; /*DOBLEMENTE NO ES EFICAZ*/
    public static double EFICACIA_NA=0;  /*NO AFECTA*/
     
    /*
        FILAS = Pokemon atacante
        COLUMNAS = Pokemon que recibe el ataque
         
        Significados de los números:
            - 0.5: el atacante hace la mitad de daño al oponente (No es muy eficaz) 
            - 1: el atacante hace un daño neutro al oponente (No se da información pero diremos neutro)
            - 2: el atacante hace el doble de daño al oponente (Es muy eficaz)
            - 0: el atacante hace un daño nulo al oponente (No afecta)
 
    */
    public static double[][] efectividadesPokemon = {
         
        /*ACERO   AGUA   BICHO   DRAGON   ELÉC   FANT   FUEGO   HADA   HIELO   LUCHA   NORMAL   PLANTA   PSI   ROCA   SINIE  TIERRA   VENENO   VOLADOR   */
         
        { 0.5   , 0.5  ,   1   ,   1    , 0.5  ,  1   ,  0.5   ,  2  ,   2   ,   1   ,    1    ,   1   ,  1   ,  2  ,   1   ,   1   ,    1   ,   1},   //ACERO
        {  1    , 0.5  ,   1   ,  0.5   ,  1   ,  1   ,   2    ,  1  ,   1   ,   1   ,    1    ,  0.5  ,  1   ,  2  ,   1   ,   2   ,    1   ,   1},   //AGUA
        { 0.5   ,  1   ,   1   ,   1    ,  1   , 0.5  ,  0.5   , 0.5 ,   1   ,  0.5  ,    1    ,   2   ,  2   ,  1  ,   2   ,   1   ,   0.5  ,  0.5},  //BICHO
        { 0.5   ,  1   ,   1   ,   2    ,  1   ,  1   ,   1    ,  0  ,   1   ,   1   ,    1    ,   1   ,  1   ,  1  ,   1   ,   1   ,    1   ,   1},   // DRAGÓN
        {  1    ,  2   ,   1   ,  0.5   , 0.5  ,  1   ,   1    ,  1  ,   1   ,   1   ,    1    ,  0.5  ,  1   ,  1  ,   1   ,   0   ,    1   ,   2},   // ELÉCTRICO
        {  1    ,  1   ,   1   ,   1    ,  1   ,  2   ,   1    ,  1  ,   1   ,   1   ,    0    ,   1   ,  2   ,  1  ,  0.5  ,   1   ,    1   ,   1},   // FANTASMA
        {  2    , 0.5  ,   2   ,  0.5   ,  1   ,  1   ,  0.5   ,  1  ,   2   ,   1   ,    1    ,   2   ,  1   , 0.5 ,   1   ,   1   ,    1   ,   1},   // FUEGO
        { 0.5   ,  1   ,   1   ,   2    ,  1   ,  1   ,  0.5   ,  1  ,   1   ,   2   ,    1    ,   1   ,  1   ,  1  ,   2   ,   1   ,   0.5  ,   1},   // HADA
        { 0.5   , 0.5  ,   1   ,   2    ,  1   ,  1   ,  0.5   ,  1  ,  0.5  ,   1   ,    1    ,   2   ,  1   ,  1  ,   1   ,   2   ,    1   ,   2},   // HIELO
        {  2    ,  1   ,  0.5  ,   1    ,  1   ,  0   ,   1    , 0.5 ,   2   ,   1   ,    2    ,   1   , 0.5  ,  2  ,   2   ,   1   ,   0.5  ,  0.5},  // LUCHA
        { 0.5   ,  1   ,   1   ,   1    ,  1   ,  0   ,   1    ,  1  ,   1   ,   1   ,    1    ,   1   ,  1   , 0.5 ,   1   ,   1   ,    1   ,   1},   // NORMAL
        { 0.5   ,  2   ,  0.5  ,  0.5   ,  1   ,  1   ,  0.5   ,  1  ,   1   ,   1   ,    1    ,  0.5  ,  1   ,  2  ,   1   ,   2   ,   0.5  ,  0.5},  // PLANTA
        { 0.5   ,  1   ,   1   ,   1    ,  1   ,  1   ,   1    ,  1  ,   1   ,   2   ,    1    ,   1   , 0.5  ,  1  ,   0   ,   1   ,    2   ,   1},   // PSÍQUICO
        { 0.5   ,  1   ,   2   ,   1    ,  1   ,  1   ,   2    ,  1  ,   2   ,  0.5  ,    1    ,   1   ,  1   ,  1  ,   1   ,  0.5  ,    1   ,   2},   // ROCA
        {  1    ,  1   ,   1   ,   1    ,  1   ,  2   ,   1    , 0.5 ,   1   ,  0.5  ,    1    ,   1   ,  2   ,  1  ,  0.5  ,   1   ,    1   ,   1},   // SINIESTRO
        {  2    ,  1   ,  0.5  ,   1    ,  2   ,  1   ,   2    ,  1  ,   1   ,   1   ,    1    ,  0.5  ,  1   ,  2  ,   1   ,   1   ,    2   ,   0},   // TIERRA
        {  0    ,  1   ,   1   ,   1    ,  1   , 0.5  ,   1    ,  2  ,   1   ,   1   ,    1    ,   2   ,  1   , 0.5 ,   1   ,  0.5  ,   0.5  ,   1},   // VENENO
        { 0.5   ,  1   ,   2   ,   1    , 0.5  ,  1   ,   1    ,  1  ,   1   ,   2   ,    1    ,   2   ,  1   , 0.5 ,   1   ,   1   ,    1   ,   1}    // VOLADOR
    };
     
     
}