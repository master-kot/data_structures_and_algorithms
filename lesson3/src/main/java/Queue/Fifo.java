package Queue;

public interface Fifo extends Iterable<Integer>{
    void push(int element);
    int pop();
    int top();
    boolean isEmpty();
}
