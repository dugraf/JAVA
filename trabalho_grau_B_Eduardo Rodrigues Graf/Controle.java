// EDUARDO RODRIGUES GRAF

public class Controle
{
    int pote = 0;
    int small_blind = 5;
    int big_blind = 10;
    int aposta_atual = 10;

    public void imprimeJogadores(Jogador[] j)
    {
        for(int i = 0; i < j.length; i++)
            System.out.println(j[i]);
    }

    public void apostasIniciais(Jogador[] jogador, Carta[] c)
    {
        /* ---------------------------- APOSTAS INICIAIS ---------------------------- */

        Jogador dealer = new Jogador();
        Jogador big = new Jogador();
        Jogador small = new Jogador();
        Jogador player = jogador[0];

        for(int i = 0; i < jogador.length; i++)
        {
            if(jogador[i].getFuncao() == 'd')
            {
                System.out.println("O jogador " +jogador[i].getNome()+ " eh o DEALER!");
                dealer = jogador[i];
            }
            if(jogador[i].getFuncao() == 's')
            {
                System.out.println("O jogador " +jogador[i].getNome()+ " eh o SMALL BLIND e apostou: " +small_blind+ " fichas");
                small = jogador[i];
                jogador[i].setFichas(jogador[i].getFichas() - small_blind);
                jogador[i].setVlr_aposta(small_blind);
            }
            if(jogador[i].getFuncao() == 'b')
            {
                System.out.println("O jogador " +jogador[i].getNome()+ " eh o BIG BLIND e apostou: " +big_blind+ " fichas");
                big = jogador[i];
                jogador[i].setFichas(jogador[i].getFichas() - big_blind);
                jogador[i].setVlr_aposta(big_blind);
            }
        }

        pote += small_blind + big_blind;
        System.out.println("POTE: " +pote);
        intervalo();
        trocaCartas(jogador, dealer, c, player);
    }

