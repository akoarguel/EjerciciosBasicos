/* 
Queremos realizar una encuesta a 10 personas, en esta encuesta indicaremos el sexo 
(1=masculino, 2=femenino), si trabaja (1=si trabaja, 2= no trabaja) y su sueldo (si tiene un trabajo, sino sera un cero) estará entre 600 y 2000 (valor entero). 
Los valores pueden ser generados aleatoriamente. Calcula y muestra lo siguiente:

Porcentaje de hombres (tengan o no trabajo).
Porcentaje de mujeres (tengan o no trabajo).
Porcentaje de hombres que trabajan.
Porcentaje de mujeres que trabajan.
El sueldo promedio de las hombres que trabajan.
EL sueldo promedio de las mujeres que trabajan.
Usa todos los métodos que veas necesarios, piensa que es aquello que se repite o que puede ser mejor tenerlo por separado.
*/

package matrices;

public class Ejercicio11 {
    public static void main(String[] args) {
        System.out.println();
        int encuestados = 10;
        int[][] lista = new int[3][encuestados];

        ingresarSexo(lista);
        ingresarTrabajo(lista);
        ingresarSalario(lista);
        imprimirArray(lista);
        
        System.out.println("\nHay un " + procentajeSexo(lista, 1) + "% de hombres. ");
        System.out.println("Hay un " + procentajeSexo(lista, 2) + "% de mujeres. ");

        System.out.println("\n");
    }

    

    private static void imprimirArray(int[][] lista) {
        for (int i = 0; i < lista.length; i++) {
            for (int j = 0; j < lista[i].length; j++) {
                System.out.print(lista[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static double procentajeSexo(int[][] lista, int i) {
        int contador = 0;
        for (int j = 0; j < lista[0].length; j++) {
            if (lista[0][j] == i) {
                contador+=1;
            }
        }
        double porcentaje = (contador*100)/lista[0].length;
        return porcentaje;
    }



    private static void ingresarSexo(int[][] lista) {
        for (int j = 0; j < lista[0].length; j++) {
            int num = (int) Math.floor(Math.random() * 2 + 1);
            lista[0][j] = num;
        }
    }

    private static void ingresarTrabajo(int[][] lista) {
        for (int j = 0; j < lista[1].length; j++) {
            int num = (int) Math.floor(Math.random() * 2 + 1);
            lista[1][j] = num;
        }
    }

    private static void ingresarSalario(int[][] lista) {
        for (int i = 0; i < lista[1].length; i++) {
            for (int j = 0; j < lista[2].length; j++) {
                if (lista[1][j] == 2) {
                    lista[2][j] = 0;
                } else {
                    int num = (int) Math.floor(Math.random() * 600 + 2000);
                    lista[2][j] = num;
                }
            }
        }
    }
}
