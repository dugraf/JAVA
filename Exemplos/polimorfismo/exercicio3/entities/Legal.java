package polimorfismo.exercicio3.entities;

public class Legal extends Contributor
{
    private int numEmployees;

    public Legal(String name, double annualIncome, int numEmployees) {
        super(name, annualIncome);
        this.numEmployees = numEmployees;
    }

    public int getNumEmployees() {
        return numEmployees;
    }

    public void setNumEmployees(int numEmployees) {
        this.numEmployees = numEmployees;
    }

    @Override
    public double tax()
    {
        if(numEmployees > 10)
            return getAnnualIncome() * 0.14;
        else
            return getAnnualIncome() * 0.16;
    }

}
