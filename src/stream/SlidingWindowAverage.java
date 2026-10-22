package stream;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SlidingWindowAverage {
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(2,3,4,7,10,16,22);
        int window = 3;
        // window = 3 -> range will be input size - (window-1)
        // first need to define the range of input

        List<String> list1 = IntStream.range(0, input.size() - (window - 1))
                .mapToObj(i -> input.subList(i, i + window))
                .map(list -> list.stream()
                        .mapToInt(num -> num)
                        .average()
                        .orElse(0.0)
                )
                .map(avg -> String.format("%.2f", avg))
                .toList();

        System.out.println(list1);
    }
}
