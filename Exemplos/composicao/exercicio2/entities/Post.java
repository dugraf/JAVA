package composicao.exercicio2.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Post
{
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private String title, content;
    private LocalDateTime moment;
    private int likes;

    private List<Comment> comments = new ArrayList<>();

    public Post(String title, String content, LocalDateTime moment, int likes) {
        this.title = title;
        this.content = content;
        this.moment = moment;
        this.likes = likes;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public LocalDateTime getMoment() {
        return moment;
    }
    public void setMoment(LocalDateTime moment) {
        this.moment = moment;
    }
    public int getLikes() {
        return likes;
    }
    public void setLikes(int likes) {
        this.likes = likes;
    }
    public List<Comment> getComments() {
        return comments;
    }

    public String toString()
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(title + "\n");
        stringBuilder.append(likes + " Likes - ");
        stringBuilder.append(moment.format(formatter) + "\n");
        stringBuilder.append(content + "\n");
        stringBuilder.append("Comments: \n");
        for (Comment comment : comments)
            stringBuilder.append(comment.getText() + "\n");
        return stringBuilder.toString();
    }

    public void addComment(Comment comment)
    {
        comments.add(comment);
    }
    
    public void removeComment(Comment comment)
    {
        comments.remove(comment);
    }
}
