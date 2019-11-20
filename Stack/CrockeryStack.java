package main.java.Stack;

/*
 * Помытая посуда укладывается в стопки до достижения
 * лимита, если лимит достигнут, нужно завести новую стопку.
 * Достать тарелку можно только с последней стопки.
 * Реализуйте структуру данных для хранения и извлечения тарелок
 * лимит = 2
 * пуш:
 * а б конец стопки
 * в г конец стопки
 * д
 * поп:
 * д
 * г в
 * б а
 * */

public class CrockeryStack {
    private int limit;
    private Stack<Stack> stacks;
    private int counter;

    CrockeryStack(int limit) {
        this.limit = limit;
        this.counter = 0;
        stacks = null;
    }
    // TODO: 18/11/2019

    public String pop(){
        // TODO: 18/11/2019
        Stack<String> tmp = stacks.pop();
        String value = tmp.pop();
        stacks.push(tmp);
        counter--;
        return value;
    }

    public void push(String item){
        // TODO: 18/11/2019
        if (counter == 0) {
            Stack<String> newStack = new Stack<>();
            newStack.push(item);
            stacks.push(newStack);
            counter++;
        }
        if (counter != 0 && counter <= limit){
            Stack<String> tmp = stacks.pop();
            tmp.push(item);
            stacks.push(tmp);
            counter++;
        }
        if (counter > limit) {
            Stack<String> newStack = new Stack<>();
            newStack.push(item);
            stacks.push(newStack);
            counter = counter - limit + 1;
        }
    }
}