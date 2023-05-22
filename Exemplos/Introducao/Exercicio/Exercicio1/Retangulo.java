package Exercicio.Exercicio1;

public class Retangulo
{
    private double width, height;

    public double area(double width, double height)
    {
        return width * height;
    }

    public double perimeter(double width, double height)
    {
        return (width + height) * 2;
    }

    public double diagonal(double width, double height)
    {
        return Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2));
    }
}
