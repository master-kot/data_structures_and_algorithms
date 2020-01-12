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
            for (int i = 0; i < charArray.length; i++) {
                if (charArray[i] == '(') stack.push('(');
                else if (charArray[i] == ')') {
                    if (stack.size() == 0) return false;
                    else stack.pop();
                }
            }
        return stack.size() == 0;
    }

    public static void main(String[] args) {
        TaskNumberOne stackTasks = new TaskNumberOne();
        System.out.println(stackTasks.trueBracketSequences("((()))"));
        System.out.println(stackTasks.trueBracketSequences("(((fff))"));
    }
}