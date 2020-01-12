import java.util.Iterator;
import java.util.Random;

public class TestBookCase {
    public static void main(String[] args) {

        Bookcase cupboard = new Bookcase(2,3);
        cupboard.putBook(1, 'R', "Book_1_2");
        cupboard.putBook(1, 'L', "Book_1_1");
        cupboard.putBook(1, 'R', "Book_1_3");
        cupboard.putBook(2, 'R', "Book_2_2");
        cupboard.putBook(2, 'L', "Book_2_1");
        cupboard.putBook(2, 'R', "Book_2_3");
        cupboard.showBookcase();

        System.out.println("Book took: " + cupboard.takeBook(1, 1));
        cupboard.showBookcase();

        System.out.println("Book took: " + cupboard.takeBook(2, 1));
        cupboard.showBookcase();

        System.out.println("Book took: " + cupboard.takeBook(2, 1));
        cupboard.showBookcase();

        System.out.println("Book took: " + cupboard.takeBook(2, 1));
        cupboard.showBookcase();

        /*
        MyLinkedList<Integer> list = new MyLinkedList<>();
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            list.sortedAdd(r.nextInt(100));
        }
        for (Integer i : list) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println(list.get(0) + " " + list.get(9));
        list.set(0, 11);
        System.out.println(list.toString());
        list.remove(0);
        System.out.println(list.toString());
        list.remove();
        System.out.println(list.toString());
         */
    }
}