public interface Tree<T> {
    void add(T element);
    void remove(T element);
    boolean find(T element);
    String preOrder();
    String inOrder();
    String postOrder();
    int size();
}
