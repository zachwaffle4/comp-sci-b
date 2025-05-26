/**
 * PROJECT: Tree Functions Lab
 * NAME: Zach Harel
 * CLASS: BinarySearchTree - implements a binary search tree structure with various methods for manipulating the tree
 */

package binarytrees;

import org.jetbrains.annotations.NotNull; // intellij wanted me to mark parameters as non null

import java.util.*; // intellij replaced the individual imports with this
// what i actually used: Comparable, Iterable, List, ArrayList, Iterator

public class BinarySearchTree<E extends Comparable<E>> implements Iterable<E> {
    private E value;
    private BinarySearchTree<E> left;
    protected BinarySearchTree<E> right;

    public BinarySearchTree(E value, BinarySearchTree<E> left, BinarySearchTree<E> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public BinarySearchTree(Collection<E> values) {
        addAll(values);
    }

    public BinarySearchTree(E[] values) {
        addAll(Arrays.asList(values));
    }

    public BinarySearchTree(E value) {
        this(value, null, null);
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public boolean hasLeft() {
        return left != null;
    }

    public BinarySearchTree<E> getLeft() {
        return left;
    }

    public boolean hasRight() {
        return right != null;
    }

    public void setLeft(BinarySearchTree<E> left) {
        this.left = left;
    }

    public BinarySearchTree<E> getRight() {
        return right;
    }

    public void setRight(BinarySearchTree<E> right) {
        this.right = right;
    }

    public boolean isEmpty() {
        return value == null;
    }

    public List<E> inOrder() {
        List<E> list = new ArrayList<>(countNodes());

        if (left != null) {
            list.addAll(left.toList());
        }

        list.add(value);
        if (right != null) {
            list.addAll(right.toList());
        }

        return list;
    }

    // this looks rly extra but it's just to make the output look like the example in the lab
    public String inOrderString() {
        StringBuilder sb = new StringBuilder();
        for (E value : inOrder()) {
            sb.append(value).append(" ");
        }
        return sb.toString();
    }

    public List<E> preOrder() {
        List<E> output = new ArrayList<>(countNodes());
        if (left != null) {
            output.addAll(left.postOrder());
        }
        if (right != null) {
            output.addAll(right.postOrder());
        }
        output.add(value);
        return output;
    }

    public String preOrderString() {
        StringBuilder sb = new StringBuilder();
        for (E value : preOrder()) {
            sb.append(value).append(" ");
        }
        return sb.toString();
    }

    public List<E> postOrder() {
        List<E> output = new ArrayList<>(countNodes());
        if (left != null) {
            output.addAll(left.postOrder());
        }
        if (right != null) {
            output.addAll(right.postOrder());
        }
        output.add(value);
        return output;
    }

    public String postOrderString() {
        StringBuilder sb = new StringBuilder();
        for (E value : postOrder()) {
            sb.append(value).append(" ");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return inOrderString();
    }

    public List<E> toList() {
        return inOrder();
    }

    @NotNull // intellij suggested it
    @Override
    public Iterator<E> iterator() {
        return inOrder().iterator();
    }

    public int countNodes() {
        int count = 1;
        if (left != null) {
            count += left.countNodes();
        }
        if (right != null) {
            count += right.countNodes();
        }
        return count;
    }

    public int size() {
        return countNodes();
    }

    public int countLeaves() {
        if (left == null && right == null) {
            return 1;
        }
        int count = 0;
        if (left != null) {
            count += left.countLeaves();
        }
        if (right != null) {
            count += right.countLeaves();
        }
        return count;
    }

    public void add(E value) {
        if (isEmpty()) {
            setValue(value);
        } else if (value.compareTo(getValue()) < 0) {
            if (hasLeft()) {
                getLeft().add(value);
            } else {
                setLeft(new BinarySearchTree<>(value));
            }
        } else {
            if (hasRight()) {
                getRight().add(value);
            } else {
                setRight(new BinarySearchTree<>(value));
            }
        }
    }

    // wow i love iterables
    public void addAll(Iterable<? extends E> values) {
        for (E value : values) {
            add(value);
        }
    }

    public void remove(E value) {
        if (value.compareTo(getValue()) == 0) {
            if (hasLeft() && hasRight()) {
                setValue(getRight().minValue());
                getRight().remove(getValue());
            } else if (hasLeft()) {
                setValue(getLeft().getValue());
                setRight(getLeft().getRight());
                setLeft(getLeft().getLeft());
            } else if (hasRight()) {
                setValue(getRight().getValue());
                setLeft(getRight().getLeft());
                setRight(getRight().getRight());
            } else {
                setValue(null);
            }
        } else if (value.compareTo(getValue()) < 0) {
            if (hasLeft()) {
                getLeft().remove(value);
            }
        } else {
            if (hasRight()) {
                getRight().remove(value);
            }
        }
    }

    public void removeAll(Iterable<? extends E> values) {
        for (E value : values) {
            remove(value);
        }
    }

    public void removeLeaves() {
        if (hasLeft()) {
            if (getLeft().isLeaf()) {
                setLeft(null);
            } else {
                getLeft().removeLeaves();
            }
        }
        if (hasRight()) {
            if (getRight().isLeaf()) {
                setRight(null);
            } else {
                getRight().removeLeaves();
            }
        }
    }

    private boolean isLeaf() {
        return !hasLeft() && !hasRight();
    }

    public void clear() {
        setValue(null);
        setLeft(null);
        setRight(null);
    }

    public E minValue() {
        if (hasLeft()) {
            return getLeft().minValue();
        } else {
            return getValue();
        }
    }

    public E maxValue() {
        if (hasRight()) {
            return getRight().maxValue();
        } else {
            return getValue();
        }
    }

    public int height() {
        int leftHeight = hasLeft() ? getLeft().height() : 0;
        int rightHeight = hasRight() ? getRight().height() : 0;
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public int width() {
        int leftWidth = hasLeft() ? getLeft().width() : 0;
        int rightWidth = hasRight() ? getRight().width() : 0;
        int thisWidth = (hasLeft() ? getLeft().height() : 0) + (hasRight() ? getRight().height() : 0) + 1;

        return Math.max(thisWidth, Math.max(leftWidth, rightWidth));
    }

    public boolean contains(E value) {
        if (value.compareTo(getValue()) == 0) {
            return true;
        } else if (value.compareTo(getValue()) < 0) {
            return hasLeft() && getLeft().contains(value);
        } else {
            return hasRight() && getRight().contains(value);
        }
    }

    public boolean containsAll(Iterable<? extends E> values) {
        for (E value : values) {
            if (!contains(value)) {
                return false;
            }
        }
        return true;
    }

    public E get(int index) {
        if (index < 0 || index >= countNodes()) {
            throw new IndexOutOfBoundsException();
        }

        int leftCount = left == null ? 0 : left.countNodes();

        if (index < leftCount) {
            return left.get(index);
        } else if (index == leftCount) {
            return value;
        } else {
            return right.get(index - leftCount - 1);
        }
    }

    public int indexOf(E value) {
        if (value.compareTo(getValue()) == 0) {
            return left == null ? 0 : left.countNodes();
        } else if (value.compareTo(getValue()) < 0) {
            return left == null ? -1 : left.indexOf(value);
        } else {
            return right == null ? -1 : right.indexOf(value);
        }
    }

    public boolean isDescendant(E value) {
        return contains(value);
    }
}
