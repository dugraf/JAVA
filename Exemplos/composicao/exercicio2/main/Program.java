package composicao.exercicio2.main;

import java.time.LocalDateTime;
import composicao.exercicio2.entities.Comment;
import composicao.exercicio2.entities.Post;

public class Program
{
    public static void main(String[] args)
    {
        LocalDateTime date = LocalDateTime.parse("2018-06-21T13:05:44");
        Comment comment1 = new Comment("Have a nice trip!");
        Comment comment2 = new Comment("Wow that's awesome!");

        Post post1 = new Post("Traveling to New Zealand", "I'm going to visit this wonderful country!", date, 12);

        post1.addComment(comment1);
        post1.addComment(comment2);

        System.out.println(post1);
    }
}
