import customArrayList.CustomArrayList;
import customLinkedList.CustomLinkedList;
import org.junit.jupiter.api.Test;
import utils.CustomCollections;
import utils.CustomList;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class CollectionsTest {

    final Integer[] integers = new Integer[]{3, 1, 2, 5, 4};
    final String[] strings = new String[]{"C", "A", "B", "E", "D"};

    @Test
    public void testCustomListConstruction() {
        //array list
        CustomList<Integer> ilist = new CustomArrayList<>();
        assertArrayEquals(new Object[0], ilist.toArray());

        ilist = new CustomArrayList<>(integers);
        assertArrayEquals(new Object[]{3, 1, 2, 5, 4}, ilist.toArray());

        assertThrows(IllegalArgumentException.class, () -> {
            CustomList<Integer> exlist = new CustomArrayList<>(-1);
            exlist.clear();
        });

        ilist = new CustomArrayList<>(Arrays.asList(3, 1, 2, 5, 4));
        assertArrayEquals(new Object[]{3, 1, 2, 5, 4}, ilist.toArray());

        ilist = new CustomArrayList<>(new CustomArrayList<>(Arrays.asList(3, 1, 2, 5, 4)));
        assertArrayEquals(new Object[]{3, 1, 2, 5, 4}, ilist.toArray());

        CustomList<String> slist = new CustomArrayList<>();
        assertArrayEquals(new Object[0], slist.toArray());

        slist = new CustomArrayList<>(strings);
        assertArrayEquals(new Object[]{"C", "A", "B", "E", "D"}, slist.toArray());

        slist = new CustomArrayList<>(Arrays.asList("C", "A", "B", "E", "D"));
        assertArrayEquals(new Object[]{"C", "A", "B", "E", "D"}, slist.toArray());

        slist = new CustomArrayList<>(new CustomArrayList<>(Arrays.asList("C", "A", "B", "E", "D")));
        assertArrayEquals(new Object[]{"C", "A", "B", "E", "D"}, slist.toArray());

        //linked list
        CustomList<Integer> illist = new CustomLinkedList<>();
        assertArrayEquals(new Object[0], illist.toArray());

        illist = new CustomLinkedList<>(integers);
        assertArrayEquals(new Object[]{3, 1, 2, 5, 4}, illist.toArray());

        illist = new CustomLinkedList<>(Arrays.asList(3, 1, 2, 5, 4));
        assertArrayEquals(new Object[]{3, 1, 2, 5, 4}, illist.toArray());

        illist = new CustomLinkedList<>(new CustomLinkedList<>(Arrays.asList(3, 1, 2, 5, 4)));
        assertArrayEquals(new Object[]{3, 1, 2, 5, 4}, illist.toArray());

        CustomList<String> sllist = new CustomLinkedList<>();
        assertArrayEquals(new Object[0], sllist.toArray());

        sllist = new CustomLinkedList<>(strings);
        assertArrayEquals(new Object[]{"C", "A", "B", "E", "D"}, sllist.toArray());

        sllist = new CustomLinkedList<>(Arrays.asList("C", "A", "B", "E", "D"));
        assertArrayEquals(new Object[]{"C", "A", "B", "E", "D"}, sllist.toArray());

        sllist = new CustomLinkedList<>(new CustomLinkedList<>(Arrays.asList("C", "A", "B", "E", "D")));
        assertArrayEquals(new Object[]{"C", "A", "B", "E", "D"}, sllist.toArray());
    }

    @Test
    public void testCustomListAddition() {
        //array list
        CustomList<Integer> ilist = new CustomArrayList<>();
        ilist.add(3);
        ilist.add(1);
        ilist.add(2);
        ilist.add(5);
        ilist.add(8);
        assertArrayEquals(new Object[]{3, 1, 2, 5, 8}, ilist.toArray());

        ilist.add(4, 4);
        assertArrayEquals(new Object[]{3, 1, 2, 5, 4, 8}, ilist.toArray());

        ilist.addAll(new CustomArrayList<>(Arrays.asList(10, 12)));
        assertArrayEquals(new Object[]{3, 1, 2, 5, 4, 8, 10, 12}, ilist.toArray());

        ilist.addAll(Arrays.asList(11, 13));
        assertArrayEquals(new Object[]{3, 1, 2, 5, 4, 8, 10, 12, 11, 13}, ilist.toArray());

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

        //linked list
        CustomList<Integer> illist = new CustomLinkedList<>();
        illist.add(3);
        illist.add(1);
        illist.add(2);
        illist.add(5);
        illist.add(8);
        assertArrayEquals(new Object[]{3, 1, 2, 5, 8}, illist.toArray());

        illist.add(4, 4);
        assertArrayEquals(new Object[]{3, 1, 2, 5, 4, 8}, illist.toArray());

        illist.addAll(new CustomLinkedList<>(Arrays.asList(10, 12)));
        assertArrayEquals(new Object[]{3, 1, 2, 5, 4, 8, 10, 12}, illist.toArray());

        illist.addAll(Arrays.asList(11, 13));
        assertArrayEquals(new Object[]{3, 1, 2, 5, 4, 8, 10, 12, 11, 13}, illist.toArray());

        assertThrows(IndexOutOfBoundsException.class, () -> {
            CustomList<Integer> exceptionList = new CustomLinkedList<>();
            exceptionList.add(1);
            exceptionList.add(2);
            exceptionList.add(3);
            exceptionList.add(4, 42);
        });

        assertThrows(NullPointerException.class, () -> {
            CustomLinkedList<Integer> some = null;
            CustomList<Integer> exceptionList = new CustomLinkedList<>();
            exceptionList.addAll(some);
        });
    }

    @Test
    public void testCustomListReceiving() {
        //array list
        CustomList<String> slist = new CustomArrayList<>(strings);
        assertArrayEquals(new String[]{"C", "A", "B", "E", "D"}, slist.toArray());
        assertEquals("B", slist.get(2));
        assertEquals(5, slist.size());
        //linked list
        CustomList<String> sllist = new CustomLinkedList<>(strings);
        assertArrayEquals(new String[]{"C", "A", "B", "E", "D"}, sllist.toArray());
        assertEquals("B", sllist.get(2));
        assertEquals(5, sllist.size());
    }

    @Test
    public void testCustomListModification() {
        //array list
        CustomList<Integer> ilist = new CustomArrayList<>(new Integer[]{3, 1, 2, 5, 8});
        ilist.set(4, 4);
        assertArrayEquals(new Object[]{3, 1, 2, 5, 4}, ilist.toArray());
        ilist.remove(2);
        assertArrayEquals(new Object[]{3, 1, 5, 4}, ilist.toArray());
        ilist.clear();
        assertArrayEquals(new Object[0], ilist.toArray());
        //linked list
        CustomList<Integer> illist = new CustomLinkedList<>(new Integer[]{3, 1, 2, 5, 8});
        illist.set(4, 4);
        assertArrayEquals(new Object[]{3, 1, 2, 5, 4}, illist.toArray());
        illist.remove(2);
        assertArrayEquals(new Object[]{3, 1, 5, 4}, illist.toArray());
        illist.clear();
        assertArrayEquals(new Object[0], illist.toArray());
    }

    @Test
    public void testCustomListSorting() {
        //array list
        CustomList<Integer> ilist = new CustomArrayList<>(integers);
        ilist.sort();
        assertArrayEquals(new Object[]{1, 2, 3, 4, 5}, ilist.toArray());
        ilist = new CustomArrayList<>(integers);
        CustomCollections.sort(ilist, (a, b) -> b.compareTo(a)); //Comparator.reverseOrder();
        assertArrayEquals(new Object[]{5, 4, 3, 2, 1}, ilist.toArray());
        //linked list
        CustomList<Integer> illist = new CustomLinkedList<>(integers);
        illist.sort();
        assertArrayEquals(new Object[]{1, 2, 3, 4, 5}, illist.toArray());
        illist = new CustomLinkedList<>(integers);
        CustomCollections.sort(illist, (a, b) -> b.compareTo(a)); //Comparator.reverseOrder();
        assertArrayEquals(new Object[]{5, 4, 3, 2, 1}, illist.toArray());
    }
}
