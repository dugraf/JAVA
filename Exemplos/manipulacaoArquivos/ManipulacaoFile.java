package manipulacaoArquivos;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ManipulacaoFile
{
    public static void main(String[] args)
    {
        /* INCLUIR O CAMINHO DO ARQUIVO DE TEXTO */
        File file = new File("C:\\Users\\Usuário\\Desktop\\Programação\\VStudio-VScode\\JAVA\\Exemplos\\manipulacaoArquivos\\texto.txt");
        Scanner sc = null;
        
        try
        {
            sc = new Scanner(file); //LEITURA DESTE ARQUIVO

            while(sc.hasNextLine()) //SE AINDA EXISTIR ALGUMA LINHA PARA LER, ENTAO, PULAR PARA A PROXIMA LINHA
                System.out.println(sc.nextLine());
        }
        catch (IOException e)
        {
            System.out.println("Error " +e.getMessage()); //EXCECAO
        }
        finally 
        {
            /* INDEPENDENTE SE DER O EXCEPTION, OU NAO, FECHAR O RECURSO SCANNER */
            if(sc != null)
                sc.close();
        }
    }
}