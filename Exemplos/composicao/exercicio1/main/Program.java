package composicao.exercicio1.main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import composicao.exercicio1.entities.Department;
import composicao.exercicio1.entities.HourContract;
import composicao.exercicio1.entities.Worker;
import composicao.exercicio1.entities.enums.WorkerLevel;
import input.Input;

public class Program
{
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yyyy");
    public static void main(String[] args)
    {
        Department department = new Department(Input.inputString("Enter department`s name: "));
        System.out.println("Enter worker data:");

        String name = Input.inputString("Name: ");
        String level = Input.inputString("Level: ").toUpperCase();
        double baseSalary = Input.inputDouble("Base Salary: ");
        Worker worker = new Worker(name, WorkerLevel.valueOf(level), baseSalary);

        //
        int contractsQnt = Input.inputInt("How many contracts to this worker? "); 
        for (int i = 0; i < contractsQnt; i++)
        {
            System.out.println("Enter contract #" +(i + 1)+ " data:");
            String dateString = Input.inputString("Date (DD/MM/YYYY):");
            LocalDate date = dateCompleteConverter(dateString);
            double valuePerHour = Input.inputDouble("Value per hour: ");
            int duration = Input.inputInt("Duration: (hours)");

            HourContract contract = new HourContract(date, valuePerHour, duration);
            worker.addContract(contract);
        }
        //

        String dateString = Input.inputString("Enter month and year to calculate income (MM/YYYY)");
        LocalDate date = dateMonthYearConverter(dateString);
        System.out.println("Name: " +worker.getName());
        System.out.println("Department: " +department.getName());
        System.out.println("Income for " +date.format(formatter)+ ": " +worker.income(date.getYear(), date.getMonthValue()));
    }

    private static LocalDate dateCompleteConverter(String dateString)
    {
        int day = Integer.parseInt(dateString.substring(0, 2));
        int month = Integer.parseInt(dateString.substring(3, 5));
        int year = Integer.parseInt(dateString.substring(6));
        return LocalDate.of(year, month, day);
    }

    private static LocalDate dateMonthYearConverter(String dateString)
    {
        int month = Integer.parseInt(dateString.substring(0, 2));
        int year = Integer.parseInt(dateString.substring(3));
        return LocalDate.of(year, month, 1);
    }

}
