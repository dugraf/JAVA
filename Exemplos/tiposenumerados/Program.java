package tiposenumerados;

import java.time.LocalDate;

public class Program
{
    public static void main(String[] args)
    {
        Order order = new Order(1080, LocalDate.now(), OrderStatus.PENDING_PAYMENT);

        System.out.println(order);

        OrderStatus os1 = OrderStatus.DELIVERED;
        OrderStatus os2 = OrderStatus.valueOf("DELIVERED");

        System.out.println("os1 = " + os1);
        System.out.println("os2 = " + os2);
    }
}
