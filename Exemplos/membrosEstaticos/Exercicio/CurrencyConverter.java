package membrosEstaticos.Exercicio;

public class CurrencyConverter
{
    private static final double IOF = 0.06;

    public static double converter(double dollarPrice, double dollarBought)
    {
        return dollarPrice * dollarBought + (dollarPrice / IOF);
    }
}
