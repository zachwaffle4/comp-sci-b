/** ✦ . 　⁺ 　 . ✦ . 　⁺ 　 . ✦
 * Program: Linked List - Radix Sort - Revisited
 * Name: Zachary Harel
 * Class: RadixSort - contains static methods for sorting a linked list using radix sort
 * ✦ . 　⁺ 　 . ✦ . 　⁺ 　 . ✦
 */

package linkedlist_v2;

import java.util.LinkedList;
import java.util.ListIterator;

public class RadixSort {
    public static LinkedList<Integer> radixSort(LinkedList<Integer> list) {
        int maxLen = 0;
        for (int i : list) {
            int len = String.valueOf(i).length();
            maxLen = Math.max(len, maxLen);
        }

        LinkedList<Integer> sorted = new LinkedList<>(list);

        for (int i = 1; i <= maxLen; i++) {
            LinkedList<Integer>[] buckets = putInBuckets(sorted, maxLen-i, maxLen);
            sorted = buckets[0];
            for (int j = 1; j < 10; j++) {
                if (!buckets[j].isEmpty())
                    sorted.addAll(buckets[j]);
            }
        }

        return sorted;
    }

    public static void radixSortInPlace(LinkedList<Integer> list) {
        list = radixSort(list);
    }

    public static void reduceDigitInPlace(LinkedList<Integer> list) {
        ListIterator<Integer> iterator = list.listIterator();
        while (iterator.hasNext()) {
            int value = iterator.next();
            iterator.set(value / 10);
        }
    }

    public static LinkedList<Integer> reducedDigits(LinkedList<Integer> list) {
        LinkedList<Integer> copy = new LinkedList<>(list);
        reduceDigitInPlace(copy);
        return copy;
    }

    public static LinkedList<Integer>[] putInBuckets(LinkedList<Integer> list, int index, int numOfDigits) {
        LinkedList<Integer>[] buckets = new LinkedList[10];
        ListIterator<Integer> iterator = list.listIterator();

        for (int i = 0; i < 10; i++) {
            buckets[i] = new LinkedList<>();
        }

        while (iterator.hasNext()) {
            int num = iterator.next();
            int digit = digitAt(num, index, numOfDigits);
            buckets[digit].add(num);
        }

        return buckets;
    }

    public static int digitAt(int num, int index, int numOfDigits) {
        String str = String.format("%0" + numOfDigits + "d", num);
        return Integer.parseInt(str.substring(index, index+1));
    }
}
