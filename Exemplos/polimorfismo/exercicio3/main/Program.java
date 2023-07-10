package polimorfismo.exercicio3.main;

import java.util.ArrayList;
import java.util.List;

import input.Input;
import polimorfismo.exercicio3.entities.Contributor;
import polimorfismo.exercicio3.entities.Legal;
import polimorfismo.exercicio3.entities.Physical;

public class Program
{
    public static void main(String[] args)
    {
        List<Contributor> contributors = new ArrayList<>();

        int numContributors = Input.inputInt("Enter the number of tax payers: ");

        for (int i = 0; i < numContributors; i++)
        {
            System.out.println("Tax payer #" +(i + 1)+ " data:");
            System.out.println("Physical or legal (p/l)?");
            char typeCompany = Input.inputChar();
            String name = Input.inputString("Name: ");
            double annualIncome = Input.inputDouble("Anual income: ");
            if(typeCompany == 'p')
            {
                double healthExpenses = Input.inputDouble("Health expenditures: ");
                contributors.add(new Physical(name, annualIncome, healthExpenses));
            }
            else if(typeCompany == 'l')
            {
                int numEmployees = Input.inputInt("Number of employees: ");
                contributors.add(new Legal(name, annualIncome, numEmployees));
            }
        }

        System.out.println("TAXES PAID");
        double sum = 0;
        for (Contributor contributor : contributors)
        {
            System.out.println(contributor);
            sum += contributor.tax();
        }

        System.out.println("TOTAL TAXES: " +sum);
    }
}