    public void trocaCartas(Jogador[] jogador, Jogador dealer, Carta[] c, Jogador player)
    {
        /* -------------------------- JOGADOR TROCAR CARTA -------------------------- */

        for(int i = 0; i < jogador.length; i++)
        {
            System.out.println("\n\n\n");
            if(jogador[i] != dealer)
            {
                System.out.println("Vez de " +jogador[i].getNome()+ " trocar suas cartas!!!");
                int rand = (int)(Math.random() * 2);
                int pos_jogador = i;

                if(rand == 0)
                    System.out.println(jogador[i].getNome()+ " vai trocar suas cartas!");
                else
                    System.out.println(jogador[i].getNome()+ " nao vai trocar suas cartas!");

                jogador[i].imprimeCartas();

                if(rand == 0) //TROCAR
                {
                    int rand_qnt_cartas_trocar = (int)(Math.random() * 5);
                    if(rand_qnt_cartas_trocar == 0)
                        rand_qnt_cartas_trocar++;

                    if(rand_qnt_cartas_trocar == 1)
                    {
                        int rand_ql_carta = (int)(Math.random() * 5);
                        troca(c, jogador,rand_ql_carta, pos_jogador);
                        jogador[i].imprimeCartas();
                    }

                    else if(rand_qnt_cartas_trocar == 2)
                    {
                        int rand_ql_carta1 = (int)(Math.random() * 5);
                        int rand_ql_carta2 = (int)(Math.random() * 5);
                        troca(c, jogador,rand_ql_carta1, pos_jogador);
                        troca(c, jogador,rand_ql_carta2, pos_jogador);
                        jogador[i].imprimeCartas();
                    }

                    else if(rand_qnt_cartas_trocar == 3)
                    {
                        int rand_ql_carta1 = (int)(Math.random() * 5);
                        int rand_ql_carta2 = (int)(Math.random() * 5);
                        int rand_ql_carta3 = (int)(Math.random() * 5);
                        troca(c, jogador,rand_ql_carta1, pos_jogador);
                        troca(c, jogador,rand_ql_carta2, pos_jogador);
                        troca(c, jogador,rand_ql_carta3, pos_jogador);
                        jogador[i].imprimeCartas();
                    }

                    else if(rand_qnt_cartas_trocar == 4)
                    {
                        int rand_ql_carta1 = (int)(Math.random() * 5);
                        int rand_ql_carta2 = (int)(Math.random() * 5);
                        int rand_ql_carta3 = (int)(Math.random() * 5);
                        int rand_ql_carta4 = (int)(Math.random() * 5);
                        troca(c, jogador,rand_ql_carta1, pos_jogador);
                        troca(c, jogador,rand_ql_carta2, pos_jogador);
                        troca(c, jogador,rand_ql_carta3, pos_jogador);
                        troca(c, jogador,rand_ql_carta4, pos_jogador);
                        jogador[i].imprimeCartas();
                    }

                    else if(rand_qnt_cartas_trocar == 5)
                    {
                        int rand_ql_carta1 = (int)(Math.random() * 5);
                        int rand_ql_carta2 = (int)(Math.random() * 5);
                        int rand_ql_carta3 = (int)(Math.random() * 5);
                        int rand_ql_carta4 = (int)(Math.random() * 5);
                        int rand_ql_carta5 = (int)(Math.random() * 5);
                        troca(c, jogador,rand_ql_carta1, pos_jogador);
                        troca(c, jogador,rand_ql_carta2, pos_jogador);
                        troca(c, jogador,rand_ql_carta3, pos_jogador);
                        troca(c, jogador,rand_ql_carta4, pos_jogador);
                        troca(c, jogador,rand_ql_carta5, pos_jogador);
                        jogador[i].imprimeCartas();
                    }
                }
            }
        }
        
        for(int i = 0; i < jogador.length; i++)
            if(jogador[i] == dealer)
            {
                System.out.println("\n\n\n");
                if(jogador[i] == player)
                {
                    System.out.println(jogador[i].getNome()+ " quer trocar suas cartas?\n 1.SIM\n 2.NAO");
                    jogador[i].imprimeCartas();
                    int input = Teclado.leInt();
                    int pos_jogador = i;

                    if(input == 1)
                    {
                        int qnt_cartas_trocar = Teclado.leInt("Quantas cartas voce quer trocar?");
                        if(qnt_cartas_trocar == 1)
                        {
                            int ql_carta = Teclado.leInt("Carta de que posicao voce quer trocar? (Ex: 0)");
                            troca(c, jogador,ql_carta, pos_jogador);
                            jogador[i].imprimeCartas();
                            intervalo();
                        }

                        else if(qnt_cartas_trocar == 2)
                        {
                            String ql_carta = Teclado.leString("Cartas de quais posicoes voce quer trocar? (Ex: 0 1)");
                            String[] arr = ql_carta.split(" ");
                            int ql_carta1 = Integer.parseInt(arr[0]);
                            int ql_carta2 = Integer.parseInt(arr[1]);
                            troca(c, jogador, ql_carta1, pos_jogador);
                            troca(c, jogador, ql_carta2, pos_jogador);
                            jogador[i].imprimeCartas();
                            intervalo();
                        }

                        else if(qnt_cartas_trocar == 3)
                        {
                            String ql_carta = Teclado.leString("Cartas de quais posicoes voce quer trocar? (Ex: 0 1 2)");
                            String[] arr = ql_carta.split(" ");
                            int ql_carta1 = Integer.parseInt(arr[0]);
                            int ql_carta2 = Integer.parseInt(arr[1]);
                            int ql_carta3 = Integer.parseInt(arr[2]);
                            troca(c, jogador, ql_carta1, pos_jogador);
                            troca(c, jogador, ql_carta2, pos_jogador);
                            troca(c, jogador, ql_carta3, pos_jogador);
                            jogador[i].imprimeCartas();
                            intervalo();
                        }

                        else if(qnt_cartas_trocar == 4)
                        {
                            String ql_carta = Teclado.leString("Cartas de quais posicoes voce quer trocar? (Ex: 1 3 4 5)");
                            String[] arr = ql_carta.split(" ");
                            int ql_carta1 = Integer.parseInt(arr[0]);
                            int ql_carta2 = Integer.parseInt(arr[1]);
                            int ql_carta3 = Integer.parseInt(arr[2]);
                            int ql_carta4 = Integer.parseInt(arr[3]);
                            troca(c, jogador, ql_carta1, pos_jogador);
                            troca(c, jogador, ql_carta2, pos_jogador);
                            troca(c, jogador, ql_carta3, pos_jogador);
                            troca(c, jogador, ql_carta4, pos_jogador);
                            jogador[i].imprimeCartas();
                            intervalo();
                        }

                        else if(qnt_cartas_trocar == 5)
                        {
                            String ql_carta = Teclado.leString("Cartas de quais posicoes voce quer trocar? (Ex: 0 1 2 3 4)");
                            String[] arr = ql_carta.split(" ");
                            int ql_carta1 = Integer.parseInt(arr[0]);
                            int ql_carta2 = Integer.parseInt(arr[1]);
                            int ql_carta3 = Integer.parseInt(arr[2]);
                            int ql_carta4 = Integer.parseInt(arr[3]);
                            int ql_carta5 = Integer.parseInt(arr[4]);
                            troca(c, jogador, ql_carta1, pos_jogador);
                            troca(c, jogador, ql_carta2, pos_jogador);
                            troca(c, jogador, ql_carta3, pos_jogador);
                            troca(c, jogador, ql_carta4, pos_jogador);
                            troca(c, jogador, ql_carta5, pos_jogador);
                            jogador[i].imprimeCartas();
                            intervalo();
                        }
                    }
                }
            }
    }

