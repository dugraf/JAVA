package composicao.exercicio3.main;

import java.time.LocalDate;
import java.time.LocalDateTime;

import composicao.exercicio3.entities.Client;
import composicao.exercicio3.entities.Order;
import composicao.exercicio3.entities.OrderItem;
import composicao.exercicio3.entities.Product;
import composicao.exercicio3.entities.enums.OrderStatus;
import input.Input;

public class Program
{
    public static void main(String[] args)
    {
        System.out.println("Enter client data:");
        String clientName = Input.inputString("Name: ");
        String clientEmail = Input.inputString("Email: ");
        String clientBirthString = Input.inputString("Birth date (DD/MM/YYYY): ");
        LocalDate clientBirth = dateConverter(clientBirthString);

        System.out.println("Enter order data:");
        String status = Input.inputString("Status: ");
        int itemsQuantity = Input.inputInt("How many items to this order? ");
        
        Order order = new Order(LocalDateTime.now(), OrderStatus.valueOf(status));
        Client client = new Client(clientName, clientEmail, clientBirth);

        for (int i = 0; i < itemsQuantity; i++)
        {
            System.out.println("Enter #" +(i + 1)+ " item data:");
            String name = Input.inputString("Product name: ");
            double price = Input.inputDouble("Product price: ");
            int quantity = Input.inputInt("Quantity: ");

            OrderItem orderItem = new OrderItem(quantity, price);
            orderItem.setProduct(new Product(name, price));

            order.addItem(orderItem);
        }
        order.setClient(client);
        System.out.println(order);
    }

    private static LocalDate dateConverter(String dateString)
    {
        int day = Integer.parseInt(dateString.substring(0, 2));
        int month = Integer.parseInt(dateString.substring(3, 5));
        int year = Integer.parseInt(dateString.substring(6));
        return LocalDate.of(year, month, day);
    }
}