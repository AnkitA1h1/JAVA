package stream;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class MostCommonFirstLetter {
    public static void main(String[] args) {

        List<Employee> employees = List.of(
                new Employee(1, "Rahul", "IT", 75000),
                new Employee(2, "Priya", "HR", 55000),
                new Employee(3, "Amit", "Finance", 65000),
                new Employee(4, "Sneha", "IT", 90000),
                new Employee(5, "Vikram", "Sales", 48000),
                new Employee(6, "Anjali", "HR", 62000),
                new Employee(7, "Rohit", "Finance", 85000),
                new Employee(8, "Neha", "IT", 70000),
                new Employee(9, "Karan", "Sales", 52000),
                new Employee(10, "Pooja", "Marketing", 60000),
                new Employee(11, "Arjun", "IT", 95000),
                new Employee(12, "Meera", "Marketing", 72000),
                new Employee(13, "Suresh", "Finance", 58000),
                new Employee(14, "Kavita", "HR", 68000),
                new Employee(15, "Deepak", "Sales", 80000)
        );


        Optional<Map.Entry<Character, Long>> max = employees.stream()
                .collect(Collectors.groupingBy(employee -> employee.getName().charAt(0),
                        Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue());

        System.out.println(max.get().getKey());
    }
}
