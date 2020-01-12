package Queue;

public interface Fifo extends Iterable{
    void push(int element);
    int pop();
    int top();
    boolean isEmpty();
}
