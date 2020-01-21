import java.util.Comparator;

public class BST<T extends Comparable<T>> implements Tree<T>{

    private int size;
    private Node<T> root;
    private Comparator<T> comp;

    private class Node<T> {
        T value;
        Node<T> l, r;

        public Node(T value) {
            this.value = value;
            l = r = null;
        }
    }

    public BST() {
        size = 0;
        root = null;
    }

    @Override
    public void add(T element) {
        if (root == null){
            root = new Node<>(element);
        } else {
            add(root, element);
        }
        size++;
    }

    //TODO
    //Добавление элемента, сложность O(logN)
    private void add(Node<T> node, T element){
        if (node.value.compareTo(element) > 0){
            if (node.l == null){
                node.l = new Node<>(element);
            }else {
                add(node.l, element);
            }
        }
        if (node.value.compareTo(element) < 0){
            if (node.r == null){
                node.r = new Node<>(element);
            } else {
                add(node.r, element);
            }
        }
    }

    //TODO
    //Удаление элемента
    @Override
    public void remove(T element) {
        parent = null;
        parentSide = 0;
        Node<T> result = findForDelete(root, element);

        if (result == null) {
            return;
        } else if (result == root) {
            if (result.l == null && result.r == null) {
                root = null;
            } else if (result.l == null) {
                root = result.r;
            } else if (result.r == null) {
                root = result.l;
            } else {
            }
            size--;
        } else {
            if (result.l == null && result.r == null) {
                result = null;
            } else if (result.l == null) {
                if (parentSide == -1) parent.l = result.r;
                if (parentSide == 1) parent.r = result.r;
                result = result.r;
            } else if (result.r == null) {
                if (parentSide == -1) parent.l = result.l;
                if (parentSide == 1) parent.r = result.l;
                result = result.l;
            }
            size--;
        }
    }

    private Node<T> parent;
    private int parentSide;

    private Node<T> findForDelete(Node<T> node, T value) {
        if (node == null) {
            return null;
        }
        if (value.compareTo(node.value) == 0) {
            return node;
        }
        if (value.compareTo(node.value) < 0){
            parent = node;
            parentSide = -1;
            return findForDelete(node.l, value);
        } else {
            parent = node;
            parentSide = 1;
            return findForDelete(node.r, value);
        }
    }

    private boolean find(Node<T> node, T value){
        if (node == null) return false;
        if (value.compareTo(node.value) == 0) return true;
        if (value.compareTo(node.value) < 0) return find(node.l, value);
        else return find(node.r, value);
    }

    //TODO
    //Поиск элемента, сложность O(logN)
    @Override
    public boolean find(T element) {
        return find(root, element);
    }

    static StringBuilder str;

    @Override
    public String preOrder() {
        str = new StringBuilder();
        preOrder(root);
        str.insert(0, '[');
        str.delete(str.length() - 2, str.length());
        str.append(']');
        return str.toString();
    }

    //O(N)
    private void preOrder(Node<T> node) {
        if (node != null) {
            str.append(node.value).append(',').append(' ');
            preOrder(node.l);
            preOrder(node.r);
        }
    }

    public void showPreOrder(){
        preOrder(root);
    }

    @Override
    public String inOrder() {
        str = new StringBuilder();
        inOrder(root);
        str.insert(0, '[');
        str.delete(str.length() - 2, str.length());
        str.append(']');
        return str.toString();
    }

    private void inOrder(Node<T> node) {
        if (node != null) {
            inOrder(node.l);
            str.append(node.value).append(',').append(' ');
            inOrder(node.r);
        }
    }

    public void showTree(){
        inOrder(root);
    }

    @Override
    public String postOrder() {
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}