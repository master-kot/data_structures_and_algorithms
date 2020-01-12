package Stack;

// TODO: 18/11/2019
/**
 * Помытая посуда укладывается в стопки до достижения
 * лимита, если лимит достигнут, нужно завести новую стопку.
 * Достать тарелку можно только с последней стопки.
 * Реализуйте структуру данных для хранения и извлечения тарелок
 * лимит = 2
 * Метод пуш возвращает складывает посуду в стопки вида:
 * а б конец стопки
 * в г конец стопки
 * д
 * Метод поп возвращает содерщиние стопок с посудой в виде:
 * д
 * г в
 * б а
 * */
public class TaskNumberTwo {
    private int limit, size, counter;
    private Stack<Stack<String>> stacks;

    TaskNumberTwo(int limit) {
        this.limit = limit;
        this.counter = 0;
        this.size = 0;
        stacks = new Stack<Stack<String>>();
    }

    public String pop(){
        String item = null;
        if (stacks.size() == 0) return null;
        if (stacks.top().size() == 0) {
            stacks.pop();
            if (stacks.size() == 0) return null;
            item = stacks.top().top();
            stacks.top().pop();
        }
        else {
            item = stacks.top().top();
            stacks.top().pop();
        }
        return item;
    }

    public void show() {
        for (Stack<String> s : stacks) {
            s.show();
        }
    }

    public void push(String item){
        if (stacks.size() == 0) {
            stacks.push(new Stack<String>());
            size++;
        }
        if (stacks.top().size() < limit) {
            stacks.top().push(item);
        } else {
            stacks.push(new Stack<String>());
            size++;
            stacks.top().push(item);
        }
    }

    public static void main(String[] args) {
        TaskNumberTwo tnt = new TaskNumberTwo(3);
        for (int i = 0; i < 7; i++) {
            tnt.push("Crockery " + (i + 1));
        }
        tnt.show();
    }
}