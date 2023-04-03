/----------TRABALHO GRAU B----------/

Baralho: 52 cartas = Array de Carta
5 JOGADORES = objeto JOGADOR

    JOGADOR
    {
        array de Carta com 5 posicoes
    }

    CONTROLE
    {
        LOGICA DO JOGO (ETAPAS/DIVISAO)
    }

contra o COMPUTADOR (acoes aleatorias)

***CADA JOGADOR COM 200 FICHAS***



GANHA: QUEM FICAR COM TODAS AS FICHAS
PERDE: QUEM FICA SEM FICHAS


DEALER - SB - BB



-----JOGO-----

SB e BB: POTE
    SB - 5 FICHAS
    BB - 10 FICHAS

---RODADAS---

DIVISÃO:
    distribuicao
    {
        5 cartas cada
    }
    
    apostas iniciais
    {
        SB e BB
    }

    troca de cartas
    {
        - jogador depois do DEALER (escolhe quantas cartas quer trocar)
        - ultimo DEALER decidir, encerra-se as trocas.
    }

    apostas
    {
        primeiro jogador: depois do BB

        - IGUALA a aposta do jogador anterior
        - AUMENTA a aposta do jogador anterior
        - DESISTE da mao e espera a proxima RODADAS

        PASSA PARA O PROXIMO JOGADOR
        BB pode dar o "check"

        *pode acontecer de um jogador não poder colocar o mesmo valor dos
        demais por não ter fichas suficientes. Por exemplo, um jogador A possui
        50 fichas, mas algum jogador Y qualquer que apostou antes dele tem mais
        fichas e apostou 100. Neste caso, caso o jogador A queira entrar na
        aposta, ele poderá colocar todas as suas fichas (“all-in”), que são apenas
        50. Naturalmente, neste caso, em caso de vitória, o jogador receberá
        apenas a parte do pote que é proporcional ao seu valor. A implementação
        desta parte NÃO É NECESSÁRIA e será um extra no trabalho para quem
        desejar realiza-la, que resultará em 1.5pt a mais em alguma das
        atividades avaliativas do GB*
    }

    resultado
    {
        - MOSTRAM SUAS cartas
        - O MELHOR LEVA O POTE / EMPATE 50% 50%
        

        - DEALER(D) ANDA 1 POSICAO NO SENTIDO HORARIO
            ALTERANDO O SB E O BB
    }


*******************************************************************************************
    Durante a execução do seu programa, você deve utilizar de recursos de impressão na
tela para informar o que está acontecendo no jogo, como o valor das apostas, quantidade
        de fichas dos jogadores, jogos de cada jogador e demais informações.
*******************************************************************************************
