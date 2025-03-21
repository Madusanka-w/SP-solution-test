import java.util.List;

public class recursion {
    public static int sumOfNumbers(List<Integer> numbers, int index) {
       
        if (index >= numbers.size()) {
            return 0;
        }
        
        return numbers.get(index) + sumOfNumbers(numbers, index + 1);
    }
}
