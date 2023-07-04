package membrosEstaticos;

import java.util.Locale;
import java.util.Scanner;

public class MembrosEstaticos
{
    public static void main(String[] args)
    {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter radius: ");
        double radius = sc.nextDouble();
        double c = Operacao.circumference(radius);
        double v = Operacao.volume(radius);

        System.out.printf("Circumference: %.2f%n", c);
        System.out.printf("Volume: %.2f%n", v);
        System.out.printf("PI value: %.2f%n", Operacao.PI);

        sc.close();
    }
}
