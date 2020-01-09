import org.junit.jupiter.api.Test;
import java.time.Duration;
import java.util.Iterator;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

public class Tests {

    private Duration timeout = Duration.ofSeconds(2);

    @Test
    void addTest(){
        MyLinkedList<Integer> list = new MyLinkedList<>();
        for (int i = 0; i < 5; i++) {
            list.add(0, i+1);
        }
        for (int i = 0; i < 5; i++) {
            list.add(i+1);
        }
        list.set(0, 7);
        list.set(list.size()-1, 9);
        assertEquals("[7, 4, 3, 2, 1, 1, 2, 3, 4, 9]", list.toString());
    }

    @Test
    void removeTest(){
        MyLinkedList<Integer> list = new MyLinkedList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i+1);
        }
        list.remove();
        list.remove(0);
        assertEquals(2, list.get(0));
        assertEquals(4, list.get(list.size()-1));
    }

    @Test
    void iteratorTest(){
        MyLinkedList<Integer> list = new MyLinkedList<>();
        for (int i = 0; i < 5; i++) {
            list.add(0, i+1);
        }
        Iterator<Integer> iter = list.iterator();
        StringBuilder sb = new StringBuilder();
        while (iter.hasNext()){
            int value = iter.next();
            sb.append(value).append(' ');
        }
        sb.deleteCharAt(sb.length()-1);
        assertEquals("5 4 3 2 1", sb.toString());
        iter = list.iterator();
        iter.next();
        iter.next();
        iter.remove();
        iter.remove();
        assertEquals("[5, 2, 1]", list.toString());
    }

    @Test
    void sortedTest(){
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.sortedAdd(2); list.sortedAdd(1);
        list.sortedAdd(5); list.sortedAdd(3);
        list.sortedAdd(4);
        assertEquals("[1, 2, 3, 4, 5]", list.toString());
    }

    @Test
    void toStringTest(){
        MyLinkedList<Integer> list = new MyLinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i+1);
        }
        assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]", list.toString());
    }

    @Test
    void timeTest(){
        Random rnd = new Random();
        MyLinkedList<Integer> list = new MyLinkedList<>();
        for (int i = 0; i < 1000000; i++) {
            list.add(rnd.nextInt());
        }
        Iterator<Integer> iterator = list.iterator();
        assertTimeoutPreemptively(timeout, ()->{
            while (iterator.hasNext()){
                iterator.next();
            }
        });
        assertTimeoutPreemptively(timeout, ()->{
            int cnt = 0;
            for(Integer it : list){
                cnt++;
//                if(cnt < 15) System.out.println(cnt);
            }
            assertEquals(1000000, list.size());
        });
    }

}
