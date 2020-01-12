import org.junit.jupiter.api.Test;
import java.time.Duration;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

import Stack.Stack;
import Queue.ArrayQueue;

public class Tests {

    private Duration timeout = Duration.ofSeconds(1);

    @Test
    void timePushTest(){
        Random rnd = new Random();
        assertTimeoutPreemptively(timeout, ()->{
            Stack<Integer> stack = new Stack<Integer>();
            for (int i = 0; i < 1000000; i++) {
                stack.push(rnd.nextInt());
            }
        });
    }

    @Test
    void stackTest(){
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<String> s2 = new Stack<String>();
        for (int i = 0; i < 5; i++) {
            s1.push(i+1);
        }
        for (int i = 0; i < 5; i++) {
            s2.push("item" + (i+1));
        }
        assertEquals("5 4 3 2 1", s1.toString());
        assertEquals("item5 item4 item3 item2 item1", s2.toString());
        assertEquals(5, s1.pop());
        assertEquals(4, s1.size());
    }

/*    @Test
    void queueTest(){
        ArrayQueue<Integer> s1 = new ArrayQueue<>();
        ArrayQueue<String> s2 = new ArrayQueue<>();
        for (int i = 0; i < 5; i++) {
            s1.push(i+1);
        }
        for (int i = 0; i < 5; i++) {
            s2.push("item" + (i+1));
        }
        assertEquals("1 2 3 4 5", s1.toString());
        assertEquals("item1 item2 item3 item4 item5", s2.toString());
        assertEquals(1, s1.pop());
        assertEquals(4, s1.size());
    }*/
}