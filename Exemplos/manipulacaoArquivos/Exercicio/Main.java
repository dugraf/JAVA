import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        Produto p = new Produto();
        Produto[] produtos = new Produto[100];

        String path = "C:\\Users\\Usuário\\Desktop\\Programação\\VStudio-VScode\\JAVA\\Exemplos\\manipulacaoArquivos\\Exercicio";
        File diretorio = new File(path + "\\out");
        String strArquivo = diretorio + "\\produto.csv";
        
        if(diretorio.mkdir())
        {
            System.out.println("Diretorio criado com sucesso!");
        }
        escrita(diretorio, p, strArquivo);
        leitura(diretorio, p, strArquivo, produtos);

        for (int i = 0; i < produtos.length; i++)
        {
            if(produtos[i] == null)
                break;
            else
                System.out.println("\n\n\n PRODUTOS" + produtos[i]);
        }
    }

    public static void escrita(File diretorio, Produto p, String strArquivo)
    {
        Scanner sc = new Scanner(System.in);

        String nome = sc.next();
        double preco = sc.nextDouble();
        int quantidade = sc.nextInt();

        p.setNome(nome);
        p.setPreco(preco);
        p.setQuantidade(quantidade);

        sc.close();

        try(BufferedWriter escrita = new BufferedWriter(new FileWriter(strArquivo, true)))
        {
            escrita.write("\n"+ p.getNome() +",");
            escrita.write(p.getPreco() +",");
            escrita.write(p.getQuantidade() +"");
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void leitura(File diretorio, Produto p, String strArquivo, Produto[] produtos) throws FileNotFoundException, IOException
    {
        try(BufferedReader leitura = new BufferedReader(new FileReader(strArquivo)))
        {
            String line = leitura.readLine();
        
            while(line != null)
            {
                System.out.println(line);
                leituraArray(line, p, produtos);
                summary(diretorio, p, produtos);
                line = leitura.readLine();
            }
        }
    }

    public static String[] leituraArray(String line, Produto p, Produto[] produtos)
    {
        String array[] = new String[3];
        array = line.split(",");


        p.setNome(array[0]);
        p.setPreco(Double.valueOf(array[1]));
        p.setQuantidade(Integer.valueOf(array[2]));

        String nome = array[0];
        double preco = Double.valueOf(array[1]);
        int quantidade = Integer.valueOf(array[2]);

        adicionarProduto(nome, preco, quantidade, produtos);

        System.out.println(p);

        return array;
    }

    public static void adicionarProduto(String nome, double preco, int quantidade, Produto[] produtos)
    {
        for (int i = 0; i < produtos.length; i++)
        {
            if(produtos[i] == null)
            {
                produtos[i] = new Produto(nome, preco, quantidade);
                break;
            }
        }
    }

    public static void summary(File diretorio, Produto p, Produto[] produtos)
    {
        try(BufferedWriter escrita = new BufferedWriter(new FileWriter(diretorio + "\\summary.csv")))
        {
            for (int i = 0; i < produtos.length; i++)
            {
                if(produtos[i] != null)
                {
                    escrita.write(produtos[i].getNome() +",");
                    escrita.write(produtos[i].getPrecoTotal() + "\n");
                }
                else
                    break;
            }

        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

    }
}