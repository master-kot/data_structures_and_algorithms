import java.util.Iterator;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Bookcase cupboard = new Bookcase(2,3);
        cupboard.putBook(1, 'R', "Book_1_1");
        cupboard.putBook(1, 'R', "Book_1_2");
        cupboard.putBook(1, 'R', "Book_1_3");
        cupboard.putBook(2, 'R', "Book_2_1");
        cupboard.putBook(2, 'R', "Book_2_2");
        cupboard.putBook(2, 'R', "Book_2_3");
        cupboard.showBookcase();

        System.out.println("Book took: " + cupboard.takeBook(1, 1));
        cupboard.showBookcase();

        System.out.println("Book took: " + cupboard.takeBook(1, 1));
        cupboard.showBookcase();

        System.out.println("Book took: " + cupboard.takeBook(1, 1));
        System.out.println("Book took: " + cupboard.takeBook(2, 1));
        System.out.println("Book took: " + cupboard.takeBook(2, 1));
        System.out.println("Book took: " + cupboard.takeBook(2, 1));
        /*
        for(Iterator<Integer> iterator = list.iterator(); iterator.hasNext();){
            int value = iterator.next();
            System.out.println(value);
        }
        for (Integer i : list){}

        MyLinkedList<Integer> list = new MyLinkedList<>();
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            list.sortedAdd(r.nextInt(100));
        }
        list.set(0, 11);
        System.out.println(list.toString());
        list.remove(0);
        System.out.println(list.toString());
        list.remove(0);
        System.out.println(list.toString());
        */
    }
}