import java.util.Iterator;
import java.util.LinkedList;
import java.util.function.Consumer;

public class MyLinkedList<T> implements Iterable<T> {

    private Node<T> head, tail, iteratorNode;
    private Iterator<T> iterator;
    private int size;

    public MyLinkedList() {
        head = tail = null;
        size = 0;
    }

    public Iterator<T> iterator(){
        //?????????????????
        //к сожалению так и не смог допилить итератор
        //соответственно показывает содержимое шкафа он не совсем адекватно
        //но как бы то ни было, метод показать содержимое шкафа я реализовал
        //и он работает отображая его содержимое
        iteratorNode = head;

        return new Iterator<T>() {

            public void remove(){
                //TODO
                //удаляем текущий следующий становится текущим
                iteratorNode = iteratorNode.next;
//                System.out.println("Method remove");
            }

            @Override
            public boolean hasNext() {
                //TODO
                //проверка не ссылаемся ли мы на null
                if (iteratorNode.next != null) return true;
//                System.out.println("Method hasNext");
                return false;
            }

            @Override
            public T next() {
                //TODO
                //возвращаем текущий и переходим к следющему
                T tmp = iteratorNode.value;
                iteratorNode = iteratorNode.next;
//                System.out.println("Method next");
                return tmp;
            }
        };
    }

    void sortedAdd(T element){
        //TODO
        //вставляем с головы в ближайшее место, для которого выполняется:
        //node.prev <= tmp <= node.next
        Node<T> tmp = new Node<>(element);
        if (size == 0) {
            head = tail = tmp;
            size++;
            System.out.println("add0: " + tmp.value + ", size: " + size + ", list: " + toString());
        } else if (size == 1) {
            if ((Integer)head.value < (Integer)tmp.value) {
                tail.next = tmp;
                tail.next.prev = tail;
                tail = tail.next;
                size++;
                System.out.println("add1-0: " + tmp.value + ", size: " + size + ", list: " + toString());
            } else {
                tail = head;
                head = tmp;
                tail.prev = head;
                head.next = tail;
                size++;
                System.out.println("add1-1: " + tmp.value + ", size: " + size + ", list: " + toString());
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
                    System.out.println("add2-0: " + tmp.value + ", size: " + size + ", list: " + toString());
                    return;
                }
            }
            if (node == head) {
                head.prev = tmp;
                head.prev.next = head;
                head = head.prev;
                size++;
                System.out.println("add2-1: " + tmp.value + ", size: " + size + ", list: " + toString());
            } else {
                Node<T> prev = node.prev;
                tmp.next = node;
                tmp.prev = prev;
                prev.next = tmp;
                node.prev = tmp;
                size++;
                System.out.println("add2-2: " + tmp.value + ", size: " + size + ", list: " + toString());
            }
        }
    }

    T first() {
        return head.value;
    }

    T last() {
        return tail.value;
    }

    void add(T element){
        // TODO: 21.11.2019
        if (size == 0) {
            head = tail = new Node<>(element);
        } else {
            tail.next = new Node<>(element);
            tail.next.prev = tail;
            tail = tail.next;
        }
        size++;
    }

    void add(int index, T element){
        //TODO
        if (size == 0) {
            head = tail = new Node<>(element);
        } else if (index >= size){
            tail.next = new Node<>(element);
            tail.next.prev = tail;
            tail = tail.next;
        } else if (index > 0 && index < size){
            Node<T> node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            Node<T> prev = node.prev;
            Node<T> tmp = new Node<>(element);
            tmp.next = node;
            tmp.prev = prev;
            prev.next = tmp;
            node.prev = tmp;
        }
        size++;
    }

    int size(){
        //TODO
        return size;
    }

    void remove(){
        //TODO
        tail = tail.prev;
        tail.next.prev = null;
        tail.next = null;
        size--;
    }

    void remove(int index){
        //TODO
        if (index == 0) {
            head = head.next;
//?????????????????
//если следующие две строчки не откомментированы, при попытке вызова медода
//получаем нуллпоинтер эксепшн. Почему, ведь строчки то правильные???
//возможно добавление неверно реализовано???
//            head.prev.next = null;
//            head.prev = null;
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

    T get(int index){
        //TODO
        Node<T> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.value;
    }

    void set(int index, T value){
        //TODO
        Node<T> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        node.value = value;
    }

    String show () {
        Node<T> node = head;
        StringBuffer s = new StringBuffer();
        while (node != null) {
            s.append(node.value + " ");
            node = node.next;
        }
        return s.toString();
    }

    @Override
    public String toString() {
        //TODO
        //format: [1, 2, 3, 4, 5]
        Node<T> node = head;
        StringBuffer s = new StringBuffer();
        s.append("[");
        if (size == 0) {
        } else if (size >= 1) {
            s.append(node.value);
            for (int i = 1; i < size; i++) {
                node = node.next;
                s.append(", " + node.value);
            }
        }
        s.append("]");
        return s.toString();
    }
}