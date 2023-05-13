import java.util.Locale;
import java.util.Scanner;

public class Ex01
{
    public static void main(String[] args)
    {
        Locale.setDefault(Locale.US);
        //System.out.println("SOMA = " +Ex01());
        //System.out.printf("Area do circulo: %.4f" ,Ex02());
        //Ex03();
        //Ex04();
        Ex05();
    }

    public static int Ex01()
    {
        Scanner sc = new Scanner(System.in);
        int val1, val2;

        val1 = sc.nextInt();
        val2 = sc.nextInt();
        sc.close();

        return val1 + val2;
    }

    public static double Ex02()
    {
        Scanner sc = new Scanner(System.in);
        double pi = Math.PI;
        System.out.println("Valor do raio: ");
        double raio = sc.nextDouble();
        sc.close();

        return pi * (raio * raio);
    }

    public static void Ex03()
    {
        Scanner sc = new Scanner(System.in);
        int a, b, c, d;

        System.out.println("Valor A: ");
        a = sc.nextInt();
        System.out.println("Valor B: ");
        b = sc.nextInt();
        System.out.println("Valor C: ");
        c = sc.nextInt();
        System.out.println("Valor D: ");
        d = sc.nextInt();

        int operacao = a * b - c * d;

        System.out.println("OPERACAO: A * B - C * D = " +operacao);
        sc.close();
    }

    public static void Ex04()
    {
        Scanner sc = new Scanner(System.in);
        int i = 2;
        double vlrFinal = 0;

        while(i > 0)
        {
            int codPeca = sc.nextInt();
            int qntPeca = sc.nextInt();
            double vlrPeca = sc.nextDouble();
    
            double vlr = qntPeca * vlrPeca;
            vlrFinal += +vlr;
            i--;
        }

        System.out.printf("Valor a pagar: %.2f",vlrFinal);
    }

    public static void Ex05()
    {
        Scanner sc = new Scanner(System.in);
        double pi = Math.PI;
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();

        System.out.printf("TRIANGULO: %.3f",(a * c)/ 2);
        System.out.printf("\nCIRCULO: %.3f",pi * c * c);
        System.out.printf("\nTRAPEZIO: %.3f",((a + b) * c)/2);
        System.out.printf("\nQUADRADO: %.3f",b * b);
        System.out.printf("\nRETANGULO: %.3f",a * b);

        sc.close();
    }
}