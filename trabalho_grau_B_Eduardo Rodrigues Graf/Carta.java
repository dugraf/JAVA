// EDUARDO RODRIGUES GRAF

public class Carta
{
    private String valor, naipe;

    public Carta(){}
    
    public Carta(String valor, String naipe)
    {
        this.valor = valor;
        this.naipe = naipe;
    }

    public String getValor()
    {
        return this.valor;
    }

    public void setValor(String valor)
    {
        this.valor = valor;
    }

    public String getNaipe()
    {
        return this.naipe;
    }

    public void setNaipe(String naipe)
    {
        this.naipe = naipe;
    }

    public String toString()
    {
        return "[" +valor+ " de " +naipe+ "]";
    }
}