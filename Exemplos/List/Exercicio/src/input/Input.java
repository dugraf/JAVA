package list.Exercicio.src.input;

import java.util.Scanner;

public class Input
{
    private static Scanner sc = new Scanner(System.in);

    public static int inputInt(String text)
    {
        System.out.println(text);
        int input = sc.nextInt();
        return input;
    }

    public static String inputString(String text)
    {
        System.out.println(text);
        String input = sc.next();
        return input;
    }

    public static double inputDouble(String text)
    {
        System.out.println(text);
        double input = sc.nextDouble();
        return input;
    }
}
