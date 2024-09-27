package customLinkedList;

import utils.CustomList;

import java.util.Collection;
import java.util.Comparator;

public class CustomLinkedList<T> implements CustomList<T> {
    private int size = 0;
    private boolean isSorted = false;
    private Node<T> first;
    private Node<T> last;

    public CustomLinkedList() {
    }

    public CustomLinkedList(T[] arr) {
        for (Object e : arr) add((T) e);
        setSorted(false);
    }

    public CustomLinkedList(CustomList<? extends T> list) {
        this.addAll(list);
    }

    public CustomLinkedList(Collection<? extends T> list) {
        this.addAll(list);
    }

    @Override
    public void add(T element) {
        add(size, element);
    }

    @Override
    public void add(int index, T element) {
        checkBounds(index);
        if (index == size) {
            Node<T> l = last;
            Node<T> newNode = new Node<>(l, element, null);
            last = newNode;
            if (l == null)
                first = newNode;
            else
                l.next = newNode;
            size++;
        } else {
            Node<T> found = node(index);
            Node<T> newNode = new Node<>(found.prev, element, found);
            found.prev.next = newNode;
            found.prev = newNode;
            size++;
        }
        setSorted(false);
    }

    @Override
    public T set(int index, T element) {
        checkBounds(index);
        Node<T> found = node(index);
        T oldVal = found.data;
        found.data = element;
        setSorted(false);
        return oldVal;
    }

    @Override
    public T get(int index) {
        checkBounds(index);
        return node(index).data;
    }

    @Override
    public T remove(int index) {
        checkBounds(index);
        Node<T> found = node(index);
        T element = found.data;
        Node<T> prev = found.prev;
        Node<T> next = found.next;
        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            found.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            found.next = null;
        }

        found.data = null;
        size--;
        return element;
    }

    @Override
    public boolean addAll(CustomList<? extends T> arr) {
        if (arr == null || arr.size() == 0) throw new NullPointerException("Collection cannot be null");
        for (int i = 0; i < arr.size(); i++) {
            add(arr.get(i));
        }
        setSorted(false);
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        if (c == null || c.size() == 0) throw new NullPointerException("Collection cannot be null");
        for (Object e : c.toArray()) add((T) e);
        setSorted(false);
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        for (Node<T> n = first; n != null; ) {
            Node<T> next = n.next;
            n.data = null;
            n.next = null;
            n.prev = null;
            n = next;
        }
        first = last = null;
        setSorted(false);
        size = 0;
    }

    @Override
    public T[] toArray() {
        T[] res = (T[]) new Object[size];
        Node<T> n = first;
        for (int i = 0; i < size; i++) {
            res[i] = n.data;
            n = n.next;
        }
        return res;
    }

    @Override
    public void sort() {
        sort(null);
    }

    @Override
    public void sort(Comparator<? super T> c) {
        if (isSorted()) return;
        if (c == null) {
            c = (Comparator<? super T>) Comparator.naturalOrder();
        }
        if (first.next == null) {
            setSorted(true);
            return;
        }
        for (int i = 0; i < size - 1; i++) {
            Node<T> fir = first;
            Node<T> sec = first.next;
            for (int j = 0; j < size - i - 1; j++) {
                if (c.compare(fir.data, sec.data) > 0) swap(fir, sec);
                fir = sec;
                sec = sec.next;
            }
        }
        setSorted(true);
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append('[');
        for (Node<T> n = first; n != null; ) {
            b.append(n.data);
            Node<T> next = n.next;
            if (next == null) return b.append(']').toString();
            n = next;
            b.append(", ");
        }
        return "[]";
    }

    public boolean isSorted() {
        return isSorted;
    }

    public void setSorted(boolean sorted) {
        isSorted = sorted;
    }

    private void swap(Node<T> i, Node<T> j) {
        T tmpData = i.data;
        i.data = j.data;
        j.data = tmpData;
    }

    private Node<T> node(int index) {
        if (index < (size >> 1)) {
            Node<T> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<T> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    private void checkBounds(int index) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("Index " + index + " out of bounds " + size);
    }

    private class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(Node<T> prev, T element, Node<T> next) {
            this.data = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
