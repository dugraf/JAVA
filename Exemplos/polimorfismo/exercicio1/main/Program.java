package polimorfismo.exercicio1.main;

import java.util.ArrayList;
import java.util.List;

import input.Input;
import polimorfismo.exercicio1.entities.Employee;
import polimorfismo.exercicio1.entities.OutsourcedEmployee;

public class Program
{
    public static void main(String[] args)
    {
        List<Employee> employees = new ArrayList<>();
        int numEmployees = Input.inputInt("Enter the number of employees");

        for (int i = 0; i < numEmployees; i++)
        {
            System.out.println("Outsourced (y/n)?");
            char outsourced = Input.inputChar();
            String name = Input.inputString("Name: ");
            int hours = Input.inputInt("Hours:");
            double valuePerHour = Input.inputDouble("Value per hour: ");

            if(outsourced == 'y')
            {
                double additionalCharge = Input.inputDouble("Additional charge: ");
                Employee employee = new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge);
                employees.add(employee);
            }
            else
                employees.add(new Employee(name, hours, valuePerHour));
        }

        for (Employee employee : employees)
        {
            System.out.println(employee);
        }
    }
}