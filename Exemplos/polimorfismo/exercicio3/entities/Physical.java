package polimorfismo.exercicio3.entities;

public class Physical extends Contributor
{
    private double healthExpenses;

    public Physical(String name, double annualIncome, double healthExpenses) {
        super(name, annualIncome);
        this.healthExpenses = healthExpenses;
    }

    public double getHealthExpenses() {
        return healthExpenses;
    }

    public void setHealthExpenses(double healthExpenses) {
        this.healthExpenses = healthExpenses;
    }

    @Override
    public double tax()
    {
        if(getAnnualIncome() < 20000)
            return rebate(getAnnualIncome() * 0.15);
        else
            return rebate(getAnnualIncome() * 0.25);
    }

    public double rebate(double income)
    {
        if(healthExpenses > 0)
            return income - (healthExpenses * 0.5);
        else
            return income;
    }
}
