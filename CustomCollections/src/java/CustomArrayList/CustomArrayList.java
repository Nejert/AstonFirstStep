package CustomArrayList;

public class CustomArrayList<T> {
    private T[] array;
    private int size = 0;
    private int capacity;

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

    public void add(T element) {
        if (size == capacity) {
            expand();
        }
        this.array[size++] = element;
    }

    public void add(int index, T element) {
        checkBounds(index);
        if (++size == capacity) {
            expand();
        }
        T[] arr = (T[]) new Object[capacity];
        for (int i = 0, j = 0; i < size; i++) {
            if (i == index) {
                T temp = array[j];
                arr[j++] = element;
                arr[j++] = temp;
                continue;
            }
            arr[j++] = array[i];
        }
        array = arr;
    }

    public void addAll(T[] arr) {
        if (arr == null) throw new NullPointerException("Array cannot be null");
        this.array = arr;
        this.size = arr.length;
        this.capacity = arr.length;
    }

    public void addAll(CustomArrayList<T> arr) {
        if (arr == null) throw new NullPointerException("Array cannot be null");
        this.array = arr.array;
        this.size = arr.size;
        this.capacity = arr.capacity;
    }

    public T get(int index) {
        checkBounds(index);
        return array[index];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T remove(int index) {
        checkBounds(index);
        T[] arr = (T[]) new Object[capacity];
        for (int i = 0, j = 0; i < size; i++) {
            if (i == index) continue;
            arr[j++] = array[i];
        }
        size--;
        array = arr;
        return array[index];
    }

    public T set(int index, T element) {
        checkBounds(index);
        return array[index] = element;
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

    private void expand() {
        capacity *= 2;
        array = copy(array);
    }

    private T[] copy(T[] arr) {
        T[] copy = (T[]) new Object[capacity];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }
        return copy;
    }

    private void checkBounds(int index) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("Index " + index + " out of bounds " + size);
    }
}
