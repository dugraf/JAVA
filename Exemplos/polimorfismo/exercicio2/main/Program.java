package polimorfismo.exercicio2.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import input.Input;
import polimorfismo.exercicio2.entities.ImportedProduct;
import polimorfismo.exercicio2.entities.Product;
import polimorfismo.exercicio2.entities.UsedProduct;

public class Program
{
    public static void main(String[] args)
    {
        int numProducts = Input.inputInt("Enter the number of products:");
        List<Product> products = new ArrayList<>();

        for (int i = 0; i < numProducts; i++)
        {
            System.out.println("Product #" +(i + 1)+ " data:");
            System.out.println("Common, used or imported (c/u/i) ?");
            char typeProduct = Input.inputChar();
            String name = Input.inputString("Name: ");
            double price = Input.inputDouble("Price: ");

            if(typeProduct == 'c')
                products.add(new Product(name, price));
            else if(typeProduct == 'u')
            {
                String manufactureString = Input.inputString("Manufacture date (DD/MM/YYYY)");
                LocalDate manufactureDate = dateConverter(manufactureString);
                products.add(new UsedProduct(name, price, manufactureDate));
            }
            else if(typeProduct == 'i')
            {
                double customFee = Input.inputDouble("Customs fee: ");
                products.add(new ImportedProduct(name, price, customFee));
            }
        }

        System.out.println("PRICE TAGS:");
        for (Product product : products)
        {
            System.out.println(product);
        }
    }

    private static LocalDate dateConverter(String dateString)
    {
        int day = Integer.parseInt(dateString.substring(0, 2));
        int month = Integer.parseInt(dateString.substring(3, 5));
        int year = Integer.parseInt(dateString.substring(6));
        return LocalDate.of(year, month, day);
    }
}
