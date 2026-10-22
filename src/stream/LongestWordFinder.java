package stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LongestWordFinder {
    public static void main(String[] args) {
        String sentence = "The quick, brown fox  jumped over the lazy dog!";
        // \\W+ splits by any sequence of non-alphanumeric characters
        List<String> words = List.of(sentence.split("\\W+"));

        System.out.println(words);

        List<String> list = Arrays.stream(
                sentence
                        .split("\\W+")
        ).toList();

        System.out.println(list);

        Optional<String> max = list.stream()
                .max(Comparator.comparing(word -> word.length()));

        System.out.println(max.get());
    }
}
