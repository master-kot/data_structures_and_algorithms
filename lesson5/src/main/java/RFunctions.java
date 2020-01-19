import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RFunctions {
	
    //TODO
    //функция должна находить число Фибоначчи от N
    BigInteger[] cash = new BigInteger[1001];

    public BigInteger fib(int n){
        if (n == 1 || n == 2) return BigInteger.ONE;
        if (cash[n] != null) return cash[n];
        cash[n] = fib(n-1).add(fib(n-2));
        return cash[n];
    }

	//TODO
    //функция должна считать факториал числа по формуле factor(n) = n*factor(n-1)
    public BigInteger factor(int n){
        return n == 0 ? BigInteger.ONE :
         factor(n-1).multiply(BigInteger.valueOf(n));
    }

	//TODO
    //функция должна вводить числа из in до тех пор пока не будет введен 0
    //и вывести в out все числа в обратном порядке без 0
    public void reverse(Scanner in, PrintWriter out){
		if (in.hasNext()) {
		    int x = in.nextInt();
            if (x == 0) return;
		    reverse(in, out);
            out.println(x);
        }
    }

    //TODO
    //функция должна отсортировать массив слиянием
    public List<Integer> mergeSort(List<Integer> list){
        if (list.size() <= 1) return list;
        Pair<List<Integer>, List<Integer>> p = split(list);
        return merge(mergeSort(p.getLeft()), mergeSort(p.getRight()));
    }

    //TODO
    //функция должна разбить список пополам на 2 списка, то есть в виде списков длиной:
    //2 и 2 элемента для списка из 4 элементов или длиной 3 и 2 элемента для списка из 5 элементов)
    public Pair<List<Integer>, List<Integer>> split(List<Integer> list) {
        int len = list.size() / 2 + list.size() % 2;
        ArrayList<Integer> a = new ArrayList<>(len + 1),
                b = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            a.add(list.get(i));
        }
        for (int i = len; i < list.size(); i++) {
            b.add(list.get(i));
        }
        return new Pair<>(a, b);
    }

    //TODO
    //функция должна вернуть отсортированный список, сливаемый из двух отсортированных
    public List<Integer> merge(List<Integer> a, List<Integer> b){
        int i = 0, j = 0;
        if (a.isEmpty()) return b;
        if (b.isEmpty()) return a;
        ArrayList<Integer> m = new ArrayList<>(a.size() + b.size());
        while (true){
            if (a.get(i) < b.get(j)){
                m.add(a.get(i));
                i++;
                if (i == a.size() && j < b.size()){
                    while (j < b.size()){
                        m.add(b.get(j));
                        j++;
                    }
                    break;
                }
            } else {
                m.add(b.get(j));
                j++;
                if (j == b.size() && i < a.size()){
                    while (i < a.size()){
                        m.add(a.get(i));
                        i++;
                    }
                    break;
                }
            }
        }
        return m;
    }

    //TODO
    //функция должна вернуть К-ую перестановку n-элементного множества
    //уникальных целых чисел дата
    static boolean[] used;
    static int cnt = 0;
    public int[] permutation(int[] data, int n, int k, int index, PrintWriter out) {
        //used = new boolean[n];
        if(index == n){
            cnt++;
            if(cnt == k){
                out.println(Arrays.toString(data));
                return data;
            }
        }
        for (int i = 0; i < n; i++) {
            if(used[i]) continue;
            data[index] = i;
            used[i] = true;
            permutation(data, n, k, index+1, out);
            used[i] = false;
        }
        return data;
    }

    //TODO
    //функция должна вернуть максимальную массу из предметов в дата, но не превышающую лимит
    public long knackPack(int [] data, long limit){
        return knackPack(data, limit, 0, 0);
    }

    private long knackPack(int [] data, long W, long sum, int index){
        if(W < 0) return Long.MIN_VALUE;
        if(index == data.length) return sum;
        return Math.max(knackPack(data, W - data[index], sum + data[index], index + 1),
                knackPack(data, W, sum, index + 1));
    }
}