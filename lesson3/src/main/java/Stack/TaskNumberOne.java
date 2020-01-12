package Stack;

public class TaskNumberOne {

    // TODO: 18/11/2019
    /**
     * Правильная скобочная последовательность, это последовательность,
     * полученная по следующим правилам:
     * Пусть s = "()" - правильная последовательность
     * Тогда s1 = "(" + s + ")" - тоже правильная
     * Если s2, s3 - правильные последовательности,
     * то s2 + s3 - тоже правильная
     * Проще говоря - такая последовательность,
     *  где на каждую открытую скобку есть своя закрытая
     * ()(()) -> true; (())((())) -> true
     * ( -> false; (() -> false
     * Разработать метод работающий со стеком  и проверяющий правильная
     * ли скобочная последовательность содержится в введенной строке
     */
    public boolean trueBracketSequences(String sequence){
        Stack<Character> stack = new Stack<Character>();
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
        TaskNumberOne stackTasks = new TaskNumberOne();
        System.out.println(stackTasks.trueBracketSequences("((()))"));

        TaskNumberTwo crockeryTest = new TaskNumberTwo(2);
        for (int i = 0; i < 2; i++) {
            crockeryTest.push("plate");
        }
        for (int i = 0; i < 2; i++) {
            System.out.println(crockeryTest.pop());
        }
    }
}