    public void troca(Carta[] c, Jogador[] jogador, int ql_carta, int pos_jogador)
    {
        int cart_pos = 0; //POSICAO DA CARTA DENTRO DO BARALHO
        /* ------------------- COLOCAR A CARTA NO BARALHO DE VOLTA ------------------ */
        for(int i = 0; i < jogador.length;)
        {
            for(int j = 0; j < c.length; j++)
                if(c[j] == null)
                {
                    c[j] = jogador[pos_jogador].getCartas()[ql_carta];
                    cart_pos = j;
                    break;
                }

            /* -------------------- PEGANDO UMA NOVA CARTA DO BARALHO ------------------- */
            for(int j = cart_pos + 1; j < c.length; j++)
                if(c[j] != null)
                {
                    jogador[pos_jogador].getCartas()[ql_carta] = c[j];
                    c[j] = null;
                    break;
                }
            break;
        }   
    }

    public void apostas(Jogador[] jogador)
    {
        /* --------------------------------- APOSTAS -------------------------------- */

        //REVIEW - Jogador[] jogadores_apostando = jogador;
        //REVIEW - Jogador[] jogadores_com_funcao = new Jogador[3];
        //REVIEW - Jogador[] jogadores_sem_funcao = new Jogador[2];
        Jogador[] jogador_ordem = new Jogador[5];
        boolean eh_bot = false;
        int cont = 0;
        boolean big_check = false;

        for(int i = 0; i < jogador.length; i++)
        {
            if(jogador[i].getFuncao() == 'd')
            {
                jogador_ordem[2] = jogador[i];
            }
            else if(jogador[i].getFuncao() == 's')
            {
                System.out.println("\n\nComo " +jogador[i].getNome()+ " eh o small blind, ele apostou " +small_blind+ " FICHAS");
                jogador_ordem[3] = jogador[i];
            }
            else if(jogador[i].getFuncao() == 'b')
            {
                System.out.println("Como " +jogador[i].getNome()+ " eh o big blind, ele apostou " +big_blind+ " FICHAS\n\n");
                jogador_ordem[4] = jogador[i];
            }
            else
            {
                if(jogador_ordem[0] == null)
                jogador_ordem[0] = jogador[i];
                else
                jogador_ordem[1] = jogador[i];
            }
        }
        //TODO - APOSTAS
        /* --------------------------------- APOSTAS -------------------------------- */

        for(int i = 0; i < jogador_ordem.length; i++)
        {
            if(i < 2) //DOIS PRIMEIROS JOGADORES
            {
                if(jogador_ordem[i] != null)
                {
                    if(jogador_ordem[i].isPlayer()) //PLAYER
                    {
                        eh_bot = false;
                        System.out.println(jogador_ordem[i].getNome()+ " selecione a forma de aposta!");
                        System.out.println("1. IGUALAR APOSTA");
                        System.out.println("2. AUMENTAR APOSTA");
                        System.out.println("3. DESISTIR");
                        System.out.println("A aposta atual eh " +aposta_atual);
        
                        int input = Teclado.leInt();
    
                        selecaoApostas(jogador_ordem[i], input, eh_bot);
                        if(input == 3)
                            jogador_ordem[i] = null;
                        System.out.println("VALOR DO POTE: " +pote+ " FICHAS\n\n");
                        intervalo();
                    }
                    else //BOT
                    {
                        eh_bot = true;
                        System.out.println(jogador_ordem[i].getNome()+ " selecione a forma de aposta!");
                        System.out.println("1. IGUALAR APOSTA");
                        System.out.println("2. AUMENTAR APOSTA");
                        System.out.println("3. DESISTIR");
                        System.out.println("A aposta atual eh " +aposta_atual);
    
                        int rand = (int)(Math.random() * 3);
    
                        selecaoApostas(jogador_ordem[i], rand, eh_bot);
                        if(rand == 2)
                            jogador_ordem[i] = null;
                        System.out.println("VALOR DO POTE: " +pote+ " FICHAS\n\n");
                        intervalo();
                    }
                }
                
            }
            else //ESPECIAIS
            {
                if(jogador_ordem[i] != null)
                {
                    if(jogador_ordem[i].getFuncao() == 'd')
                    {
                        if(jogador_ordem[i].isPlayer()) //PLAYER
                        {
                            eh_bot = false;
                            System.out.println(jogador_ordem[i].getNome()+ " selecione a forma de aposta!");
                            System.out.println("1. IGUALAR APOSTA");
                            System.out.println("2. AUMENTAR APOSTA");
                            System.out.println("3. DESISTIR");
                            System.out.println("A aposta atual eh " +aposta_atual);
            
                            int input = Teclado.leInt();
    
                            selecaoApostas(jogador_ordem[i], input, eh_bot);
                            if(input == 3)
                                jogador_ordem[i] = null;
                            System.out.println("VALOR DO POTE: " +pote+ " FICHAS\n\n");
                            intervalo();
                        }
                        else //BOT
                        {
                            eh_bot = true;
                            System.out.println(jogador_ordem[i].getNome()+ " selecione a forma de aposta!");
                            System.out.println("1. IGUALAR APOSTA");
                            System.out.println("2. AUMENTAR APOSTA");
                            System.out.println("3. DESISTIR");
                            System.out.println("A aposta atual eh " +aposta_atual);
            
                            int rand = (int)(Math.random() * 3);
    
                            selecaoApostas(jogador_ordem[i], rand, eh_bot);
                            if(rand == 2)
                                jogador_ordem[i] = null;
                            System.out.println("VALOR DO POTE: " +pote+ " FICHAS\n\n");
                            intervalo();
                        }
                    }
                    else if(jogador_ordem[i].getFuncao() == 's')
                    {
                        if(jogador_ordem[i].isPlayer()) //PLAYER
                        {
                            eh_bot = false;
                            System.out.println(jogador_ordem[i].getNome()+ " selecione a forma de aposta!");
                            System.out.println("1. IGUALAR APOSTA");
                            System.out.println("2. AUMENTAR APOSTA");
                            System.out.println("3. DESISTIR");
                            System.out.println("A aposta atual eh " +aposta_atual);
            
                            int input = Teclado.leInt();
    
                            selecaoApostas(jogador_ordem[i], input, eh_bot);
                            if(input == 3)
                                jogador_ordem[i] = null;
                            System.out.println("VALOR DO POTE: " +pote+ " FICHAS\n\n");
                            intervalo();
                        }
                        else //BOT
                        {
                            eh_bot = true;
                            System.out.println(jogador_ordem[i].getNome()+ " selecione a forma de aposta!");
                            System.out.println("1. IGUALAR APOSTA");
                            System.out.println("2. AUMENTAR APOSTA");
                            System.out.println("3. DESISTIR");
                            System.out.println("A aposta atual eh " +aposta_atual);
            
                            int rand = (int)(Math.random() * 3);
    
                            selecaoApostas(jogador_ordem[i], rand, eh_bot);
                            if(rand == 2)
                                jogador_ordem[i] = null;
                            System.out.println("VALOR DO POTE: " +pote+ " FICHAS\n\n");
                            intervalo();
                        }
                    }
                    else if(jogador_ordem[i].getFuncao() == 'b')
                    {
                        if(jogador_ordem[i].isPlayer()) //PLAYER
                        {
                            eh_bot = false;
                            System.out.println(jogador_ordem[i].getNome()+ " selecione a forma de aposta!");
                            System.out.println("1. CHECK");
                            System.out.println("2. AUMENTAR APOSTA");
                            System.out.println("A aposta atual eh " +aposta_atual);
                            
                            int input = Teclado.leInt();
                            selecaoApostasBigBlind(jogador_ordem[i], input, eh_bot, big_check);
                            if(input == 3)
                                jogador_ordem[i] = null;
                            System.out.println("VALOR DO POTE: " +pote+ " FICHAS\n\n");
                            intervalo();
                        }
                        else //BOT
                        {
                            eh_bot = true;
                            System.out.println(jogador_ordem[i].getNome()+ " selecione a forma de aposta!");
                            System.out.println("1. CHECK");
                            System.out.println("2. AUMENTAR APOSTA");
                            System.out.println("A aposta atual eh " +aposta_atual);
    
                            int rand = (int)(Math.random() * 2);
    
                            selecaoApostasBigBlind(jogador_ordem[i], rand, eh_bot, big_check);
                            if(rand == 2)
                                jogador_ordem[i] = null;
                            System.out.println("VALOR DO POTE: " +pote+ " FICHAS\n\n");
                            intervalo();
                        }
                    }
                }
            }
        }
    }

