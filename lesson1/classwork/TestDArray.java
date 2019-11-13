package datas.lesson1.classwork;

public class TestDArray {
    public static void main(String[] args) {
        DArray<String> arr = new DArray<>();
        for (int i = 0; i < 10; i++) {
            arr.add("" + i);
        }
        System.out.println(arr.toString());
        arr.set(5, "11");
        System.out.println(arr.toString());
        arr.add(6, "12");
        System.out.println(arr.toString());
        arr.remove(5);
        System.out.println(arr.toString());
    }
}