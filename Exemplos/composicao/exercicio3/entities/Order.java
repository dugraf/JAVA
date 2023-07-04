package composicao.exercicio3.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import composicao.exercicio3.entities.enums.OrderStatus;

public class Order
{
    private DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private LocalDateTime moment;
    private OrderStatus status;

    private List<OrderItem> items = new ArrayList<>();
    private Client client;

    public Order(LocalDateTime moment, OrderStatus status) {
        this.moment = moment;
        this.status = status;
    }

    public LocalDateTime getMoment() {
        return moment;
    }
    public void setMoment(LocalDateTime moment) {
        this.moment = moment;
    }
    public OrderStatus getStatus() {
        return status;
    }
    public void setStatus(OrderStatus status) {
        this.status = status;
    }
    public List<OrderItem> getItems() {
        return items;
    }
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }

    public void addItem(OrderItem item)
    {
        items.add(item);
    }

    public void removeItem(OrderItem item)
    {
        items.remove(item);
    }

    public double total()
    {
        double sum = 0;
        for (OrderItem orderItem : items)
            sum += orderItem.subTotal();
        return sum;
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("ORDER SUMMARY\n");
        sb.append("Order moment: " +moment.format(formatterTime)+ "\n");
        sb.append("Order status: " +status+ "\n");
        sb.append("Client: " +getClient().getName()+ " ("+ getClient().getBirthDate().format(formatter) +") - " +getClient().getEmail() +"\n");
        sb.append("Order items:\n");
        
        for (OrderItem orderItem : items)
            sb.append(orderItem.getProduct().getName()+ ", $"
            +orderItem.getProduct().getPrice()+ ", Quantity:"
            +orderItem.getQuantity()+", Subtotal: $" +orderItem.subTotal()+ "\n");

        sb.append("Total price: " +total());
        return sb.toString();
    }
}