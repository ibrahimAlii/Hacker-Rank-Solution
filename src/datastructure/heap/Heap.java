package datastructure.heap;

import java.util.Arrays;

public class Heap {
    private int capacity = 10;
    private int size = 0;

    private int[] items;

    public Heap() {
        items = new int[capacity];
    }

    // Helper methods
    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private boolean hasLeftChild(int parentIndex) {
        return getLeftChildIndex(parentIndex) < size;
    }

    private boolean hasRightChild(int parentIndex) {
        return getRightChildIndex(parentIndex) < size;
    }

    private boolean hasParent(int childIndex) {
        return getParentIndex(childIndex) >= 0;
    }

    private int leftChild(int parentIndex) {
        return items[getLeftChildIndex(parentIndex)];
    }

    private int rightChild(int parentIndex) {
        return items[getRightChildIndex(parentIndex)];
    }

    private int parent(int childIndex) {
        return items[getParentIndex(childIndex)];
    }

    private void swap(int firstIndex, int secondIndex) {
        int temp = items[firstIndex];
        items[firstIndex] = items[secondIndex];
        items[secondIndex] = temp;
    }

    private void ensureCapacity() {
        if (size == capacity) {
            items = Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }

    /**
     * This method should return the first element in the heap
     *
     * @return first element in the heap [the min element];
     * @throws IllegalStateException if the heap is empty
     */
    public int peek() {
        if (size == 0) throw new IllegalStateException();
        return items[0];
    }

    public int poll() {
        if (size == 0) throw new IllegalStateException();
        int temp = items[0];
        items[0] = items[size - 1];
        size--;
        heapifyDown();
        return temp;
    }

    public void add(int item) {
        ensureCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }

    public void insertSequential(int item) {
        ensureCapacity();
        items[size] = item;
        size++;
        heapifySequentially();
    }

    private void heapifySequentially() {
        int index = size - 1;
        int prevIndex = index - 1;
        while (prevIndex >= 0 && items[index] < items[prevIndex]) {
            swap(index, prevIndex);
            index = prevIndex;
            prevIndex = index - 1;
        }
    }

    public int getElementAt(int index) {
        return items[index];
    }

    private void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && parent(index) > items[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    public void printElements() {
        for (int i = 0; i < items.length; i++) {
            System.out.print(items[i] + " ");
        }
    }

    public int size() {
        return size;
    }

    private void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
                smallerChildIndex = getRightChildIndex(index);
            }

            if (items[index] < items[smallerChildIndex]) {
                break;
            } else {
                swap(index, smallerChildIndex);
            }

            index = smallerChildIndex;
        }
    }
}

