import customArrayList.CustomArrayList;
import customLinkedList.CustomLinkedList;
import utils.CustomList;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        CustomList<String> list = new CustomArrayList<>();
        list.add("A");
        list.add("G");
        list.add("B");
        list.add("Z");
        list.add("S");
        list.sort();
        System.out.println(list);

        CustomList<Integer> list2 = new CustomLinkedList<>();
        list2.add(3);
        list2.add(2);
        list2.add(1);
        CustomList<Integer> list3 = new CustomArrayList<>(Arrays.asList(6, 4, 5));
        list2.addAll(list3);
        list2.sort();
        System.out.println(list2);
    }
}