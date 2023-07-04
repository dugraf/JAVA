package list.Exercicio.src.app;

import java.util.ArrayList;
import java.util.List;

import list.Exercicio.src.entities.Employee;
import list.Exercicio.src.input.Input;

public class Program
{
    public static void main(String[] args)
    {
        int amount = Input.inputInt("How many employees will be registered?");
        List<Employee> list = new ArrayList<>();

        for(int i = 0; i < amount; i++)
        {
            System.out.println("Employee #" +(i + 1));
            int id = Input.inputInt("Id: ");
            String name = Input.inputString("Name: ");
            double salary = Input.inputDouble("Salary: ");
            Employee employee = new Employee(id, name, salary);
            list.add(employee);
        }

        int employeeSelected = Input.inputInt("Enter the employee id that will have salary increase: ");
        while(!employeeExists(list, employeeSelected))
            employeeSelected = Input.inputInt("Enter the employee id that will have salary increase: ");

        double percent = Input.inputDouble("Enter the percentage");

        for(int i = 0; i < list.size(); i++)
            if(list.get(i).getId() == employeeSelected)
                list.get(i).setSalary((list.get(i).getSalary() + (list.get(i).getSalary() * percent) / 100));

        
        System.out.println("\nList of employees");
        for (Employee employee : list) {
            System.out.println(employee);
        }
    }

    public static boolean employeeExists(List<Employee> list, int employeeSelected)
    {
        for (int i = 0; i < list.size(); i++)
            if(list.get(i).getId() == employeeSelected)
                return true;
        return false;
    }
}