    public void selecaoApostas(Jogador jogador, int input, boolean eh_bot)
    {
        if(eh_bot)
        {
            if(input == 0) //IGUALAR
            {
                jogador.setFichas(jogador.getFichas() - aposta_atual);
                System.out.println(jogador.getNome()+ " IGUALOU a aposta! Com " +aposta_atual+ " FICHAS");

                if(jogador.getFichas() < aposta_atual) //ALL-IN
                {
                    System.out.println("Jogador deu all-in!");
                    pote += jogador.getFichas();
                    jogador.setFichas(0);
                }
                else
                {
                    pote += aposta_atual;
                    jogador.setVlr_aposta(aposta_atual);
                } 
            }
            else if(input == 1) //AUMENTAR
            {
                System.out.println("Quanto voce quer apostar?");
                int aposta_rand = (int)(Math.random() * (jogador.getFichas()));
    
                boolean apostou_errado = aposta_rand < aposta_atual || aposta_rand == aposta_atual;
                while(apostou_errado)
                {
                    System.out.println("Nao eh possivel apostar dessa forma! Aposte de novo! A aposta minima eh " +(aposta_atual + 1)+ " FICHAS");
                    aposta_rand = (int)(Math.random() * (jogador.getFichas()));
                    if(aposta_rand > aposta_atual)
                        break;
                }

                if(jogador.getFichas() < aposta_atual) //ALL-IN
                {
                    System.out.println("Jogador deu all-in!");
                    pote += jogador.getFichas();
                    jogador.setFichas(0);
                }
                else
                {
                    aposta_atual = aposta_rand;
                    jogador.setFichas(jogador.getFichas() - aposta_atual);
                    System.out.println(jogador.getNome()+ " apostou " +aposta_rand+ " FICHAS");
                    System.out.println("E a aposta atual passa a ser: " +aposta_atual);
                    pote += aposta_atual;
                    jogador.setVlr_aposta(aposta_atual);
                }
                
            }
            else if(input == 2) //SAIR
            {
                System.out.println(jogador.getNome()+ " saiu das apostas!");
            }
        }
        else //JOGADOR
        {
            if(input == 1) //IGUALAR
            {
                jogador.setFichas(jogador.getFichas() - aposta_atual);
                System.out.println(jogador.getNome()+ " igualou a aposta atual! Com " + aposta_atual+ " FICHAS");

                if(jogador.getFichas() < aposta_atual) //ALL-IN
                {
                    System.out.println("Jogador deu all-in!");
                    pote += jogador.getFichas();
                    jogador.setFichas(0);
                }
                else
                {
                    pote += aposta_atual;
                    jogador.setVlr_aposta(aposta_atual);
                }
            }
            else if(input == 2) //AUMENTAR
            {
                int aposta = Teclado.leInt("Quanto voce quer apostar?");
                boolean apostou_errado = aposta < aposta_atual || aposta == aposta_atual;
                while(apostou_errado)
                {
                    System.out.println("Nao eh possivel apostar dessa forma! Aposte de novo! A aposta minima eh " +(aposta_atual + 1)+ " FICHAS");
                    aposta = Teclado.leInt("Quanto voce quer apostar?");
                    if(aposta > aposta_atual)
                        break;
                }

                if(jogador.getFichas() < aposta_atual) //ALL-IN
                {
                    System.out.println("Jogador deu all-in!");
                    pote += jogador.getFichas();
                    jogador.setFichas(0);
                }
                else
                {
                    aposta_atual = aposta;
                    jogador.setFichas(jogador.getFichas() - aposta_atual);
                    System.out.println(jogador.getNome()+ " apostou " +aposta+ " FICHAS!");
                    pote += aposta_atual;
                    jogador.setVlr_aposta(aposta_atual);
                }
            }
            else if(input == 3) //SAIR
            {
                System.out.println(jogador.getNome()+ " saiu das apostas!");
            }
        }
    }

