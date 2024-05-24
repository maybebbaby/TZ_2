package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

class NumberProcessorTest {
    // Тесты для стандартных значений
    @Test
    void testMin() {
        assertEquals(1, NumberProcessor._min(Arrays.asList(1, 4, 2, 3)), "The min function failed");
    }

    @Test
    void testMax() {
        assertEquals(4, NumberProcessor._max(Arrays.asList(1, 4, 2, 3)), "The max function failed");
    }

    @Test
    void testSum() {
        assertEquals(10, NumberProcessor._sum(Arrays.asList(1, 4, 2, 3)), "The sum function failed");
    }

    @Test
    void testMult() {
        assertEquals(24, NumberProcessor._mult(Arrays.asList(1, 4, 2, 3)), "The mult function failed");
    }

    // Тесты для пустого списка
    @Test
    void testEmptyList() {
        assertThrows(NoSuchElementException.class, () -> NumberProcessor._min(Collections.emptyList()), "Expected NoSuchElementException for empty list in min function");
        assertThrows(NoSuchElementException.class, () -> NumberProcessor._max(Collections.emptyList()), "Expected NoSuchElementException for empty list in max function");
        assertEquals(0, NumberProcessor._sum(Collections.emptyList()), "Sum should be 0 for an empty list");
        assertEquals(1, NumberProcessor._mult(Collections.emptyList()), "Multiplication should be 1 for an empty list");
    }

    // Тесты для больших чисел
    @Test
    void testLargeNumbers() {
        List<Integer> largeNumbers = Arrays.asList(1000000, 2000000, 3000000);
        assertEquals(1000000, NumberProcessor._min(largeNumbers));
        assertEquals(3000000, NumberProcessor._max(largeNumbers));
        assertEquals(6000000, NumberProcessor._sum(largeNumbers));
        assertEquals(6000000000000000000L, NumberProcessor._mult(largeNumbers));
    }

    // Тесты с отрицательными числами
    @Test
    void testNegativeNumbers() {
        List<Integer> negativeNumbers = Arrays.asList(-1, -2, -3, -4);
        assertEquals(-4, NumberProcessor._min(negativeNumbers));
        assertEquals(-1, NumberProcessor._max(negativeNumbers));
        assertEquals(-10, NumberProcessor._sum(negativeNumbers));
        assertEquals(24, NumberProcessor._mult(negativeNumbers)); // Обратите внимание на положительное произведение четырех отрицательных чисел
    }
    // Вспомогательный метод для создания большого списка чисел
    private List<Integer> generateLargeNumberList() {
        Random random = new Random();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            numbers.add(random.nextInt());
        }
        return numbers;
    }

    // Тесты производительности
    @Test
    void testPerformanceMin() {
        List<Integer> largeNumbers = generateLargeNumberList();
        long startTime = System.nanoTime();
        int min = NumberProcessor._min(largeNumbers);
        long endTime = System.nanoTime();
        System.out.println("Тест производительности - Min: " + ((endTime - startTime) / 1_000_000) + " ms");
    }

    @Test
    void testPerformanceMax() {
        List<Integer> largeNumbers = generateLargeNumberList();
        long startTime = System.nanoTime();
        int max = NumberProcessor._max(largeNumbers);
        long endTime = System.nanoTime();
        System.out.println("Тест производительности - Max: " + ((endTime - startTime) / 1_000_000) + " ms");
    }

    @Test
    void testPerformanceSum() {
        List<Integer> largeNumbers = generateLargeNumberList();
        long startTime = System.nanoTime();
        int sum = NumberProcessor._sum(largeNumbers);
        long endTime = System.nanoTime();
        System.out.println("Тест производительности - Sum: " + ((endTime - startTime) / 1_000_000) + " ms");
    }

    @Test
    void testPerformanceMult() {
        List<Integer> largeNumbers = generateLargeNumberList();
        ong startTime = System.nanoTime();
        long mult = NumberProcessor._mult(largeNumbers);
        long endTime = System.nanoTime();
        System.out.println("Тест производительности - Mult: " + ((endTime - startTime) / 1_000_000) + " ms");
    }
}
