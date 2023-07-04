package datahora;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class Converter2
{
    public static void main(String[] args)
    {
        LocalDate date4 = LocalDate.parse("2022-07-20");
        LocalDateTime date5 = LocalDateTime.parse("2022-07-20T01:30:26");
        Instant date6 = Instant.parse("2022-07-20T01:30:26Z");
        LocalDateTime dateNow = LocalDateTime.now();

        LocalDate r1 = LocalDate.ofInstant(date6, ZoneId.systemDefault());
        LocalDate r2 = LocalDate.ofInstant(date6, ZoneId.of("Brazil/East"));
        LocalDateTime r3 = LocalDateTime.ofInstant(date6, ZoneId.systemDefault());
        LocalDateTime r4 = LocalDateTime.ofInstant(date6, ZoneId.of("Brazil/East"));

        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
        System.out.println(r4);

        System.out.println(date4.getDayOfMonth());
        System.out.println(date4.getMonthValue());
        System.out.println(dateNow.getDayOfWeek());
        System.out.println(date5.getHour());
        System.out.println(date5.getMinute());
    }
}
