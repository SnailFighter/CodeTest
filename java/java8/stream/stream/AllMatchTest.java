import java.util.List;
import java.util.Arrays;
import java.util.function.Predicate;

public class AllMatchTest {
    public static void main(String[] args) {
        List<Integer> lista = Arrays.asList(1,2,3,4,8,0,2,3,5,90,32,33,17,98,29);

        System.out.println(lista.stream().allMatch(x->x*2>30));

        System.out.println(lista.stream().anyMatch(x->x*2>30));

        //System.out.println(lista.stream().allMatch(new ));

    
    }
}