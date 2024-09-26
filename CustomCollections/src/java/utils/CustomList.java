package utils;

import java.util.Collection;
import java.util.Comparator;

public interface CustomList<T> {
    void add(T element);

    void add(int index, T element);

    T set(int index, T element);

    T get(int index);

    T remove(int index);

    boolean addAll(CustomList<? extends T> arr);

    boolean addAll(Collection<? extends T> c);

    int size();

    void clear();

    T[] toArray();

    void sort();

    void sort(Comparator<? super T> c);

}
