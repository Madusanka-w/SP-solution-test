package Problem3;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    public static List<Long> generateFibonacci(int n) {
        List<Long> fibonacciList = new ArrayList<>();
        if (n <= 0) return fibonacciList;

        fibonacciList.add(0L);
        if (n == 1) return fibonacciList;

        fibonacciList.add(1L);
        for (int i = 2; i < n; i++) {
            long nextFib = fibonacciList.get(i - 1) + fibonacciList.get(i - 2);
            fibonacciList.add(nextFib);
        }
        return fibonacciList;
    }

    public static void main(String[] args) {
        List<Long> fibonacci100 = generateFibonacci(100);
        System.out.println(fibonacci100);
    }
}

