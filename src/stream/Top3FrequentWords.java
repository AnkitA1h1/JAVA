package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Top3FrequentWords {
    public static void main(String[] args) {
        String input = "Java is a powerful and widely used programming language. Java 8 introduced the Stream API, which makes it easier to process collections of data. Using streams, developers can filter, map, sort, group, and reduce elements efficiently. The Stream API supports functional programming concepts such as lambda expressions and method references. It helps developers write clean, readable, and maintainable code. Java is commonly used for developing web applications, enterprise software, and microservices using Spring Boot. Learning Java Streams is important for improving coding skills and preparing for technical interviews.";

        Map<String, Long> collect = Arrays.stream(
                input.split("\\W+")
        ).collect(Collectors.groupingBy(Function.identity(),
                Collectors.counting()
        ));

        System.out.println(collect);

        List<Map.Entry<String, Long>> list = collect.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .toList();

        System.out.println(list);


    }
}
