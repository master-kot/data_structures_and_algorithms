import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Home work 1")
class Tests {

    @Test
    void testSum(){
        ArrayUtility utility = new ArrayUtility(new int[]{1, 2, 3, 4, 5});
        assertEquals(15, utility.arraySum());
    }

    @Test
    void testAVG(){
        ArrayUtility utility = new ArrayUtility(new int[]{1, 2, 3, 4, 5});
        assertEquals(3., utility.avg());
        ArrayUtility utility1 = new ArrayUtility(new int[]{1, 2, 3, 4, 5, 7});
        assertEquals(22/6., utility1.avg(), 0.001);
    }

    @Test
    void testMedian(){
        ArrayUtility utility = new ArrayUtility(new int[]{1, 2, 3, 4, 5});
        assertEquals(3., utility.median());
        ArrayUtility utility1 = new ArrayUtility(new int[]{1, 2, 3, 4, 5, 7});
        assertEquals(3.5, utility1.median(), 0.001);
    }
}
