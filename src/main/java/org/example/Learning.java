package org.example;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.Getter;
import lombok.Setter;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;


public class Learning {
    public static void main(String[] args) {
        DynamicArray array = new DynamicArray();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        System.out.println(array.toString());
    }
}

class DynamicArray {
    int size;
    int capacity = 10;
    Object[] array;

    public DynamicArray() {
        this.array = new Object[capacity];
    }

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.array = new Object[capacity];
    }

    public void add(Object data) {
        if (size >= capacity) {
            grow();
        }
        array[size++] = data;
    }

    public void insert(int index, Object data) {

    }

    public void delete(Object data) {

    }

    public int search(Object data) {
        return -1;
    }

    private void grow() {

    }

    private void shrink() {

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        String string = "";
        for (int i = 0; i < size; i++) {
            string += array[i] + ", ";
        }
        if (string != "") {
            string = string.substring(0, string.length() - 2);
        }
        return string;
    }


}

class LearnCollections {
    public static boolean isPalinedrome(String s) {
        // Convert the string to lowercase and remove all non-alphanumeric characters
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        LinkedList<Character> queue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            queue.offer(s.charAt(i));
        }
        while (queue.size() > 1) {
            char first = queue.poll();
            char last = queue.pollLast();
            if (first != last) {
                return false;
            }
        }
        return true;
    }
}

class StreamAPI {
    public static void learn() {
        // Minimum Length - minimum length of 5
        var list1 = Arrays.asList("computer", "usb", "asp");
        list1.stream().filter(x -> x.length() >= 5);

        // Select words - start with a, end with m
        var list2 = Arrays.asList("mum", "amsterdam", "bloom", "usb");
        list2.stream().filter(x -> x.startsWith("a") && x.endsWith("m"));

        // returns top 5 numbers from the list of integers in descending order.
        var list3 = Arrays.asList(78, -9, 0, 23, 54, 21, 7, 86);
        list3.stream().sorted(Comparator.reverseOrder()).limit(5);

        // square greater than 20
        var list4 = Arrays.asList(7, 2, 30, 1, -2, 3, 4);
        list4.stream().map(x -> Math.round(Math.pow(x, 2)))
                .filter(x -> x > 20);

        // replace ea to *
        var list5 = Arrays.asList("learn", "current", "deal");
        list5.stream().map(x -> x.replace("ea", "*"));

        // last word containing letter 'e'
        var list6 = Arrays.asList("plane", "ferry", "car", "bike");
        var res6 = list6.stream().sorted(Comparator.naturalOrder())
                .reduce((first, second) -> second).get();

        // shuffle sorted array
        var list7 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Collections.shuffle(list7);

        // most frequent character
        var str8 = "n093nfv034nie9";
        var res8 = str8.chars()
                .mapToObj(x -> (char) x)
                .collect(groupingBy(x -> x, counting()))
                .entrySet()
                .stream()
                .max(comparingByValue())
                .get()
                .getKey();
        System.out.println(res8);
    }
}
