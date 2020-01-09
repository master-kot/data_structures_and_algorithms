import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BSTTest {

    @Test
    void remove(){
        BST<Integer> tree = new BST<>();
        for (int i = 0; i < 10; i++) {
            tree.add(i+1);
        }
        tree.remove(5);
        tree.remove(7);
        assertEquals(false, tree.find(5));
        assertEquals(false, tree.find(7));
        assertEquals(true, tree.find(1));
        assertEquals(true, tree.find(2));
    }

    @Test
    void find() {
        BST<Integer> tree = new BST<>();
        for (int i = 0; i < 10; i++) {
            tree.add(i+1);
        }
        for (int i = 0; i < 10; i++) {
            assertEquals(true, tree.find(i+1));
        }
        for (int i = 10; i < 100; i++) {
            assertEquals(false, tree.find(i+1));
        }
    }

    @Test
    void preOrder() {
        BST<Integer> tree = new BST<>();
        tree.add(7);
        tree.add(5);
        tree.add(4);
        tree.add(6);
        tree.add(9);
        tree.add(8);
        tree.add(10);
        assertEquals("[7, 5, 4, 6, 9, 8, 10]", tree.preOrder());
    }

    @Test
    void inOrder() {
        BST<Integer> tree = new BST<>();
        tree.add(7);
        tree.add(5);
        tree.add(4);
        tree.add(6);
        tree.add(9);
        tree.add(8);
        tree.add(10);
        assertEquals("[4, 5, 6, 7, 8, 9, 10]", tree.inOrder());
    }

    @Test
    void postOrder() {
        BST<Integer> tree = new BST<>();
        tree.add(7);
        tree.add(5);
        tree.add(4);
        tree.add(6);
        tree.add(9);
        tree.add(8);
        tree.add(10);
        assertEquals("[4, 6, 5, 8, 10, 9, 7]", tree.postOrder());
    }
}