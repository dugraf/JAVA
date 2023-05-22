import java.util.Locale;
import java.util.Scanner;

public class Entrada
{
    public static void main(String[] args)
    {
        textoQuebraLinha();
    }

    public static void texto()
    {
        Scanner sc = new Scanner(System.in);
        String x;

        x = sc.next();

        System.out.println("Voce digitou " +x);
        sc.close();
    }

    public static void inteiro()
    {
        Scanner sc = new Scanner(System.in);
        int x;

        x = sc.nextInt(); //INTEIRO

        System.out.println("Voce digitou " +x);
        sc.close();
    }

    public static void flutuante()
    {
        Locale.setDefault(Locale.US); //LOCALIDADE AMERICANA PARA SER "." O PONTO FLUTUANTE
        Scanner sc = new Scanner(System.in);
        double x;

        x = sc.nextDouble(); //DOUBLE

        System.out.println("Voce digitou " +x);
        sc.close();
    }

    public static void caractere()
    {
        Scanner sc = new Scanner(System.in);
        char x;

        x = sc.next().charAt(0);

        System.out.println("Voce digitou " +x);
        sc.close();
    }

    public static void textoQuebraLinha()
    {
        Scanner sc = new Scanner(System.in);
        String s1, s2, s3;

        s1 = sc.nextLine();
        s2 = sc.nextLine();
        s3 = sc.nextLine();

        System.out.println("DADOS DIGITADOS:");
        System.out.println(s1+ "\n" +s2+ "\n" +s3);
    }
}