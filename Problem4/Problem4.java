package Problem4;

import java.util.*;

public class Problem4 {
    public static String largestNumber(int[] nums) {
        String[] strNums = Arrays.stream(nums)
                                 .mapToObj(String::valueOf)
                                 .toArray(String[]::new);
        
        Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));
        
        if (strNums[0].equals("0")) return "0"; 
        
        return String.join("", strNums);
    }

    public static void main(String[] args) {
        int[] nums = {50, 2, 1, 9};
        System.out.println(largestNumber(nums)); 
    }
}

