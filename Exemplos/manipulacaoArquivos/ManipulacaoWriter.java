package manipulacaoArquivos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ManipulacaoWriter
{
    public static void main(String[] args)
    {
        String[] lines = new String[] {"Good", "Guinho", "James"};

        String path = "C:\\Users\\Usuário\\Desktop\\Programação\\VStudio-VScode\\JAVA\\Exemplos\\manipulacaoArquivos\\out.txt";

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path, true)))
        {
            for (String line : lines)
            {
                bw.write(line);
                bw.newLine();
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
