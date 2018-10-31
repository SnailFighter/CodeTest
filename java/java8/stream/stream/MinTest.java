import java.util.List;
import java.util.Arrays;
import java.util.Optional;
import java.util.function.Function;
import java.util.Comparator;

public class MinTest {
    public static void main(String[] args) {
        List<Integer> lista = Arrays.asList(1,1,2,3,4,8,0,2,3,5,90,32,33,17,98,29);
        Optional<Integer> min = lista.stream().min((x,y)->x.compareTo(y));
        Optional<Integer> max = lista.stream().max((x,y)->x.compareTo(y));

        Optional<Integer> min1 = lista.stream().min(Comparator.comparing(Function.identity()));
        
        if(min.isPresent()){
            System.out.println(min.get());
        }
        if(max.isPresent()){
            System.out.println(max.get());
        }  
        if(min1.isPresent()){
            System.out.println(min1.get());
        }           
    }
}
/**
0
98
0
 */