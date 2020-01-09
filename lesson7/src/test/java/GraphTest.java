import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {

    @Test
    void friendCounter() throws FileNotFoundException {
        Scanner in = new Scanner(new File("C:\\Users\\Mikhail\\Downloads\\lesson1\\lesson7\\src\\main\\resources\\data.txt"));
        assertEquals(70, Graph.friendCounter(in));
    }

    @Test
    void salesman() throws FileNotFoundException {
        Scanner in = new Scanner(new File("C:\\Users\\Mikhail\\Downloads\\lesson1\\lesson7\\src\\main\\resources\\salesman.txt"));
        assertEquals(171, Graph.travelingSalesman(in));
    }

    @Test
    void salesmanWay() throws FileNotFoundException {
        Scanner in = new Scanner(new File("C:\\Users\\Mikhail\\Downloads\\lesson1\\lesson7\\src\\main\\resources\\salesman.txt"));
        assertEquals(new int[]{0, 3, 8, 7, 1, 2, 6, 4, 9, 5}, Graph.travelingSalesmanWay(in));
    }

}