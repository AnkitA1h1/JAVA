package stream;

import java.util.Comparator;
import java.util.List;

public class Top3OrdersByAmount {

    public static void main(String[] args) {

        List<Order> orders = List.of(
                new Order(101, "Rahul", 2500.50),
                new Order(102, "Priya", 7800.00),
                new Order(103, "Amit", 4500.75),
                new Order(104, "Sneha", 12000.00),
                new Order(105, "Vikram", 3200.25),
                new Order(106, "Neha", 9500.50),
                new Order(107, "Rohit", 6700.00),
                new Order(108, "Anjali", 15000.75),
                new Order(109, "Karan", 8900.00),
                new Order(110, "Pooja", 11000.50),
                new Order(111, "Arjun", 15000.75),
                new Order(112, "Meera", 5600.25),
                new Order(113, "Deepak", 18500.00),
                new Order(114, "Kavita", 4200.00),
                new Order(115, "Suresh", 13500.50)
        );

        List<Order> list = orders.stream()
                .sorted(Comparator.comparingDouble(Order::getAmount).reversed())
                .limit(3)
                .toList();

        System.out.println(list);

    }
}