    public void selecaoApostasBigBlind(Jogador jogador, int input, boolean eh_bot, boolean check)
    {
        if(eh_bot) //BOT
        {
            if(input == 0) //CHECK
            {
                System.out.println(jogador.getNome()+ " deu CHECK!");
                check = true;
            }
            else if(input == 1) //AUMENTAR
            {
                System.out.println("Quanto voce quer apostar?");
                int aposta_rand = (int)(Math.random() * (jogador.getFichas()));
    
                boolean apostou_errado = aposta_rand < aposta_atual || aposta_rand == aposta_atual;
                while(apostou_errado)
                {
                    System.out.println("Nao eh possivel apostar dessa forma! Aposte de novo! A aposta minima eh " +(aposta_atual + 1)+ " FICHAS");
                    aposta_rand = (int)(Math.random() * (jogador.getFichas()));
                    if(aposta_rand > aposta_atual)
                        break;
                }

                if(jogador.getFichas() < aposta_atual) //ALL-IN
                {
                    System.out.println("Jogador deu all-in!");
                    pote += jogador.getFichas();
                    jogador.setFichas(0);
                }
                else
                {
                    aposta_atual = aposta_rand;
                    jogador.setFichas(jogador.getFichas() - aposta_atual);
                    System.out.println(jogador.getNome()+ " apostou " +aposta_rand+ " FICHAS");
                    System.out.println("E a aposta atual passa a ser: " +aposta_atual);
                    pote += aposta_atual;
                    jogador.setVlr_aposta(aposta_atual);
                }
            }
        }
        else //JOGADOR
        {
            if(input == 1) //CHECK
            {
                System.out.println(jogador.getNome()+ " deu CHECK!");
                check = true;
            }
            else if(input == 2) //AUMENTAR
            {
                int aposta = Teclado.leInt("Quanto voce quer apostar?");
                boolean apostou_errado = aposta < aposta_atual || aposta == aposta_atual;
                while(apostou_errado)
                {
                    System.out.println("Nao eh possivel apostar dessa forma! Aposte de novo! A aposta minima eh " +(aposta_atual + 1)+ " FICHAS");
                    aposta = Teclado.leInt("Quanto voce quer apostar?");
                    if(aposta > aposta_atual)
                        break;
                }
                
                if(jogador.getFichas() < aposta_atual) //ALL-IN
                {
                    System.out.println("Jogador deu all-in!");
                    pote += jogador.getFichas();
                    jogador.setFichas(0);
                }
                else
                {
                    aposta_atual = aposta;
                    jogador.setFichas(jogador.getFichas() - aposta_atual);
                    System.out.println(jogador.getNome()+ " apostou " +aposta+ "!");
                    pote += aposta_atual;
                    jogador.setVlr_aposta(aposta_atual);
                }
            }
        }
    }

