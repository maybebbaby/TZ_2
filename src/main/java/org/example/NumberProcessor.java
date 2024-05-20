package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class NumberProcessor {
    public static void main(String[] args) {
        try {
            List<Integer> numbers = readNumbersFromFile("src/main/resources/negative.txt");
            if (numbers.isEmpty()) {
                System.out.println("Минимальное: Список пуст");
                System.out.println("Максимальное: Список пуст");
                System.out.println("Сумма: 0");
                System.out.println("Произведение: 1");
            } else {
                System.out.println("Минимальное: " + _min(numbers));
                System.out.println("Максимальное: " + _max(numbers));
                System.out.println("Сумма: " + _sum(numbers));
                System.out.println("Произведение: " + _mult(numbers));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Integer> readNumbersFromFile(String filename) throws IOException {
        Path path = Path.of(filename);
        String content = Files.readString(path);
        if (content.isBlank()) return Collections.emptyList();
        return Arrays.stream(content.trim().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int _min(List<Integer> numbers) {
        return Collections.min(numbers);
    }

    public static int _max(List<Integer> numbers) {
        return Collections.max(numbers);
    }

    public static int _sum(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }

    public static long _mult(List<Integer> numbers) {
        return numbers.stream().mapToLong(Integer::longValue).reduce(1L, (a, b) -> a * b);
    }
}
