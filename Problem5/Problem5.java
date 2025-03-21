package Problem5;

public class Problem5 {
    public static void findExpressions(String expr, int pos, int currentValue, int lastValue, int target) {
        if (pos > 9) {
            if (currentValue == target) {
                System.out.println(expr + " = " + target);
            }
            return;
        }

        findExpressions(expr + pos, pos + 1, currentValue - lastValue + (lastValue * 10 + pos), lastValue * 10 + pos, target);
        
        findExpressions(expr + " + " + pos, pos + 1, currentValue + pos, pos, target);
        
        findExpressions(expr + " - " + pos, pos + 1, currentValue - pos, -pos, target);
    }

    public static void main(String[] args) {
        findExpressions("1", 2, 1, 1, 100);
    }
}

