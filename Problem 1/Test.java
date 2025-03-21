import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        List<Integer> numberList = new ArrayList<>(Arrays.asList(22,34,54,56,78));

        System.out.println("Sum of numbers using for loop : " + forLoop.sumOfNUmber(numberList));
        System.out.println("Sum of number using while loop : " + whileLopp.sumOfNUmber(numberList));
        System.out.println("Sum of numbers using recursion: " + recursion.sumOfNumbers(numberList, 0));
        
    }
}