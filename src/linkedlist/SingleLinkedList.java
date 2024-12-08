/** ✦ . 　⁺ 　 . ✦ . 　⁺ 　 . ✦
 * Program: Linked List -- Radix Sort
 * Name: Zachary Harel
 * Class: SingleLinkedList - represents a singly linked list
 * ✦ . 　⁺ 　 . ✦ . 　⁺ 　 . ✦
 */

package linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SingleLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;

    public SingleLinkedList() {
        head = null;
    }

    public SingleLinkedList(Node<E> head) {
        this.head = head;
        Node<E> node = head;
        if (node != null) {
            while (node.getNext() != null) {
                node = node.getNext();
            }
        }
        this.tail = node;
    }

    public SingleLinkedList(List<E> list) {
        this.head = new Node<>(list.get(0), null);
        this.tail = head;
        for (int i = 1; i < list.size(); i++) {
            addToEnd(list.get(i));
        }
        this.tail = getTail();
    }


    public SingleLinkedList(E[] list) {
        this(Arrays.asList(list));
    }

    public void addToFront(E value) {
        head = new Node<>(value, head);
    }

    public void addToEnd(E value) {
        addToEnd(new Node<>(value, null));
    }

    public void addToEnd(Node<E> node) {
        if (head == null && tail == null) {
            head = node;
        } else {
            tail.setNext(node);
        }
        tail = node;
    }

    public void addToEnd(SingleLinkedList<E> other) {
        if (other == null || other.head == null) {
            return;
        }
        if (this.head == null) {
            this.head = other.head;
        } else {
            this.tail.setNext(other.head);
        }
        this.tail = other.tail;
    }

    public void addToMiddle(E value, int index) {
        Node<E> temp = head;
        for (int i = 0; i < index-1; i++) {
            temp = temp.getNext();
        }
        temp.setNext(new Node<>(value, temp.getNext()));
    }

    public void removeFirst() {
        head = head.getNext();
    }

    public void removeLast() {
        Node<E> node = head;
        while (node.getNext().getNext() != null) {
            node = node.getNext();
        }
        node.setNext(null);
        tail = node;
    }

    public void removeFromMiddle(int index) {
        Node<E> node = head;
        for (int i = 0; i <= index; i++) {
            node = node.getNext();
        }
        Node<E> toReturn = node.getNext();
        node.setNext(node.getNext().getNext());
    }

    @Override
    public String toString() {
        if (head == null) {
            return "[ ]";
        }
        Node<E> node = head;
        StringBuilder str = new StringBuilder("[");
        while (node.getNext() != null) {
            str.append(node).append(", ");
            node = node.getNext();
        }
        str.append(node.getValue()).append("]");
        return str.toString();
    }

    public void printForwards() {
        System.out.println(this);
    }

    public void printBackwards(Node<E> node) {
        if (node.getNext() == null) {
            return;
        }
        printBackwards(node.getNext());
        System.out.print(node + " ");
    }

    public int size() {
        if (head == null) {
            return 0;
        }
        int i = 0;
        Node<E> node = head;
        while (node.getNext() != null) {
            i += 1;
            node = node.getNext();
        }
        return i;
    }

    public Node<E> getHead() {
        return head;
    }

    public Node<E> getTail() {
        return tail;
    }

    public List<E> asList() {
        List<E> list = new ArrayList<>(size());
        Node<E> node = head;
        while (node != null) {
            list.add(node.getValue());
            node = node.getNext();
        }
        return list;
    }

    public SingleLinkedList<E> copy() {
        return new SingleLinkedList<>(this.asList());
    }

    public void setHead(Node<E> head) {
        this.head = head;
    }
}

