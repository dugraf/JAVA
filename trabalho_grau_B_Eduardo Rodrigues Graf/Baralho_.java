// EDUARDO RODRIGUES GRAF

import java.util.Random;

public class Baralho
{
    Carta[] c = new Carta[52];

    public void carta(Carta[] c)
    {
        /* ---------------------------- CRIANDO AS CARTAS --------------------------- */
        
        int cont = 0;

        for(int i = 0; i < c.length; i++)
        {
            if(cont < 13 && cont >= 0)
            {
                cont++;
                c[i] = new Carta(""+cont, null);
            }
            else
            {
                cont = 1;
                c[i] = new Carta(""+cont, null);
            }

            switch (c[i].getValor()) {
                case "1":
                    c[i].setValor("As");
                    break;
                case "11":
                    c[i].setValor("Valete");
                    break;
                case "12":
                    c[i].setValor("Damas");
                    break;
                case "13":
                    c[i].setValor("Reis");
                    break;
            
                default:
                    break;
            }
        }

        for(int i = 0; i < c.length; i++)
        {
            if(cont == 0)
            {
                c[i].setNaipe("Paus");
                cont++;
            }
            else if(cont == 1)
            {
                c[i].setNaipe("Espadas");
                cont++;
            }
            else if(cont == 2)
            {
                c[i].setNaipe("Ouros");
                cont++;
            }
            else
            {
                c[i].setNaipe("Copas");
                cont = 0;
            }
        }
    }

    public void embaralhaCartas(Carta[] c, int n)
    {
        /* ------------------------- EMBARALHANDO AS CARTAS ------------------------- */
        Random rand = new Random();

        for(int i = n - 1; i > 0; i--)
        {
            int nxt = rand.nextInt(i + 1);
            Carta temp = c[i];
            c[i] = c[nxt];
            c[nxt] = temp;
        }
    }

    public Carta[] distribuiCartas(Carta[] c, Carta[] mao, int cont)
    {
        /* --------------- DISTRIBUICAO DE CARTAS PARA OS 5 JOGADORES --------------- */
        for(int i = 0; i < mao.length; i++)
        {
            if(c[cont] != null)
            {
                mao[i] = c[cont];
                c[cont] = null;
                cont++;
            }
        }
        return mao;
    }
}
