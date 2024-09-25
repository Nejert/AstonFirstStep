import CustomArrayList.CustomArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CollectionsTest {
    @Test
    public void test() {
        CustomArrayList<Integer> list =  new CustomArrayList<Integer>();
        list.add(1);

        Assertions.assertEquals(1, list.size());
    }
}
