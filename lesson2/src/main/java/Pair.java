public class Pair<T> {
    private final T element;
    private Integer counter;

    public Pair(T element, Integer counter) {
        this.element = element;
        this.counter = counter;
    }

    public T getElement() {
        return element;
    }

    public Integer getCounter() {
        return counter;
    }

    public void increaseCounter() {
        counter++;
    }
}