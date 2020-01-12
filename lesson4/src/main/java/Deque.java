public class Deque<T extends Comparable<T>> {
    private int size;
    private Node<T> front, back;

    private class Node<T> {
        T value;
        Node<T> prev, next;

        public Node(T value) {
            this.value = value;
            prev = next = null;
        }
    }

    public Deque() {
        size = 0;
        front = back = null;
    }

    T popFront() {
        if (size == 0) return null;
        T value = front.value;
        front = front.next;
        front.prev.next = null;
        front.prev = null;
        size--;
        return value;
    }

    public T popBack() {
        if (size == 0) return null;
        T value = back.value;
        back = back.prev;
        back.next.prev = null;
        back.next = null;
        size--;
        return value;
    }

    public T front() {
        return front.value;
    }

    public T back() {
        return back.value;
    }

    public void pushBack(T value) {
        if (size == 0) {
            front = back = new Node<>(value);
        } else {
            back.next = new Node<>(value);
            back.next.prev = back;
            back = back.next;
        }
        size++;
    }

    public void pushFront(T value) {
        if (size == 0) {
            front = back = new Node<>(value);
        } else {
            front.prev = new Node<>(value);
            front.prev.next = front;
            front = front.prev;
        }
        size++;
    }

    public int size() {
        return size;
    }

    public void show() {
        Node<T> node = front;
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    /**
     * Сортированная вставка, Сложность O(N)
     */
    public void sortedPush(T value) {
        if (size == 0) {
            front = back = new Node<>(value);
        } else if(size == 1) {
            if (value.compareTo(front.value) > 0) pushBack(value);
            else pushFront(value);
            return;
        } else {
            Node<T> node = front;
            while (node.value.compareTo(value) < 0) {
                node = node.next;
                if (node == null) {
                    pushBack(value);
                    return;
                }
            }
            if (node == front) {
                pushFront(value);
                return;
            }
            Node<T> prev = node.prev;
            Node<T> tmp = new Node<>(value);
            tmp.next = node;
            tmp.prev = prev;
            prev.next = tmp;
            node.prev = tmp;
        }
        size++;
    }

    /**
     * Проверка что Deque является полиндромом, сложность O(N)
     */
    public boolean isPalindrome() {
        Node<T> head = front, tail = back;
        while (head != tail) {
            if (head.value != tail.value) {
                return false;
            }
            head = head.next;
            tail = tail.prev;
        }
        return true;
    }
}