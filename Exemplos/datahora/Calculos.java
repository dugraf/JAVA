package datahora;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Calculos
{
    public static void main(String[] args)
    {
        LocalDate date4 = LocalDate.parse("2022-07-20");
        LocalDateTime date5 = LocalDateTime.parse("2022-07-20T01:30:26");
        Instant date6 = Instant.parse("2022-07-20T01:30:26Z");

        LocalDate pastWeekLocalDate = date4.minusDays(7);
        LocalDate nextWeekLocalDate = date4.plusDays(7);

        System.out.println("pastWeekLocalDate = " +pastWeekLocalDate);
        System.out.println("nextWeekLocalDate = " +nextWeekLocalDate);

        LocalDateTime pastWeekLocalDateTime = date5.minusDays(7);
        LocalDateTime nextMonthLocalDateTime = date5.plusMonths(2);

        System.out.println("pastWeekDateTime = " +pastWeekLocalDateTime);
        System.out.println("nextWeekDateTime = " +nextMonthLocalDateTime);

        Instant pastWeekInstant = date6.minus(7, ChronoUnit.DAYS);
        Instant nextWeekInstant = date6.plus(7, ChronoUnit.DAYS);

        System.out.println("pastWeekInstant = " + pastWeekInstant);
        System.out.println("nextWeekInstant = " + nextWeekInstant);

        Duration t1 = Duration.between(pastWeekLocalDate.atStartOfDay(), date4.atStartOfDay());
        Duration t2 = Duration.between(nextMonthLocalDateTime, date5);

        System.out.println(t1.toDays());
        System.out.println(t2.toDays());
    }
}
