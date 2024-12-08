/** ✦ . 　⁺ 　 . ✦ . 　⁺ 　 . ✦
 * Program: Linked List -- Radix Sort
 * Name: Zachary Harel
 * Class: RadixSort - contains static methods for sorting a linked list using radix sort
 * ✦ . 　⁺ 　 . ✦ . 　⁺ 　 . ✦
 */

package linkedlist;

import java.util.Arrays;

public class RadixSort {
    public static SingleLinkedList<Integer> radixSort(SingleLinkedList<Integer> list) {
        int maxLen = 0;
        Node<Integer> node = list.getHead();
        while (node != null) {
            int len = String.valueOf(node.getValue()).length();
            maxLen = Math.max(len, maxLen);
            node = node.getNext();
        }

        SingleLinkedList<Integer> sorted = list.copy();

        for (int i = 1; i <= maxLen; i++) {
            SingleLinkedList<Integer>[] buckets = putInBuckets(sorted.getHead(), maxLen-i, maxLen);
            sorted = buckets[0];
            for (int j = 1; j < 10; j++) {
                if (buckets[j].getHead() != null)
                    sorted.addToEnd(buckets[j]);
            }
        }

        return sorted;
    }

    public static void radixSortInPlace(SingleLinkedList<Integer> list) {
        list = radixSort(list);
    }

    public static void reduceDigitInPlace(SingleLinkedList<Integer> list) {
        Node<Integer> node = list.getHead();
        while (node != null) {
            node.setValue(node.getValue()/10);
            node = node.getNext();
        }
    }

    public static SingleLinkedList<Integer> reducedDigits(SingleLinkedList<Integer> list) {
        SingleLinkedList<Integer> copy = list.copy();
        reduceDigitInPlace(copy);
        return copy;
    }

    public static SingleLinkedList<Integer>[] putInBuckets(Node<Integer> head, int index, int numOfDigits) {
        SingleLinkedList<Integer>[] buckets = new SingleLinkedList[10];
        Node<Integer> node = head;

        for (int i = 0; i < 10; i++) {
            buckets[i] = new SingleLinkedList<>();
        }

        while (node != null) {
            int num = node.getValue();
            int digit = digitAt(num, index, numOfDigits);
            buckets[digit].addToEnd(num);

            node = node.getNext();
        }

        return buckets;
    }

    public static int digitAt(int num, int index, int numOfDigits) {
        String str = String.format("%0" + numOfDigits + "d", num);
        return Integer.parseInt(str.substring(index, index+1));
    }
}
