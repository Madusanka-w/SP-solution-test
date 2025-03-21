import java.util.List;

public class whileLopp {
    public static int sumOfNUmber(List<Integer> numbers){

        int sum = 0;
        int i = 0;

        while(i<numbers.size()) {
            sum += numbers.get(i);
            i++;
        }
        
        return sum;
        
    }
}
