import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.stream.Collectors;

class FilterTest {
    public static void main(String[] args) {
        List<Integer> lista = Arrays.asList(0,1,4,9,11,45,1,2,5,88,23,56,15);
        //大于10
        List listb = new ArrayList<Integer>();
        lista.forEach(i->
            i++   //这里的操作不会影响后面的内容
        ); 
        List listc = lista.stream().filter(i->i>10).collect(Collectors.toList());
        System.out.println(lista);//[0, 1, 4, 9, 11, 45, 1, 2, 5, 88, 23, 56, 15]
        System.out.println(listc); //[11, 45, 88, 23, 56, 15]
    }
}