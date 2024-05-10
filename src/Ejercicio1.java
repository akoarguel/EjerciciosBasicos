import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio1 {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));

        String rojo = "\033[31m";
        //String verde = "\033[32m";
        //String naranja = "\033[33m";
        String azul = "\033[34m";
        //String morado = "\033[35m";
        //String blanco = "\033[37m";

        double x1, x2;
        double a, b, c;

        System.out.println("INTRODUCE EL VALOR DE 'a'");
        a = Double.parseDouble(scanner.readLine());
        System.out.println("INTRODUCE EL VALOR DE 'b'");
        b = Double.parseDouble(scanner.readLine());
        System.out.println("INTRODUCE EL VALOR DE 'c'");
        c = Double.parseDouble(scanner.readLine());

        double det = ((b*b)-2*a*c);

        if (det < 0) {
            System.out.println("NO TIENE SOLUCION REAL. ");
        } else {
            x1 = ((-b+Math.sqrt(det))/2*a);
            x2 = ((-b-Math.sqrt(det))/2*a);
            System.out.printf(rojo + "x1 = %.2f", x1);
            System.out.println();
            System.out.printf(azul + "x2 = %.2f", x2);
        }

        scanner.close();    
    }
}
