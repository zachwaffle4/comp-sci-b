/**
 * Name: Zach Harel
 * Project: Max Heap Lab
 * File: Main
 */

package heaps;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MaxHeap<Integer> heap = new MaxHeap<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        List<Double> doubles = Arrays.asList(63.0, 27.0, 54.0, 36.0, 0.11, 5.0, 4.0, 3.0, 1.0, 2.0);
        System.out.println(STR."Initial Heap: \{heap}");

        List<Integer> sorted = heap.sorted();
        System.out.println("Sorted Heap: " + sorted);

        System.out.println("Double List: " + doubles);
        System.out.println("Double Heap: " + new MaxHeap<>(doubles));
        System.out.println("Heap-Sorted Double List: " + MaxHeap.heapSort(doubles));


    }
}

/* NEW OUTPUT
Initial Heap: [10, 9, 8, 5, 6, 7, 4, 2, 3, 1]
Sorted Heap: [1, 3, 2, 4, 5, 6, 7, 8, 9, 10]
Double List: [63.0, 27.0, 54.0, 36.0, 0.11, 5.0, 4.0, 3.0, 1.0, 2.0]
Double Heap: [63.0, 54.0, 36.0, 27.0, 3.0, 5.0, 4.0, 0.11, 1.0, 2.0]
Heap-Sorted Double List: [0.11, 1.0, 2.0, 3.0, 4.0, 5.0, 27.0, 36.0, 54.0, 63.0]
 */

/* OLD OUTPUT
 Initial Heap: [10, 9, 8, 5, 6, 7, 4, 2, 3, 1]
Heap Plus 3: [10, 9, 8, 5, 6, 7, 4, 2, 3, 1, 3]
Heap Plus 12: [12, 10, 8, 9, 6, 7, 5, 2, 3, 1, 3, 4]
Popping 12
New Heap: [10, 9, 8, 4, 6, 7, 5, 2, 3, 1, 3]
Popping 10
New Heap: [9, 6, 8, 4, 3, 7, 5, 2, 3, 1]
Popping 9
New Heap: [8, 6, 7, 4, 3, 1, 5, 2, 3]
Popping 8
New Heap: [7, 6, 5, 4, 3, 1, 3, 2]
Popping 7
New Heap: [6, 4, 5, 2, 3, 1, 3]
Popping 6
New Heap: [5, 4, 3, 2, 3, 1]
Popping 5
New Heap: [4, 2, 3, 1, 3]
Popping 4
New Heap: [3, 2, 3, 1]
Popping 3
New Heap: [2, 1, 3]
Popping 2
New Heap: [3, 1]
Popping 3
New Heap: [1]
Popping 1
New Heap: []

Process finished with exit code 0
 */
