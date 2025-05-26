/**
 * Name: Zach Harel
 * Project: Max Heap
 * File: MaxHeap
 * Description: Uses a LinkedList as a Max Heap / Priority Queue implementation (with peek, pop, push)
 */

package heaps;

import java.util.LinkedList;
import java.util.List;

public class MaxHeap<E extends Comparable<E>> {
    private final List<E> heap;

    public MaxHeap() {
        heap = new LinkedList<>();
    }

    public MaxHeap(Iterable<E> heap) {
        this();
        pushAll(heap);
    }


    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public int size() {
        return heap.size()-1;
    }

    public List<E> toList() {
        return heap;
    }

    public String toString(){
        return heap.toString();
    }

    public E peek() {
        return heap.getFirst();
    }

    public E pop() {
        E value = heap.getFirst();
        swap(0,  heap.size()-1);
        heap.removeLast();
        heapifyDown();
        return  value;
    }

    public void heapifyUp() {
        int i  = heap.size() / 2;
        E value =  heap.getLast();
        while (heap.indexOf(value) > 0 && heap.get(i).compareTo(value) <= 0) {
            swap(i, heap.indexOf(value));
            i /= 2;
        }
    }

    public void heapifyDown() {
        int currentIndex = 0;

        while (true) {
            int leftChildIndex = 2 * currentIndex + 1;
            int rightChildIndex = 2 * currentIndex + 2;
            int largestIndex = currentIndex;

            if (leftChildIndex < size() && heap.get(leftChildIndex).compareTo(heap.get(largestIndex)) > 0) {
                largestIndex = leftChildIndex;
            }

            if (rightChildIndex < size() && heap.get(rightChildIndex).compareTo(heap.get(largestIndex)) > 0) {
                largestIndex = rightChildIndex;
            }

            if (largestIndex != currentIndex) {
                swap(currentIndex, largestIndex);
                currentIndex = largestIndex;
            } else {
                break;
            }
        }
    }

    public void push(E value) {
        heap.add(value);
        heapifyUp();
    }

    public void pushAll(Iterable<? extends E> values) {
        for (E value : values) {
            push(value);
        }
    }

    public void swap(int a, int b) {
        swap(heap, a, b);
    }

    public List<E> sorted() {
        List<E> sorted = new LinkedList<>();
        while (!heap.isEmpty()) {
            sorted.add(pop());
        }
        return sorted.reversed();
    }

    public static <T> void swap(List<T> arr, int a, int b) {
        if (a >= arr.size() || b >= arr.size()) throw new IllegalArgumentException();
        T temp = arr.get(a);
        arr.set(a, arr.get(b));
        arr.set(b, temp);
    }

    public static <T extends Comparable<T>> List<T> heapSort(List<T> arr) {
        MaxHeap<T> heap = new MaxHeap<>(arr);
        return heap.sorted();
    }
}
