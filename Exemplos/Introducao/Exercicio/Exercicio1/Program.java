package Exercicio.Exercicio1;

import java.util.Locale;
import java.util.Scanner;

public class Program
{
    public static void main(String[] args)
    {
        Locale.setDefault(Locale.US);
        Retangulo rectangle = new Retangulo();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter rectangle width and height:");
        double width = sc.nextDouble();
        double height = sc.nextDouble();

        double area = rectangle.area(width, height);
        double perimeter = rectangle.perimeter(width, height);
        double diagonal = rectangle.diagonal(width, height);

        System.out.println("AREA = " +area);
        System.out.println("PERIMETER = " +perimeter);
        System.out.printf("DIAGONAL = %.2f" ,diagonal);
    
        sc.close();
    }
}
