package composicao.exercicio1.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import composicao.exercicio1.entities.enums.WorkerLevel;

public class Worker
{
    private String name;
    private WorkerLevel workerLevel;
    private double baseSalary;

    private List<HourContract> contracts = new ArrayList<>();
    private Department department;


    public Worker(String name, WorkerLevel workerLevel, double baseSalary) {
        this.name = name;
        this.workerLevel = workerLevel;
        this.baseSalary = baseSalary;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public WorkerLevel getWorkerLevel() {
        return workerLevel;
    }
    public void setWorkerLevel(WorkerLevel workerLevel) {
        this.workerLevel = workerLevel;
    }
    public double getSalary() {
        return baseSalary;
    }
    public void setSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }
    public List<HourContract> getContracts() {
        return contracts;
    }
    public Department getDepartment() {
        return department;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", workerLevel='" + getWorkerLevel() + "'" +
            ", salary='" + getSalary() + "'" +
            "}";
    }

    public void addContract(HourContract contract)
    {
        contracts.add(contract);
    }

    public void removeContract(HourContract contract)
    {
        contracts.remove(contract);
    }

    public double income(int year, int month)
    {
        double sum = baseSalary;
        LocalDate dateIncome = LocalDate.of(year, month, 1);

        for (int i = 0; i < contracts.size(); i++)
        {
            int yearContract = contracts.get(i).getDate().getYear();
            int monthContract = contracts.get(i).getDate().getMonthValue();
            if(dateIncome.getYear() == yearContract && dateIncome.getMonthValue() == monthContract)
                sum += contracts.get(i).totalValue();
        }
        return sum;
    }
}
