package polimorfismo.exercicio2.entities;

public class ImportedProduct extends Product
{
    private double customFee;

    public ImportedProduct(String name, double price, double customFee) {
        super(name, price);
        this.customFee = customFee;
    }

    public double getCustomFee() {
        return customFee;
    }

    public void setCustomFee(double customFee) {
        this.customFee = customFee;
    }

    public double totalPrice()
    {
        return getPrice() + customFee;
    }

    @Override
    public String priceTag()
    {
        return getName()+ " $" +totalPrice()+ " (Customs fee: $" +customFee+ ")";
    }
}