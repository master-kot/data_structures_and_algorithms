import java.util.Iterator;
import java.util.LinkedList;
import java.util.function.Consumer;

public class MyLinkedList<T> implements Iterable<T> {

    private Node<T> head, tail, iteratorNode;
    private int size;

    private class Node<T> {
        T value;
        Node<T> prev, next;

        public Node(T value) {
            this.value = value;
            prev = next = null;
        }
    }

    public MyLinkedList() {
        head = tail = null;
        size = 0;
    }

    T first() {
        return head.value;
    }

    T last() {
        return tail.value;
    }

    // TODO: 21.11.2019
    public void add(T element) {
        if (size == 0) {
            head = tail = new Node<>(element);
        } else {
            tail.next = new Node<>(element);
            tail.next.prev = tail;
            tail = tail.next;
        }
        size++;
    }

    //TODO
    public void add(int index, T element){
        if (index == 0){
            if (size == 0) {
                head = tail = new Node<>(element);
            } else {
            head.prev = new Node<>(element);
            head.prev.next = head;
            head = head.prev;
            }
            size++;
        } else if (index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            Node<T> node = head;
            int cnt = 0;
            while (cnt < index){
                node = node.next;
                cnt++;
            }
            Node<T> tmp = new Node<>(element);
            Node<T> last = node.prev;
            last.next = tmp;
            node.prev = tmp;
            tmp.next = node;
            tmp.prev = last;
            size++;
        }
    }

    //TODO
    public int size(){
        return size;
    }

    //TODO
    public void remove(){
        if (size == 0) throw new ArrayIndexOutOfBoundsException();
        if (size == 1) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next.prev = null;
            tail.next = null;
        }
        size--;
    }

    //TODO
    public void remove (int index){
        if (index >= size) throw new ArrayIndexOutOfBoundsException();
        if (index == 0) {
            if (size == 1) {
                head = tail = null;
            } else {
                head = head.next;
                head.prev.next = null;
                head.prev = null;
            }
        } else {
            Node<T> node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            node.next.prev = node.prev;
            node.prev.next = node.next;
        }
        size--;
    }

    //TODO
    public T get(int index){
        if (index >= size) throw new ArrayIndexOutOfBoundsException();
        Node<T> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.value;
    }

    //TODO
    public void set(int index, T value){
        if (index >= size) throw new ArrayIndexOutOfBoundsException();
        Node<T> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        node.value = value;
    }

    public String show () {
        Node<T> node = head;
        StringBuffer s = new StringBuffer();
        while (node != null) {
            s.append(node.value + " ");
            node = node.next;
        }
        return s.toString();
    }

    //TODO
    /**
     * Формат вывода в виде строки: [1, 2, 3, 4, 5]
     */
    @Override
    public String toString() {
        Node<T> tmp = head;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (tmp != null) {
            sb.append(tmp.value);
            while (tmp.next != null) {
                tmp = tmp.next;
                sb.append(", ").append(tmp.value);
            }
        }
        sb.append("]");
        return sb.toString();
    }

    //TODO
    /**
     * Сортированная вставка, вставляем с головы в ближайшее место,
     * для которого выполняется: node.prev <= tmp <= node.next
     */
    public void sortedAdd(T element){
        Node<T> tmp = new Node<>(element);
        if (size == 0) {
            head = tail = tmp;
        } else if (size == 1) {
            if ((Integer)head.value < (Integer)tmp.value) {
                tail.next = tmp;
                tail.next.prev = tail;
                tail = tail.next;
            } else {
                tail = head;
                head = tmp;
                tail.prev = head;
                head.next = tail;
            }
        } else {
            Node<T> node = head;
            while ((Integer)node.value < (Integer)tmp.value) {
                node = node.next;
                if (node == null) {
                    tail.next = tmp;
                    tail.next.prev = tail;
                    tail = tail.next;
                    size++;
                    return;
                }
            }
            if (node == head) {
                head.prev = tmp;
                head.prev.next = head;
                head = head.prev;
            } else {
                Node<T> prev = node.prev;
                tmp.next = node;
                tmp.prev = prev;
                prev.next = tmp;
                node.prev = tmp;
            }
        }
        size++;
    }

    private Iterator<T> iterator;

    public Iterator<T> iterator(){
        iteratorNode = head;

        return new Iterator<T>() {
            //TODO
            //проверка не ссылаемся ли мы на null
            @Override
            public boolean hasNext() {
                return iteratorNode != null;
            }

            //TODO
            //возвращаем текущий и переходим к следющему
            @Override
            public T next() {
                T tmp = iteratorNode.value;
                iteratorNode = iteratorNode.next;
                return tmp;
            }

            //TODO
            //удаляем текущий, следующий становится текущим
            public void remove() {
                iteratorNode = iteratorNode.prev;
                Node<T> prev = iteratorNode.prev, next = iteratorNode.next;
                if (prev == next && prev == null) {
                    head = tail = null;
                } else if(prev == null){
                    head = head.next;
                    head.prev.next = null;
                    head.prev = null;
                } else if(next == null) {
                    tail = tail.prev;
                    tail.next.prev = null;
                    tail.next = null;
                } else {
                    prev.next.prev = null;
                    prev.next = null;
                    next.prev.next = null;
                    next.prev = null;
                    next.prev = prev;
                    prev.next = next;
                }
                iteratorNode = next;
                size--;
            }
        };
    }
}