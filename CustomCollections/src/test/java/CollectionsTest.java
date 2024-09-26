import customArrayList.CustomArrayList;
import org.junit.jupiter.api.Test;
import utils.CustomList;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CollectionsTest {
    @Test
    public void customArrayListTest() {
        CustomList<Integer> list;
        Integer[] someArray = {10, 20, 30};
        List<Integer> someList = Arrays.asList(someArray);

        list = new CustomArrayList<>();
        assertArrayEquals(new Object[0], list.toArray());

        list = new CustomArrayList<>(someArray);
        assertArrayEquals(new Object[]{10, 20, 30}, list.toArray());
        assertEquals(3, list.size());

        list = new CustomArrayList<>(20);
        list.add(1);
        assertArrayEquals(new Object[]{1}, list.toArray());

        list.add(2);
        list = new CustomArrayList<>(list);
        assertArrayEquals(new Object[]{1, 2}, list.toArray());

        list.clear();
        assertArrayEquals(new Object[0], list.toArray());

        list.add(1);
        assertArrayEquals(new Object[]{1}, list.toArray());
        assertEquals(1, list.size());

        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        assertArrayEquals(new Object[]{1, 2, 3, 4, 5}, list.toArray());
        assertEquals(5, list.size());
        assertEquals(3, list.get(2));

        list.remove(2);
        assertArrayEquals(new Object[]{1, 2, 4, 5}, list.toArray());
        assertEquals(4, list.size());
        assertEquals(4, list.get(2));

        list.add(2, 100);
        assertArrayEquals(new Object[]{1, 2, 100, 4, 5}, list.toArray());
        assertEquals(5, list.size());
        assertEquals(100, list.get(2));

        list.add(4, 10);
        assertArrayEquals(new Object[]{1, 2, 100, 4, 10, 5}, list.toArray());
        assertEquals(6, list.size());
        assertEquals(5, list.get(5));

        list.addAll(new CustomArrayList<>(someArray));
        assertArrayEquals(new Object[]{1, 2, 100, 4, 10, 5, 10, 20, 30}, list.toArray());
        assertEquals(9, list.size());
        assertEquals(10, list.get(6));
        assertEquals(30, list.get(8));

        list.addAll(someList);
        assertArrayEquals(new Object[]{1, 2, 100, 4, 10, 5, 10, 20, 30, 10, 20, 30}, list.toArray());
        assertEquals(12, list.size());
        assertEquals(10, list.get(9));
        assertEquals(30, list.get(11));

        list.remove(2);
        assertArrayEquals(new Object[]{1, 2, 4, 10, 5, 10, 20, 30, 10, 20, 30}, list.toArray());
        assertEquals(11, list.size());
        assertEquals(4, list.get(2));

        list.remove(0);
        assertArrayEquals(new Object[]{2, 4, 10, 5, 10, 20, 30, 10, 20, 30}, list.toArray());
        assertEquals(10, list.size());
        assertEquals(10, list.get(2));

        list.remove(9);
        assertArrayEquals(new Object[]{2, 4, 10, 5, 10, 20, 30, 10, 20}, list.toArray());
        assertEquals(9, list.size());
        assertEquals(5, list.get(3));

        assertThrows(IndexOutOfBoundsException.class, () -> {
            CustomList<Integer> exceptionList = new CustomArrayList<>();
            exceptionList.add(1);
            exceptionList.add(2);
            exceptionList.add(3);
            exceptionList.add(4, 42);
        });

        assertThrows(NullPointerException.class, () -> {
            CustomArrayList<Integer> some = null;
            CustomList<Integer> exceptionList = new CustomArrayList<>();
            exceptionList.addAll(some);
        });

    }
}
