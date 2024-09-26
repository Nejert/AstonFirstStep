import customArrayList.CustomArrayList;
import utils.CustomList;

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
    }
}