import org.Main;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class MainTest {

    @Test
    void testCostOfItem() {
        assertEquals(10, Main.costOfItem(2, 5));
        assertEquals(0, Main.costOfItem(0, 5));
        assertEquals(15, Main.costOfItem(3, 5));
    }

    @Test
    void testTotalCost() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);

        assertEquals(60, Main.totalCost(list));
    }

    @Test
    void testTotalCostEmptyList() {
        ArrayList<Integer> list = new ArrayList<>();
        assertEquals(0, Main.totalCost(list));
    }
}
