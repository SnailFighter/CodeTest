import java.util.List;
import java.util.Arrays;

public class CountTest {
    public static void main(String[] args) {
        List<Integer> lista = Arrays.asList(1,2,3,4,8,0,2,3,5,90,32,33,17,98,29);

        System.out.println(lista.stream().count());
        System.out.println(lista.size());
        System.out.println(lista.stream().filter(x->x>30).count());

        /**
        15
        15
        4
         */

    }
}