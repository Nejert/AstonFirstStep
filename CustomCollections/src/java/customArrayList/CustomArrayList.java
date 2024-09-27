package customArrayList;

import utils.CustomCollections;
import utils.CustomList;

import java.util.Collection;
import java.util.Comparator;

public class CustomArrayList<T> implements CustomList<T> {
    private T[] array;
    private int size = 0;
    private int capacity;
    private boolean isSorted = false;

    public CustomArrayList() {
        this.capacity = 10;
        array = (T[]) new Object[capacity];
    }

    public CustomArrayList(T[] arr) {
        this.size = arr.length;
        this.capacity = arr.length;
        this.array = arr;
    }

    public CustomArrayList(int capacity) {
        if (capacity < 0) throw new IllegalArgumentException("Capacity cannot be negative value");
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
    }

    public CustomArrayList(CustomList<? extends T> list) {
        this.size = list.size();
        this.capacity = list.size();
        this.array = list.toArray();
    }

    public CustomArrayList(Collection<? extends T> list) {
        this.clear();
        this.addAll(list);
    }

    public void add(T element) {
        add(size, element);
        setSorted(false);
    }

    public void add(int index, T element) {
        checkBounds(index);
        if (++size == capacity) expand();
        for (int i = size - 1; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = element;
        setSorted(false);
    }

    @Override
    public boolean addAll(CustomList<? extends T> arr) {
        if (arr == null) throw new NullPointerException("Collection cannot be null");
        for (int i = 0; i < arr.size(); i++) {
            this.add(arr.get(i));
        }
        setSorted(false);
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        if (c == null) throw new NullPointerException("Collection cannot be null");
        for (T e : (T[]) c.toArray()) {
            this.add(e);
        }
        setSorted(false);
        return true;
    }

    public T get(int index) {
        checkBounds(index);
        return array[index];
    }

    public int size() {
        return size;
    }

    public T remove(int index) {
        checkBounds(index);
        T element = array[index];
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return element;
    }

    public T set(int index, T element) {
        checkBounds(index);
        setSorted(false);
        return array[index] = element;
    }

    @Override
    public void clear() {
        size = 0;
        capacity = 10;
        this.array = (T[]) new Object[capacity];
        setSorted(false);
    }

    public void sort(Comparator<? super T> c) {
        if (isSorted()) return;
        if (c == null) {
            c = (Comparator<? super T>) Comparator.naturalOrder();
        }
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (c.compare(array[j + 1], array[j]) < 0) CustomCollections.swap(array, j, j + 1);
            }
        }
        setSorted(true);
    }

    public void sort() {
        sort(null);
    }

    public boolean isSorted() {
        return isSorted;
    }

    public void setSorted(boolean sorted) {
        isSorted = sorted;
    }

    @Override
    public String toString() {
        if (size == 0)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(array[i]);
            if (i == size - 1) return b.append(']').toString();
            b.append(", ");
        }
    }

    @Override
    public T[] toArray() {
        return CustomCollections.copy(this.array, size);
    }

    private void expand() {
        capacity *= 2;
        this.array = CustomCollections.copy(this.array, capacity);
    }

    private void checkBounds(int index) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("Index " + index + " out of bounds " + size);
    }
}
