package manipulacaoArquivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ManipulacaoTry
{
    public static void main(String[] args)
    {
        /* INCLUIR O CAMINHO DO ARQUIVO DE TEXTO */
        String path = "C:\\Users\\Usuário\\Desktop\\Programação\\VStudio-VScode\\JAVA\\Exemplos\\manipulacaoArquivos\\texto.txt";
    
        try (BufferedReader br = new BufferedReader(new FileReader(path))) //LEITURA DO ARQUIVO DE TEXTO
        {
            String line = br.readLine();
    
            while (line != null)
            {
                System.out.println(line);
                line = br.readLine();
            }
        }
        catch(IOException e)
        {
            System.out.println("Error: " +e.getMessage());
        }
    }
}
