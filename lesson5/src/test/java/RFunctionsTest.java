import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.time.Duration;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class RFunctionsTest {


    private Duration timeout = Duration.ofSeconds(1);
    RFunctions foo;

    @Test
    void fib() {
        foo = new RFunctions();
        assertEquals(new BigInteger("8"), foo.fib(6));
        assertEquals(new BigInteger("832040"), foo.fib(30));
        assertEquals(new BigInteger("12586269025"), foo.fib(50));
        assertEquals(new BigInteger("190392490709135"), foo.fib(70));
        assertEquals(new BigInteger("354224848179261915075"), foo.fib(100));
        assertEquals(new BigInteger("43466557686937456435688527675040625802564660517371780402481729089536555417949051890403879840079255169295922593080322634775209689623239873322471161642996440906533187938298969649928516003704476137795166849228875"), foo.fib(1000));
    }

    @Test
    void factor() {
        foo = new RFunctions();
        assertEquals(new BigInteger("6"), foo.factor(3));
        assertEquals(new BigInteger("24"), foo.factor(4));
        assertEquals(new BigInteger("120"), foo.factor(5));
    }

    @Test
    void reverse() {
        foo = new RFunctions();
        try {
            Scanner in = new Scanner(new File(
                    "C:\\Users\\Mikhail\\IdeaProjects\\AS_geek_brains\\lesson5\\src\\main\\resources\\reversedata.txt"));
            PrintWriter writer = new PrintWriter(new File("reversedata.ans"));
            foo.reverse(in, writer);
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        File file = new File(
                "reversedata.ans");
        try {
            Scanner in = new Scanner(file);
            ArrayList<Integer> list = new ArrayList<>();
            while (in.hasNext()){
                list.add(in.nextInt());
            }
            assertEquals("[9, 8, 7, 6, 5, 4, 3, 2, 1]", list.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    void mergeSort() {
        foo = new RFunctions();
        Random rnd = new Random();
        List<Integer> list  = new ArrayList<>(), list1 = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            int value = rnd.nextInt(100000);
            list1.add(value);
            list.add(value);
        }
        list = foo.mergeSort(list);
        list1.sort(Comparator.comparingInt(o->o));
        assertEquals(list1, list);
    }

    @Test
    void split() {
        foo = new RFunctions();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i+1);
        }
        List<Integer> left = foo.split(list).getKey();
        List<Integer> right = foo.split(list).getValue();
        assertEquals("[1, 2, 3]", left.toString());
        assertEquals("[4, 5]", right.toString());
        list.add(6);
        left = foo.split(list).getKey();
        right = foo.split(list).getValue();
        assertEquals("[1, 2, 3]", left.toString());
        assertEquals("[4, 5, 6]", right.toString());
    }

    @Test
    void merge() {
        foo = new RFunctions();
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            left.add(i+1);
        }
        for (int i = 0; i < 9; i++) {
            right.add(i+3);
        }
        List<Integer> list = foo.merge(left, right);
        assertEquals("[1, 2, 3, 3, 4, 4, 5, 5, 6, 7, 8, 9, 10, 11]", list.toString());
    }

    @Test
    void permutation() {
        foo = new RFunctions();
        try {
            PrintWriter writer = new PrintWriter(new File("permut.txt"));
            foo.permutation(new int[]{1, 2, 3, 4, 5}, 5, 7, 0, writer);
            writer.close();
            Scanner in = new Scanner(new File("permut.txt"));
            ArrayList<Integer> list = new ArrayList<>();
            while (in.hasNext()){
                list.add(in.nextInt());
            }
            assertEquals("[1, 3, 2, 4, 5]", list.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    void knackPack() {
        foo = new RFunctions();
        assertEquals(11, foo.knackPack(new int[]{5, 7, 3, 1, 5}, 11));
    }

}