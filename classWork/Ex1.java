package classWork;

import java.util.Scanner;

public class Ex1 {


    static int [] cash = new int[100];
    //0 1 1 2 3 5 8 13 21 34 0 0
    //f(9) = 34
    //f(8) = 21
    //f(7) = 13
    //f(6) = f(5) + f(4)
    //f(5) = f(4) + f(3)
    //f(4) = f(3) + f(2)
    //f(3) = f(2) + f(1)
    static int f(int n) {
        if (n <= 1) return 1;
        if (n == 2) return 1;
        if(cash[n] > 0) return cash[n];
        cash[n]  = f(n - 1) + f(n - 2);
        return cash[n];
    }

    static int factor(int n) {
        return n == 1 ? 1 : n * factor(n - 1);
    }

    static void inputReverse(){
        int x = new Scanner(System.in).nextInt();
        if(x == 0) return;
        inputReverse();
        System.out.print(x + " ");
    }

    static int sumCount(int n, int odd){
        if(n == 0) return 1;
        if(odd > n) return 0;
        return sumCount(n - odd, odd) + sumCount(n, odd + 2);
    }

    static int target = 12, start = 0;
    static int [] data = new int[]{1, 4, 9, 16, 25, 36, 49, 64};

    static void sumCount(int n, int odd, int pos, int [] a){
        if(n == 0) {
            System.out.print(target + " = ");
            for (int i = 0; i < pos - 1 ; i++) {
                System.out.print(a[i] + " + ");
            }
            System.out.println(a[pos-1]);
        }
        if(odd > n) return;
        a[pos] = odd;
        sumCount(n - odd, odd, pos + 1, a);
        sumCount(n, odd + 2, pos, a);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(f(i));
            for (int j = 0; j < 100; j++) {
                cash[i] = 0;
            }
        }
    }
}
