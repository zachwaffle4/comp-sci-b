/** ✦ . 　⁺ 　 . ✦ . 　⁺ 　 . ✦
 * Program: Linked List -- Radix Sort
 * Name: Zachary Harel
 * Class: Main - tests the radix sort method on 3 randomly generated lists
 * ✦ . 　⁺ 　 . ✦ . 　⁺ 　 . ✦
 */

package linkedlist;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++){
            ArrayList<Integer> arr = new ArrayList<>(10);
            for (int j = 0; j < 20; j++) {
                arr.add((int) (Math.random() * 100000));
            }

            SingleLinkedList<Integer> list = new SingleLinkedList<>(arr);

            System.out.println("Original List: " + list);

            System.out.println("Sorted List: " + RadixSort.radixSort(list));
        }
    }
}

/* EXAMPLE OUTPUT: (note that since list generation is random the output will vary)
  Original List: [63569, 75346, 39570, 63286, 26201, 51345, 2795, 5348, 60882, 28896, 48728, 3909, 33885, 94245, 87514, 82226, 61220, 26848, 76773, 42438]
  Sorted List: [2795, 3909, 5348, 26201, 26848, 28896, 33885, 39570, 42438, 48728, 51345, 60882, 61220, 63286, 63569, 75346, 76773, 82226, 87514, 94245]
  Original List: [1694, 90675, 61366, 14276, 89508, 63534, 43678, 37440, 87604, 78741, 45786, 90291, 72783, 30886, 6192, 69015, 21514, 28039, 13320, 16035]
  Sorted List: [1694, 6192, 13320, 14276, 16035, 21514, 28039, 30886, 37440, 43678, 45786, 61366, 63534, 69015, 72783, 78741, 87604, 89508, 90291, 90675]
  Original List: [51397, 56394, 15536, 94213, 87393, 60206, 63192, 4257, 64237, 29786, 32037, 46743, 46834, 33398, 49319, 37317, 48999, 25090, 93969, 93863]
  Sorted List: [4257, 15536, 25090, 29786, 32037, 33398, 37317, 46743, 46834, 48999, 49319, 51397, 56394, 60206, 63192, 64237, 87393, 93863, 93969, 94213]
 */