import CustomArrayList.CustomArrayList;

public class Main {
    public static void main(String[] args) {
        CustomArrayList<Integer> list = new CustomArrayList<Integer>();
        for (int i = 0; i < 20; i++) list.add(i);
        list.remove(10);
        list.remove(10);
        list.add(10,100);
        list.add(11,200);
        System.out.println(list + " " + list.size());
    }
}