package List;

import java.util.ArrayList;
import java.util.List;

public class Lista1
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
        
        String name = list.stream().filter(x -> x.charAt(0) == 'G').findFirst().orElse(null);
        System.out.println(name);
    }
}
