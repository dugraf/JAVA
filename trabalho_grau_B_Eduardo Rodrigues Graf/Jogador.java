// EDUARDO RODRIGUES GRAF

public class Jogador
{
    private String nome;
    private int fichas, vlr_aposta;
    private Carta[] cartas;
    private char funcao;
    private boolean player;

    public Jogador(){}

    public Jogador(String nome, int fichas, Carta[] cartas, char funcao, boolean player, int vlr_aposta)
    {
        this.nome = nome;
        this.fichas = fichas;
        this.cartas = cartas;
        this.funcao = funcao;
        this.player = player;
        this.vlr_aposta = vlr_aposta;
    }

    public String getNome()
    {
        return this.nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public int getFichas()
    {
        return this.fichas;
    }

    public void setFichas(int fichas)
    {
        this.fichas = fichas;
    }

    public Carta[] getCartas()
    {
        return this.cartas;
    }

    public void setCartas(Carta[] cartas)
    {
        this.cartas = cartas;
    }

    public char getFuncao()
    {
        return funcao;
    }

    public void setPlayer(boolean player)
    {
        this.player = player;
    }

    public boolean isPlayer()
    {
        return player;
    }

    public void setFuncao(char funcao)
    {
        this.funcao = funcao;
    }

    public int getVlr_aposta()
    {
        return vlr_aposta;
    }

    public void setVlr_aposta(int vlr_aposta)
    {
        this.vlr_aposta = vlr_aposta;
    }

    public String toString()
    {
        String cartas_mao = "";
        for(int i = 0; i < 5; i++)
            cartas_mao += cartas[i] + " ";

        return "Nome: " +nome+ "\n Fichas: " +fichas+ "\n Cartas: " +cartas_mao;
    }

    public void imprimeCartas()
    {
        String cartas_mao = "";
        for(int i = 0; i < 5; i++)
            cartas_mao += cartas[i] + " ";

        System.out.println(cartas_mao);
    }
}
