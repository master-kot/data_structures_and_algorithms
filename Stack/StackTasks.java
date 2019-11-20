package main.java.Stack;

import java.util.LinkedList;

public class StackTasks {

        /*
        * Правильная скобочная последовательность,
        * это последовательность,
        * которая может быть получена по следующим правилам:
        * Пусть s = "()" - правильная последовательность
        * Тогда s1 = "(" + s + ")" - тоже правильная
        * Если s2, s3 - правильные последовательности,
        * то s2 + s3 - тоже правильная
        * Проще говоря - такая последовательность,
        *  где на каждую открытую скобку есть своя закрытая
        * ()(()) true
        * (())((())) true
        * ( false
        * (() false
        * Stack solution
        * if "(" push
        * else pop
        * if empty stack - true
        * else false
        * */

    public boolean trueBracketSequences(String sequence){
        // TODO: 18/11/2019
        Stack<Character> stack = new Stack<>();
        char[] charArray = sequence.toCharArray();
        try {
            for (int i = 0; i < charArray.length; i++) {
                if (charArray[i] == '(') stack.push(charArray[i]);
                if (charArray[i] == ')') stack.pop();
            }
            if (stack.size() == 0) return true;
        } catch (StackPointerException e) {
            return false;
        }
        return false;
    }

    public static void main(String[] args) {
        StackTasks stackTasks = new StackTasks();
        System.out.println(stackTasks.trueBracketSequences("((()))"));

        CrockeryStack crockeryTest = new CrockeryStack(2);
        for (int i = 0; i < 2; i++) {
            crockeryTest.push("plate");
        }
        for (int i = 0; i < 2; i++) {
            System.out.println(crockeryTest.pop());
        }
    }
}
