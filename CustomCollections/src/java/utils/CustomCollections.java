package utils;

public class CustomCollections {
    public static <T> T[] copy(T[] original, int newLength) {
        T[] res = (T[]) new Object[newLength];
        int size = Math.min(original.length, newLength);
        for (int i = 0; i < size; i++) {
            res[i] = original[i];
        }
        return res;
    }

    public static <T> void swap(T[] original, int i, int j) {
        T temp = original[i];
        original[i] = original[j];
        original[j] = temp;
    }
}
