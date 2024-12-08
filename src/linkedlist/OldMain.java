/** ✦ . 　⁺ 　 . ✦ . 　⁺ 　 . ✦
 * Program: Linked List
 * Name: Zachary Harel
 * Class: Main
 * ✦ . 　⁺ 　 . ✦ . 　⁺ 　 . ✦
 */

package linkedlist;

public class OldMain {
    public static void main(String[] args) {
        Integer[] array = {10, 11, 12, 13, 14, 15};
        SingleLinkedList<Integer> list = new SingleLinkedList<>(array);
        list.printForwards();
        RadixSort.reduceDigitInPlace(list);
        list.printForwards();

    }

    public static void testListMethods() {
        SingleLinkedList list = new SingleLinkedList(
            new Node(
                "b",
                new Node(
                    "c",
                    new Node(
                        "e",
                        null
                    )
                )
            )
        );

        System.out.println(list.getTail());

        list.printForwards();

        list.addToFront("a");

        list.printForwards();

        list.addToEnd("f");

        list.printForwards();

        list.addToMiddle("d", 3);

        list.printForwards();

        list.removeFirst();
        list.removeLast();

        System.out.println(list.getTail());

        list.removeFromMiddle(1);

        list.printForwards();

        System.out.println(list.size());

        System.out.println(list.getTail());

        list.printForwards();
        list.printBackwards(list.getHead());
    }
} /* OUTPUT
e
[b, c, e, ]
[a, b, c, e, ]
[a, b, c, e, f, ]
[a, b, c, d, e, f, ]
[b, c, d, ]
2
[b, c, d, ]
c b
*/