    public void resultado(Jogador[] jogador)
    {
        /* -------------------------------- RESULTADO ------------------------------- */

        for(int i = 0; i < jogador.length; i++)
        {
            cartaAlta(jogador[i].getCartas());   
        }
    }

    public int cartaAlta(Carta[] carta)
    {
        /* ------------------------------- CARTA ALTA ------------------------------- */
        int cont = 0;

        for(int i = 0; i < carta.length; i++)
        {
            String num = carta[i].getValor();
            int num_conv = Integer.parseInt(num);
            cont += num_conv;
        }

        return cont;
    }

    public int doisPares(Carta[] carta)
    {
        /* ------------------------------- DOIS PARES ------------------------------- */

        int j = 0;
        int vlr = 0;

        for(int i = 0; i < carta.length - 1; i++)
        {
            String num_i = carta[i].getValor();
            int num_conv_i = Integer.parseInt(num_i);

            for(j = i + 1; j < 5; j++)
            {
                String num_j = carta[j].getValor();
                int num_conv_j = Integer.parseInt(num_j);
                if((num_conv_i == num_conv_j) && (num_conv_i > vlr))
                    vlr = num_conv_i;
            }
        }

        if(vlr == 0)
                return 0;
            else
                return vlr + 13;
    }

    public void trinca()
    {

    }

    public void intervalo() // INTERVALO
    {
        try{
             Thread.sleep(1000);
        }catch(Exception e){}
    }
}