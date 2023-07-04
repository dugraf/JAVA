package list;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lista
{
    public static void main(String[] args)
    {
        List<String> list = new ArrayList<>();

        list.add("Maria");
        list.add("Ed");
        list.add("Guinho");
        list.add("James");
        list.add("Games");
        list.add("Eduardo");
        list.add(2, "Teste");

        System.out.println(list.size());

        for(String i : list)
            System.out.println(i);

        list.remove("Anna");
        list.remove(0);

        list.removeIf(x -> x.charAt(0) == 'G');

        System.out.println("----------------");
        for(String i : list)
            System.out.println(i);

        System.out.println("Index of Ed " + list.indexOf("Ed")); //EXISTE
        System.out.println("Index of Guinho " + list.indexOf("Guinho")); //NAO EXISTE

        List<String> result = list.stream().filter(x -> x.charAt(0) == 'E').collect(Collectors.toList());

        System.out.println("----------------");
        for (String i : result)
            System.out.println(i);
    }
}
