import java.util.List;

public class forLoop {
    public static int sumOfNUmber(List<Integer> numbers) {
        int sum = 0;
        for(int i=0; i<numbers.size(); i++){
            sum = sum + numbers.get(i);
        }
        return sum;
    }
}