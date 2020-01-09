import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class MyHashSetTest {

    private Duration timeout = Duration.ofSeconds(1);

    @Test
    void add() {
        MyHashSet<Integer> hs = new MyHashSet<>();
        assertTimeoutPreemptively(timeout, ()-> {
            for (int i = 0; i < 100000; i++) {
                hs.add(i + 1);
            }
            for (int i = 0; i < 100000; i++) {
                assertTrue(hs.contains(i + 1));
            }
            for (int i = 1000000; i < 2000000; i++) {
                assertFalse(hs.contains(i + 1));
            }
        });
        for (int i = 100; i < 500; i++) {
            hs.remove(i+1);
        }
        for (int i = 100; i < 500; i++) {
            assertFalse(hs.contains(i + 1));
        }
    }
}