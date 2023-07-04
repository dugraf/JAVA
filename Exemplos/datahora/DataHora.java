package datahora;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class DataHora
{
    public static void main(String[] args)
    {
        LocalDate date1 = LocalDate.now();
        LocalDateTime date2 = LocalDateTime.now();
        Instant date3 = Instant.now();

        LocalDate date4 = LocalDate.parse("2022-07-20");
        LocalDateTime date5 = LocalDateTime.parse("2022-07-20T01:30:26");
        Instant date6 = Instant.parse("2022-07-20T01:30:26Z");

        System.out.println(date1+ "\n" +date2+ "\n" +date3);
        System.out.println(date4+ "\n" +date5+ "\n" +date6);
    }
}
