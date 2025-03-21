package Problem2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Problem2 {
    
    public static <T> List<T> alternateCombine(List<Integer> list1, List<String> list2) {
                    List<T> combined = new ArrayList<>();
                    int size = Math.min(list1.size(), list2.size());
            
                    // add elements from both lists
                    for (int i = 0; i < size; i++) {
                        combined.add((T) list2.get(i));
                        combined.add((T) list1.get(i));
                    }
            
                    // add remaining elements if lists are unequal length
                    if (list1.size() > size) {
                        combined.addAll((Collection<? extends T>) list1.subList(size, list1.size()));
                    } else if (list2.size() > size) {
                        combined.addAll((Collection<? extends T>) list2.subList(size, list2.size()));
                }
        
                return combined;
            }
        
            public static void main(String[] args) {
                List<Integer> list1 = Arrays.asList(1, 2, 3);
                List<String> list2 = Arrays.asList("a", "b", "c");
        
                List<Object> result = alternateCombine(list1, list2);
                System.out.println(result);
            }

}

