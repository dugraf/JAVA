// EDUARDO RODRIGUES GRAF

public class Principal
{
    public static void main(String[] args)
    {
        while(true)
        {

            System.out.println("****************************************************");
            System.out.println("*                BEM-VINDO AO POKER                *");
            System.out.println("****************************************************");

            System.out.println("1. JOGAR");
            System.out.println("2. REGRAS");

            int input = Teclado.leInt();

            if(input == 1)
            {
                Carta[] c = new Carta[52];
                Baralho b = new Baralho();
                Controle ctrl = new Controle();
                b.carta(c);
                int num_cartas = c.length;
                b.embaralhaCartas(c, num_cartas);
                int cont = 0;
                Jogador[] jogador = new Jogador[5];

                /* -------------------- DISTRIBUINDO CARTAS EM VARIAVEIS -------------------- */
                Carta[] c0 = b.distribuiCartas(c, new Carta[5], 0);
                Carta[] c1 = b.distribuiCartas(c, new Carta[5], 5);
                Carta[] c2 = b.distribuiCartas(c, new Carta[5], 10);
                Carta[] c3 = b.distribuiCartas(c, new Carta[5], 15);
                Carta[] c4 = b.distribuiCartas(c, new Carta[5], 20);

                //for(int i = 0; i < jogador.length; i++)
                    //jogador[i] = new Jogador(Teclado.leString("Nome do jogador " +(i + 1)+ ":"), 200, null);

                /* -------------------------- CRIACAO DOS JOGADORES ------------------------- */
                jogador[0] = new Jogador("Eduardo", 200, null, ' ', true, 0);
                jogador[1] = new Jogador("Guinho", 200, null, ' ', false, 0);
                jogador[2] = new Jogador("James", 200, null, ' ', false, 0);
                jogador[3] = new Jogador("Games", 200, null, ' ', false, 0);
                jogador[4] = new Jogador("Ed", 200, null, ' ', false, 0);
        
                /* ------------------ ATRIBUINDO AS VARIAVEIS NOS JOGADORES ----------------- */
                jogador[0].setCartas(c0);
                jogador[1].setCartas(c1);
                jogador[2].setCartas(c2);
                jogador[3].setCartas(c3);
                jogador[4].setCartas(c4);

                funcoes(jogador); //CONFIGURANDO AS FUNCOES DOS JOGADORES

                /* ------------------ CHAMADA DOS METODOS EM OUTRAS CLASSES ----------------- */
                ctrl.imprimeJogadores(jogador);
                intervalo();
                System.out.println("\n\n\n");
                ctrl.apostasIniciais(jogador, c);
                intervalo();
                ctrl.apostas(jogador);
                ctrl.resultado(jogador);
            }

            else if(input == 2) //REGRAS
            {
                System.out.println("\n\nOs 5 jogadores recebem cinco cartas. O primeiro jogador depois do big blind tem a opçõa de desistir, pagar ou aumentar. A ação continua no sentido horário na mesa de poker até que as apostas estejam completas para a rodada.\n\n");
                System.out.println("1. Cinco cartas são dadas a cada jogador");
                System.out.println("2. 200 fichas são dadas a cada jogador");
                System.out.println("3. TROCA DE CARTAS");
                System.out.println("4. APOSTAS");
                System.out.println("5. RESULTADO\n\n\n");
            }
        }
    }

    public static void funcoes(Jogador[] jogador)
    {
        /* -------- FUNCOES DOS JOGADORES (DEALER, SMALL BLIND OU BIG BLIND) -------- */
        
        for (int i = 0; i < jogador.length; i++)
        {
            jogador[i].setFuncao('d');
            jogador[i + 1].setFuncao('s');
            jogador[i + 2].setFuncao('b');
            break;
        }
    }

    public static void intervalo() // INTERVALO
    {
        try{
             Thread.sleep(1000);
        }catch(Exception e){}
    }
}
