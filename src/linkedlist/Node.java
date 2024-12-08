/** ✦ . 　⁺ 　 . ✦ . 　⁺ 　 . ✦
 * Program: Linked List -- Radix Sort
 * Name: Zachary Harel
 * Class: Node - represents a node in a linked list
 * ✦ . 　⁺ 　 . ✦ . 　⁺ 　 . ✦
 */

package linkedlist;

public class Node<E> {
    private E value;
    private Node<E> next;

    public Node(E value, Node<E> next) {
        this.next = next;
        this.value = value;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public String toString() {
        return value.toString();
    }

    public boolean equals(Object other) {
        if (other.getClass() == Node.class) {
            Node<E> otherN = (Node<E>) other;
            if (this.next == null && (otherN.next == null)) {
                return true;
            }
            if (this.next == null || (otherN.next == null)) {
                return false;
            }
            return (this.value == otherN.value) && (this.next == otherN.next);
        } else {
            return false;
        }
    }
}
