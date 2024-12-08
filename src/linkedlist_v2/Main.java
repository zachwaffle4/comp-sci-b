/** ✦ . 　⁺ 　 . ✦ . 　⁺ 　 . ✦
 * Program: Linked List - Radix Sort - Revisited
 * Name: Zachary Harel
 * Class: Main
 * ✦ . 　⁺ 　 . ✦ . 　⁺ 　 . ✦
 */

package linkedlist_v2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        Integer[] arr= new Integer[20];

        for (int j = 0; j < 20; j++) {
            arr[j] = (int) (Math.random() * 100000);
        }

        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(arr));

        System.out.println("Original List: " + list);

        LinkedList<Integer> sorted = RadixSort.radixSort(list);

        System.out.println("Sorted List: " + sorted);

        long endTime = System.currentTimeMillis();

        System.out.println("Time taken: " + (endTime - startTime) + " milliseconds");
    }
}

/* OUTPUT (note again this is random and so you will not get the same list
Original List: [93868, 97443, 24581, 72739, 3107, 90294, 32858, 95233, 62468, 51815, 7973, 64963, 13524, 14372, 35595, 46743, 82248, 11432, 6453, 14836]
Sorted List: [3107, 6453, 7973, 11432, 13524, 14372, 14836, 24581, 32858, 35595, 46743, 51815, 62468, 64963, 72739, 82248, 90294, 93868, 95233, 97443]
 */